package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Continente;
import org.itson.persistencia.Interfaces.IContinentesDAO;

/**
 *
 * @author DELL User
 */
public class ContinentesDAO implements IContinentesDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public ContinentesDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    @Override
    public Continente agregar(Continente continente) {
        // Obtener la colección "continentes" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("continente");

        // Crear un nuevo documento para el continente
        Document documentoContinente = new Document();
        documentoContinente.append("_id", new ObjectId());
        documentoContinente.append("nombre", continente.getNombre());
        documentoContinente.append("descripcion", continente.getDescripcion());

        // Insertar el documento en la colección
        collection.insertOne(documentoContinente);

        // Establecer el id generado en el objeto continente
        continente.setId(documentoContinente.getObjectId("_id"));

        return continente;
    }

    @Override
    public Continente eliminar(Continente continente) {
        // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("continente");

        // Crear un filtro para encontrar la especie por su ID
        Document filtro = new Document("nombre", continente.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);

        // Devolver la especie eliminada
        return continente;
    }

    @Override
    public List<Continente> consultarContinentes() {
        List<Continente> continentes = new ArrayList<>();

        MongoCollection<Document> collection = baseDatos.getCollection("continente");
        FindIterable<Document> documentos = collection.find();

        for (Document documento : documentos) {
            Continente continente = new Continente();
            continente.setId(documento.getObjectId("_id"));
            continente.setNombre(documento.getString("nombre"));
            continente.setDescripcion(documento.getString("descripcion"));

            continentes.add(continente);
        }

        return continentes;
    }

}
