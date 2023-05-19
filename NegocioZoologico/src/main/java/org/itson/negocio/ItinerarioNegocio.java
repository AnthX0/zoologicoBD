/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Zona;
import org.itson.persistencia.DAO.GuiasDAO;
import org.itson.persistencia.DAO.ItinerarioDAO;
import org.itson.persistencia.DAO.ZonaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ItinerarioNegocio {
    //MÉTODOS
    /**
     * Recupera los datos de todas las zonas existentes
     */
    public void recuperarZonas(){
        ZonaDAO zonadao = new ZonaDAO();
        zonadao.consultarZonas();
    }
    /**
     * Recupera los datos de todos los guias existentes
     */
    public void recuperarGuias(){
        GuiasDAO guiasdao = new GuiasDAO();
        guiasdao.consultarGuias();
    }
    /**
     * Verifica que la Zona elegida exista en la base
     * @param zona Zona a verificar
     */
    public void verificarZonaElegida(Zona zona) {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        List<Zona> zonas = new ArrayList<>();
        for (Itinerario itinerario : itinerarios) {
            List<Zona> listaZonas = itinerario.getZonas();
            zonas.addAll(listaZonas);
        }
        for (Zona zonass : zonas) {
            String nombreZona = zonass.getNombre();
            Float expansionZona = zonass.getExtension();
            for (Itinerario itinerario : itinerarios) {
                if (!zona.getNombre().equals(nombreZona) && 
                        !zona.getExtension().equals(expansionZona)) {
                    JOptionPane.showMessageDialog(null, 
                            "Zona no existente", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }
    /**
     * Método que verifica que el horario elegido sea correcto
     * @param horario Horario a verificar
     */
    public void verificarHorarioElegido(Date horario){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (!itinerario.getFechaHoraItinerario().equals(horario)) {
                JOptionPane.showMessageDialog(null, 
                        "Horario no existente", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    /**
     * Método que verifica si la longitud del recorrido es menor a 1.5km
     * @param longitud Longitud a verificar
     */
    public void verificarLongitudRecorrido(Float longitud){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getLongitud() >= 1.5) {
                JOptionPane.showMessageDialog(null, 
                        "Longitud no válido", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    /**
     * Método que verifica si el número de visitantes es menor de 30
     * @param numero Número de visitantes a verificar
     */
    public void verificarNumVisitantes(Integer numero){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getMaxNumVisitantes() >= 30) {
                JOptionPane.showMessageDialog(null, 
                        "Numero de visitantes no válido", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    /**
     * Método que verifica el nombre del itinerario no exista en la base
     * @param nombre Nombre del itinerario a verificar
     */
    public void verificarNombreItinerario(String nombre){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, 
                        "Nombre existente", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
}