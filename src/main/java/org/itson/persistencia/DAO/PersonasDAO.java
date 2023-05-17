
package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Persona;
import org.itson.persistencia.Interfaces.IPersonasDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class PersonasDAO implements IPersonasDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public PersonasDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Persona
     * @param persona Objeto a agregar
     * @return El objeto Persona agregado
     */
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
    /**
     * Método que elimina un objeto de tipo Persona
     * @param persona Objeto a eliminar
     * @return El objeto Persona eliminado
     */
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
    /**
     * Método que crea una lista con todos los objetos Persona creados
     * @return La lista de objetos Persona
     */
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