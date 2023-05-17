
package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Itinerario;
import org.itson.persistencia.Interfaces.IitinerarioDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ItinerarioDAO implements IitinerarioDAO {
    // ATRIBUTOS
    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    // CONSTRUCTORES
    /**
     * Constructor que inicializa una conexión a la base de datos
     */
    public ItinerarioDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    // MÉTODOS
    /**
     * Método que crea un objeto de tipo Itinerario
     * @param itinerario Objeto a agregar
     * @return El objeto Itinerario agregado
     */
    @Override
    public Itinerario agregar(Itinerario itinerario) {
        MongoCollection<Document> collection = baseDatos.getCollection("persona");
        Document documentoItinerario = new Document();
        documentoItinerario.append("nombre", itinerario.getNombre());
        documentoItinerario.append("duracionRecorrido", itinerario.getDuracionRecorrido());
        documentoItinerario.append("longitud", itinerario.getLongitud());
        documentoItinerario.append("maxNumVisitantes", itinerario.getMaxNumVisitantes());
        documentoItinerario.append("fechaHoraItinerario", itinerario.getFechaHoraItinerario());
        collection.insertOne(documentoItinerario);
        return itinerario;
    }
    /**
     * Método que elimina un objeto de tipo Itinerario
     * @param itinerario Objeto a eliminar
     * @return El objeto Itinerario eliminado
     */
    @Override
    public Itinerario eliminar(Itinerario itinerario) {
        MongoCollection<Document> collection = baseDatos.getCollection("itinerario");
        Document filtro = new Document("nombre", itinerario.getNombre());
        collection.deleteOne(filtro);
        return itinerario;
    }
    /**
     * Método que consulta todos los itinerarios creados el último mesa
     * @return Una lista con los itinerarios
     */
    @Override
    public List<Itinerario> consultarItinerariosUltimoMes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * Método que consulta los itinerarios que coincidan con el parámetro dado
     * @param fechaHoraItinerario Fecha y hora del itinerario
     * @return Una lista con los itinerarios coincidentes
     */
    @Override
    public List<Itinerario> consultarItinerariosPorFecha(Date fechaHoraItinerario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}