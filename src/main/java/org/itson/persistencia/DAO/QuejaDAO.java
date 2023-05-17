/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import org.itson.persistencia.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Queja;
import org.itson.persistencia.Interfaces.IQuejaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class QuejaDAO implements IQuejaDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public QuejaDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Queja
     * @param queja Objeto a agregar
     * @return El objeto Queja agregado
     */    
    @Override
    public Queja agregar(Queja queja) {
        // Obtener la colección donde se guardarán las quejas
        MongoCollection<Document> collection = baseDatos.getCollection("queja");
        // Crear un nuevo documento con los datos de la queja
        Document quejaDocument = new Document();
        quejaDocument.append("nombre", queja.getNombre())
                .append("descripcion", queja.getDescripcion())
                .append("correoElectronico", queja.getEmail())
                .append("telefono", queja.getTelefono());
        // Insertar el documento en la colección
        collection.insertOne(quejaDocument);
        return queja;
    }
    /**
     * Método que elimina un objeto de tipo Queja
     * @param queja Objeto a eliminar
     * @return El objeto Queja eliminado
     */
    @Override
    public Queja eliminar(Queja queja) {
        // Obtener la colección donde se guardan las queja
        MongoCollection<Document> collection = baseDatos.getCollection("queja");
        // Crear un filtro para encontrar la queja por su ID
        Document filtro = new Document("nombre", queja.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);
        // Devolver la queja eliminada
        return queja;
    }
    /**
     * Método que guarda la queja creada, utilizando el correo y teléfono
     * @param queja Queja a guardar
     * @param correoElectronico Correo electrónico de la persona
     * @param telefono Teléfono de la persona
     */
    @Override
    public void guardarQueja(String queja, String correoElectronico, String telefono) {
        // Obtener la colección donde se guardarán las quejas
        MongoCollection<Document> collection = baseDatos.getCollection("queja");
        // Crear un nuevo documento con los datos de la queja
        Document quejaDocument = new Document();
        quejaDocument.append("queja", queja)
                .append("correoElectronico", correoElectronico)
                .append("telefono", telefono);
        // Insertar el documento en la colección
        collection.insertOne(quejaDocument);
    }
    /**
     * Método que crea una lista con todos los objetos Queja existentes
     * @return Una lista de objetos Queja
     */
    @Override
    public List<Queja> consultarQuejas() {
        List<Queja> listaQuejas = new ArrayList<>();
        // Obtener la colección "quejas" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("queja");
        // Realizar la consulta de todas las quejas
        FindIterable<Document> result = collection.find();
        // Iterar sobre el resultado de la consulta y crear objetos Queja
        for (Document document : result) {
            ObjectId id = document.getObjectId("_id");
            String nombre = document.getString("nombre");
            String descripcion = document.getString("descripcion");
            Integer telefono = document.getInteger("telefono");
            String email = document.getString("email");
            // Crear el objeto Queja y agregarlo a la lista
            Queja queja = new Queja(id, nombre, descripcion, telefono, email);
            listaQuejas.add(queja);
        }
        return listaQuejas;
    }
}