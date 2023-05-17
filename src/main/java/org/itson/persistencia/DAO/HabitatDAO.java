/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import org.itson.persistencia.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;
import org.itson.dominio.Persona;
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
        List<Habitat> habitats = new ArrayList<>();
        // Obtener la colección "Habitat" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("habitat");
        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();
        // Recorrer los documentos y mapearlos a objetos Habitat
        try (MongoCursor<Document> cursor = documentos.iterator()) {
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                // Crear una instancia de Habitat y asignar los valores del documento
                Habitat habitat = new Habitat();
                habitat.setId(documento.getObjectId("_id"));
                habitat.setNombre(documento.getString("nombre"));
                habitat.setClima(documento.getString("clima"));
                habitat.setTipoVegetacion(documento.getString("tipoVegetacion"));
                habitat.setContinentes(documento.getList("continentes", Continente.class));
                habitats.add(habitat);
            }
        }
        return habitats;
    }
    /**
     * Método que crea una lista con los objetos Habitat de ciertos continentes
     * @param continentes Lista de continentes
     * @return La lista de objetos Habitat
     */
    @Override
    public List<Habitat> consultarHabitatsPorContinente(List<Continente> continentes) {
        // Obtener la colección donde se guardan los habitats
        MongoCollection<Document> collection = baseDatos.getCollection("Habitat");
        // Crear una lista para almacenar los habitats consultados
        List<Habitat> habitats = new ArrayList<>();
        // Crear un filtro para buscar habitats que tengan los continentes especificados
        List<String> continentesIds = new ArrayList<>();
        for (Continente continente : continentes) {
            String continenteId = continente.getId().toString();
            continentesIds.add(continenteId);
        }
        Document filtro = new Document("continentes", new Document("$in", continentesIds));
        // Obtener un cursor para iterar sobre los documentos que cumplen con el filtro
        MongoCursor<Document> cursor = collection.find(filtro).iterator();
        // Recorrer los documentos y convertirlos a objetos Especie
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Habitat habitat = new Habitat();
            habitat.setId(documento.getObjectId("_id"));
            habitat.setNombre(documento.getString("nombre"));
            habitat.setClima(documento.getString("clima"));
            habitat.setTipoVegetacion(documento.getString("tipoVegetacion"));
            habitat.setContinentes(documento.getList("continentes", Continente.class));
            habitats.add(habitat);
        }
        // Cerrar el cursor
        cursor.close();
        // Devolver la lista de especies consultadas
        return habitats;
    }
}