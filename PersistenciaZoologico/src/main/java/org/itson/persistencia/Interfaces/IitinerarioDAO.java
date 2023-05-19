/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Itinerario;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IitinerarioDAO {
    // MÉTODOS
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
     * Método que consulta todos los objetos Itinerario creados
     * @return La lista de itinerarios
     */
    public List<Itinerario> consultarItinerarios();
    /**
     * Método que consulta todos los itinerarios creados el último mesa
     * @return Una lista con los itinerarios
     */
    public List<Itinerario> consultarItinerariosUltimoMes();
}
