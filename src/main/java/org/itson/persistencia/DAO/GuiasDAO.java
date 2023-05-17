/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Cuidador;
import org.itson.dominio.Guia;
import org.itson.dominio.Itinerario;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.IGuiasDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class GuiasDAO implements IGuiasDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public GuiasDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    @Override
    public Guia agregar(Guia guia) {
        // Obtener la colección "guia" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("guia");

        // Crear un nuevo documento para el guia
        Document documentoGuia= new Document();
        documentoGuia.append("nombre", guia.getNombre());
        documentoGuia.append("direccion", guia.getDireccion());
        documentoGuia.append("telefono", guia.getTelefono());
        documentoGuia.append("fechaIngreso", guia.getFechaIngreso());
        documentoGuia.append("itinerarios", guia.getItinerarios());

        // Insertar el documento en la colección
        collection.insertOne(documentoGuia);
        return guia;
    }

    @Override
    public Guia eliminar(Guia guia) {
       // Obtener la colección donde se guardan las guia
        MongoCollection<Document> collection = baseDatos.getCollection("guia");

        // Crear un filtro para encontrar la guia por su ID
        Document filtro = new Document("nombre", guia.getNombre());
        // Eliminar la guia de la colección
        collection.deleteOne(filtro);

        // Devolver la guia eliminada
        return guia;
    }

    @Override
    public List<Guia> consultarGuias() {
        List<Guia> guias = new ArrayList<>();

        // Obtener la colección "cuidadores" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("guia");

        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();

        // Recorrer los documentos y convertirlos a objetos Cuidador
        for (Document documento : documentos) {
            Guia guia = new Guia();
            guia.setId(documento.getObjectId("_id"));
            guia.setNombre(documento.getString("nombre"));
            guia.setDireccion(documento.getList("direccion", String.class));
            guia.setTelefono(documento.getInteger("telefono"));
            guia.setFechaIngreso(documento.getDate("fechaIngreso"));

//faltan las listas
            guias.add(guia);
        }

        return guias;
    }
    @Override
    public List<Guia> consultarGuiasPorItinerario(Itinerario itinerario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}