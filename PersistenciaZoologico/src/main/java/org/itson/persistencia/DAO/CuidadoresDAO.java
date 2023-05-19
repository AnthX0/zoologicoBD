/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Cuidador;
import org.itson.persistencia.ConexionMongoDB;
import org.itson.persistencia.Interfaces.ICuidadoresDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class CuidadoresDAO implements ICuidadoresDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public CuidadoresDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que crea un objeto de tipo Cuidador
     * @param cuidador Objeto a agregar
     * @return El objeto Cuidador agregado
     */
    @Override
    public Cuidador agregar(Cuidador cuidador) {
        // Obtener la colección "cuidadores" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection(
                "cuidador");
        // Crear un nuevo documento para el cuidador
        Document documentoCuidador = new Document();
        documentoCuidador.append("nombre", cuidador.getNombre());
        documentoCuidador.append("direccion", cuidador.getDireccion());
        documentoCuidador.append("telefono", cuidador.getTelefono());
        documentoCuidador.append("fechaIngreso", 
                cuidador.getFechaIngreso());
        documentoCuidador.append("especiesBasicas", 
                cuidador.getEspeciesBasicas());
        documentoCuidador.append("especiesExpertas", 
                cuidador.getEspeciesExpertas());
        documentoCuidador.append("fechaACargo", 
                cuidador.getFechaACargo());
        // Insertar el documento en la colección
        collection.insertOne(documentoCuidador);
        // Establecer el id generado en el objeto cuidador
        return cuidador;
    }
    /**
     * Método que elimina un objeto de tipo Cuidador
     * @param cuidador Objeto a eliminar
     * @return El objeto Cuidador eliminado
     */
    @Override
    public Cuidador eliminar(Cuidador cuidador) {
        // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection(
                "cuidador");
        // Crear un filtro para encontrar la especie por su ID
        Document filtro = new Document("nombre", cuidador.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);
        // Devolver la especie eliminada
        return cuidador;
    }
    /**
     * Método que crea un lista con todos los objetos Cuidador creados
     * @return La lista de objetos Cuidador
     */
    @Override
    public List<Cuidador> consultarCuidadores() {
        List<Cuidador> cuidadores = new ArrayList<>();
        // Obtener la colección "cuidadores" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection(
                "cuidador");
        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();
        // Recorrer los documentos y convertirlos a objetos Cuidador
        for (Document documento : documentos) {
            Cuidador cuidador = new Cuidador();
            cuidador.setId(documento.getObjectId("_id"));
            cuidador.setNombre(documento.getString("nombre"));
            cuidador.setDireccion(documento.getList("direccion", 
                    String.class));
            cuidador.setTelefono(documento.getString("telefono"));
            cuidador.setFechaIngreso(documento.getDate(
                    "fechaIngreso"));
            //faltan las listas
            cuidadores.add(cuidador);
        }
        return cuidadores;
    }
    /**
     * Método que crea una lista con los objetos Cuidador que coincidan
     * con la fecha establecida en el parámetro
     * @param fecha Fecha a establecer
     * @return La lista de objetos Cuidador
     */
    @Override
    public List<Cuidador> consultarCuidadoresPorFecha(Date fecha) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}