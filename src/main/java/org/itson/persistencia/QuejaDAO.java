/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Queja;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class QuejaDAO implements IQuejaDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public QuejaDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    @Override
    public Queja agregar(Queja queja) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Queja eliminar(Queja queja) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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

    @Override
    public List<Queja> consultarQuejas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
