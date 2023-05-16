
package org.itson.persistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Persona;

/**
 *
 * @author DELL User
 */
public class PersonasDAO implements IPersonasDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public PersonasDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    @Override
    public Persona agregar(Persona persona) {
        MongoCollection<Document> collection = baseDatos.getCollection("persona");
        Document documentoPersona = new Document();
        documentoPersona.append("nombre", persona.getNombre());
        documentoPersona.append("direccion", persona.getDireccion());
        documentoPersona.append("telefono", persona.getTelefono());
        documentoPersona.append("fechaIngreso", persona.getFechaIngreso());
        collection.insertOne(documentoPersona);
        return persona;
    }

    @Override
    public Persona eliminar(Persona persona) {
        // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("persona");

        // Crear un filtro para encontrar la especie por su ID
        Document filtro = new Document("nombre", persona.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);

        // Devolver la especie eliminada
        return persona;
    }

    @Override
    public List<Persona> consultarPersonas() {
            List<Persona> personas = new ArrayList<>();

        // Obtener la colección "personas" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("persona");

        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Recorrer los documentos y mapearlos a objetos Persona
        try (MongoCursor<Document> cursor = documentos.iterator()) {
            while (cursor.hasNext()) {
                Document documento = cursor.next();

                // Crear una instancia de Persona y asignar los valores del documento
                Persona persona = new Persona();
                persona.setId(documento.getObjectId("_id"));
                persona.setNombre(documento.getString("nombre"));
                persona.setDireccion(documento.getList("direccion", String.class));
                persona.setTelefono(documento.getInteger("telefono"));
                persona.setFechaIngreso(documento.getDate("fechaIngreso"));

                personas.add(persona);
            }
        }

        return personas;
    }

}
