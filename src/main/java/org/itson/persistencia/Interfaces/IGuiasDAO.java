/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia.Interfaces;

import org.itson.persistencia.*;
import java.util.List;
import org.itson.dominio.Guia;
import org.itson.dominio.Itinerario;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IGuiasDAO {
    // MÉTODOS
    /**
     * Método que crea un objeto de tipo Guia
     * @param guia Objeto a agregar
     * @return El objeto Guia agregado
     */
    public Guia agregar(Guia guia);
    /**
     * Método que elimina un objeto de tipo Guia
     * @param guia Objeto a eliminar
     * @return El objeto Guia eliminado
     */
    public Guia eliminar(Guia guia);
    /**
     * Método que crea un lista con todos los objetos Guia creados
     * @return La lista de objetos Guia
     */
    public List<Guia> consultarGuias();
    /**
     * Método que crea una lista con objetos Guia que coincidan con el
     * itinerario que está en el parámetro
     * @param itinerario Itinerario a buscar
     * @return La lista de objetos Guia
     */
    public List<Guia> consultarGuiasPorItinerario(Itinerario itinerario);
}
