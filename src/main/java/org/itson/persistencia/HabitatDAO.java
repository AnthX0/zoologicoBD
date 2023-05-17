/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;

/**
 *
 * @author DELL User
 */
public class HabitatDAO implements IHabitatsDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public HabitatDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

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

    @Override
    public List<Habitat> consultarHabitats() {

        return null;

    }

    @Override
    public List<Habitat> consultarHabitatsPorContinente(List<Continente> continentes) {

        return null;

    }
}
