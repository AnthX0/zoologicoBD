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
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ContinentesDAO implements IContinentesDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public ContinentesDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Continente
     * @param continente Objeto a agregar
     * @return El objeto Continente agregado
     */    
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
    /**
     * Método que elimina un objeto de tipo Continente
     * @param continente Objeto a eliminar
     * @return El objeto Continente eliminado
     */
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
    /**
     * Método que crea una lista con todos los objetos Continente creados
     * @return La lista de objetos Continente
     */
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