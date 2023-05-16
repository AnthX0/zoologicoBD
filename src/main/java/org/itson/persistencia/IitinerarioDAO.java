/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.Date;
import java.util.List;
import org.itson.dominio.Itinerario;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IitinerarioDAO {
    /**
     * Método que crea un objeto de tipo Itinerario
     * @param itinerario Objeto a agregar
     * @return El objeto Itinerario agregado
     */
    public Itinerario agregar(Itinerario itinerario);
    /**
     * Método que elimina un objeto de tipo Itinerario
     * @param itinerario Objeto a eliminar
     * @return El objeto Itinerario eliminado
     */
    public Itinerario eliminar(Itinerario itinerario);
    /**
     * Método que consulta todos los itinerarios creados el último mesa
     * @return Una lista con los itinerarios
     */
    public List<Itinerario> consultarItinerariosUltimoMes();
    /**
     * Método que consulta los itinerarios que coincidan con el parámetro dado
     * @param fechaHoraItinerario Fecha y hora del itinerario
     * @return Una lista con los itinerarios coincidentes
     */
    public List<Itinerario> consultarItinerariosPorFecha(
            Date fechaHoraItinerario);
}
