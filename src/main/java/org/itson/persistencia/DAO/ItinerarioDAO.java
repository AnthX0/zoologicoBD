
package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.itson.dominio.Especie;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Persona;
import org.itson.dominio.Zona;
import org.itson.persistencia.Interfaces.IitinerarioDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ItinerarioDAO implements IitinerarioDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public ItinerarioDAO() {
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    @Override
    public Itinerario agregar(Itinerario itinerario) {

        return null;

    }

    @Override
    public Itinerario eliminar(Itinerario itinerario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Itinerario> consultarItinerariosUltimoMes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Itinerario> consultarItinerariosPorFecha(Date fechaHoraItinerario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
