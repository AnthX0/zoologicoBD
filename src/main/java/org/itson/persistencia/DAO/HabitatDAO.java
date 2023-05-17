/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;
import org.itson.persistencia.Interfaces.IHabitatsDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class HabitatDAO implements IHabitatsDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;
    
    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public HabitatDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Habitat
     * @param habitat Objeto a agregar
     * @return El objeto Habitat agregado
     */    
    @Override
    public Habitat agregar(Habitat habitat) {
       // Obtener la colección "habitats" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("habitat");
        // Crear un nuevo documento para el habitat
        Document documentoHabitat = new Document();
        documentoHabitat.append("nombre", habitat.getNombre());
        documentoHabitat.append("clima", habitat.getClima());
        documentoHabitat.append("tipoVegetacion", habitat.getTipoVegetacion());
        documentoHabitat.append("continentes", habitat.getContinentes());
        // Agregar los continentes al documento
        if (habitat.getContinentes() != null) {
            documentoHabitat.append("continentes", habitat.getContinentes());
        }
        // Insertar el documento en la colección
        collection.insertOne(documentoHabitat);
        // Establecer el id generado en el objeto habitat
        habitat.setId(documentoHabitat.getObjectId("_id"));
        return habitat;
    }
    /**
     * Método que elimina un objeto de tipo Habitat
     * @param habitat Objeto a eliminar
     * @return El objeto Habitat eliminado
     */
    @Override
    public Habitat eliminar(Habitat habitat) {
         // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("habitat");
        // Crear un filtro para encontrar la especie por su ID
        Document filtro = new Document("nombre", habitat.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);
        // Devolver la especie eliminada
        return habitat;
    }
    /**
     * Método que crea una lista con todos los objetos Habitat creados
     * @return La lista de objetos Habitat
     */
    @Override
    public List<Habitat> consultarHabitats() {
        return null;
    }
    /**
     * Método que crea una lista con los objetos Habitat de ciertos continentes
     * @param continentes Lista de continentes
     * @return La lista de objetos Habitat
     */
    @Override
    public List<Habitat> consultarHabitatsPorContinente(List<Continente> continentes) {
        return null;
    }
}