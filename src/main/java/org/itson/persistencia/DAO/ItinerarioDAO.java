
package org.itson.persistencia.DAO;

import com.mongodb.client.FindIterable;
import org.itson.persistencia.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.Document;
import org.itson.dominio.Guia;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Zona;
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
        MongoCollection<Document> collection = baseDatos.getCollection("itinerario");
        Document documentoItinerario = new Document();
        documentoItinerario.append("nombre", itinerario.getNombre());
        documentoItinerario.append("duracionRecorrido", itinerario.getDuracionRecorrido());
        documentoItinerario.append("longitud", itinerario.getLongitud());
        documentoItinerario.append("maxNumVisitantes", itinerario.getMaxNumVisitantes());
        GregorianCalendar fechaHoraItinerario = new GregorianCalendar(
                itinerario.getFechaHoraItinerario().getYear(),
                itinerario.getFechaHoraItinerario().getMonth() - 1, // El mes en GregorianCalendar es base 0
                itinerario.getFechaHoraItinerario().getDay(),
                itinerario.getFechaHoraItinerario().getHours(),
                itinerario.getFechaHoraItinerario().getMinutes()
        );

        // Obtener el timestamp en milisegundos
        long timestamp = fechaHoraItinerario.getTimeInMillis();
        documentoItinerario.append("fechaHoraItinerario", new Date(timestamp));
        collection.insertOne(documentoItinerario);
        return itinerario;
    }

    /**
     * Método que elimina un objeto de tipo Itinerario
     *
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
    
    public List<Itinerario> consultarItinerarios() {
        List<Itinerario> itinerarios = new ArrayList<>();
        // Obtener la colección "itinerario" de la base de datos
        MongoCollection<Document> collection = baseDatos.getCollection("itinerario");
        // Obtener todos los documentos de la colección
        FindIterable<Document> documentos = collection.find();
        // Recorrer los documentos y mapearlos a objetos Persona
        try (MongoCursor<Document> cursor = documentos.iterator()) {
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                // Crear una instancia de Itinerario y asignar los valores del documento
                Itinerario itinerario = new Itinerario();
                itinerario.setId(documento.getObjectId("_id"));
                itinerario.setNombre(documento.getString("nombre"));
                itinerario.setDuracionRecorrido(documento.getInteger("duracionRecorrido"));
                itinerario.setLongitud(documento.getDouble("longitud").floatValue());
                itinerario.setMaxNumVisitantes(documento.getInteger("maxNumVisitantes"));
                itinerario.setFechaHoraItinerario(documento.getDate("fechaHoraItinerario"));
                itinerario.setZonas(documento.getList("zonas", Zona.class));
                itinerario.setGuias(documento.getList("guias", Guia.class));
                itinerarios.add(itinerario);
            }
        }
        return itinerarios;
    }

    @Override
    public List<Itinerario> consultarItinerariosUltimoMes() {
        // Obtener la colección de itinerarios
        MongoCollection<Document> collection = baseDatos.getCollection("itinerario");

        // Consultar todos los itinerarios
        FindIterable<Document> iterable = collection.find();

        // Crear lista para almacenar todos los itinerarios
        List<Itinerario> todosItinerarios = new ArrayList<>();

        // Recorrer los resultados y convertirlos a objetos Itinerario
        for (Document documento : iterable) {
            // Crear el objeto Itinerario a partir del documento
            Itinerario itinerario = new Itinerario();
            itinerario.setId(documento.getObjectId("_id"));
            itinerario.setNombre(documento.getString("nombre"));
            itinerario.setDuracionRecorrido(documento.getInteger("duracionRecorrido"));
            itinerario.setLongitud(documento.getDouble("longitud").floatValue());
            itinerario.setMaxNumVisitantes(documento.getInteger("maxNumVisitantes"));
            itinerario.setFechaHoraItinerario(documento.getDate("fechaHoraItinerario"));
            itinerario.setZonas(documento.getList("zonas", Zona.class));
            itinerario.setGuias(documento.getList("guias", Guia.class));
            todosItinerarios.add(itinerario);
        }
        // Obtener la fecha del último mes
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, -1); // Restar 1 mes
        Date fechaUltimoMes = calendar.getTime();

        // Crear lista para almacenar los itinerarios del último mes
        List<Itinerario> itinerariosUltimoMes = new ArrayList<>();

        // Filtrar los itinerarios que coincidan con la fecha del último mes
        for (Itinerario itinerario : todosItinerarios) {
            if (itinerario.getFechaHoraItinerario().after(fechaUltimoMes)) {
                if (itinerario.getFechaHoraItinerario().getYear() == calendar.getTime().getYear()) {
                    itinerariosUltimoMes.add(itinerario);
                }
            }
        }

// Retornar la lista de itinerarios del último mes
        return itinerariosUltimoMes;
    }
}