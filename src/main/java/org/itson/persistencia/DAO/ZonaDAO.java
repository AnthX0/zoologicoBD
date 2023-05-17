/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Especie;
import org.itson.dominio.Zona;
import org.itson.persistencia.Interfaces.IZonaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ZonaDAO implements IZonaDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public ZonaDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Zona
     * @param zona Objeto a agregar
     * @return El objeto Zona agregado
     */    
    @Override
    public Zona agregar(Zona zona) {
         // Obtener la colección "zonas" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("zona");
        // Crear un nuevo documento para la zona
        Document documentoZona = new Document();
        documentoZona.append("nombre", zona.getNombre());
        documentoZona.append("extension", zona.getExtension());
        // Convertir la lista de especies a documentos
        List<Document> especies = new ArrayList<>();
        for (Especie especie : zona.getEspecies()) {
            Document documentoEspecie = new Document();
            documentoEspecie.append("nombre", especie.getNombre());
            documentoEspecie.append("nombreCientifico", especie.getNombreCientifico());
            documentoEspecie.append("descripcion", especie.getDescripcion());
            // Agregar documento de especie a la lista
            especies.add(documentoEspecie);
        }
        documentoZona.append("especies", especies);
        // Insertar el documento en la colección
        collection.insertOne(documentoZona);
        // Establecer el id generado en el objeto zona
        return zona;
    }
    /**
     * Método que elimina un objeto de tipo Zona
     * @param zona Objeto a eliminar
     * @return El objeto Zona eliminado
     */
    @Override
    public Zona eliminar(Zona zona) {
        // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("zona");
        // Crear un filtro para encontrar la especie por su ID
        Document filtro = new Document("nombre", zona.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);
        // Devolver la especie eliminada
        return zona;
    }
    /**
     * Método que crea una lista con todos los objetos zona creados
     * @return La lista de objetos Zona
     */
    @Override
    public List<Zona> consultarZonas() {
        List<Zona> zonas = new ArrayList<>();
        // Obtener la colección "zonas" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("zona");
        // Obtener todos los documentos de la colección
        FindIterable<Document> documents = collection.find();
        // Recorrer los documentos y mapearlos a objetos Zona
        try (MongoCursor<Document> cursor = documents.iterator()) {
            while (cursor.hasNext()) {
                Document documentoZona = cursor.next();
                // Crear un objeto Zona y asignar los valores del documento
                Zona zona = new Zona();
                zona.setId(documentoZona.getObjectId("_id"));
                zona.setNombre(documentoZona.getString("nombre"));
                zona.setExtension(documentoZona.getDouble("extension").floatValue());
                // Obtener la lista de especies del documento
                List<Document> especiesDocumento = (List<Document>) documentoZona.get("especies");
                List<Especie> especies = new ArrayList<>();
                // Recorrer los documentos de especies y mapearlos a objetos Especie
                for (Document documentoEspecie : especiesDocumento) {
                    Especie especie = new Especie();
                    especie.setId(documentoEspecie.getObjectId("_id"));
                    especie.setNombre(documentoEspecie.getString("nombre"));
                    especie.setDescripcion(documentoEspecie.getString("descripcion"));
                    // Mapear otros atributos de Especie si es necesario
                    especies.add(especie);
                }
                // Asignar la lista de especies a la zona
                zona.setEspecies(especies);
                // Mapear la lista de especies si es necesario
                // Agregar la zona a la lista
                zonas.add(zona);
            }
        }
        return zonas;
    }
}