/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;
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
    public void verificarCamposLlenos(String campos){
    }

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
                if (zona.getNombre().equals(nombreZona) && zona.getExtension().equals(expansionZona)) {
                    JOptionPane.showMessageDialog(null, "Zona existente", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }
    public void verificarHorarioElegido(Date horario){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getFechaHoraItinerario().equals(horario)) {
                JOptionPane.showMessageDialog(null, "Horario existente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
    }
    public void verificarLongitudRecorrido(Float longitud){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getLongitud().equals(longitud)) {
                JOptionPane.showMessageDialog(null, "Longitud existente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    public void verificarNumVisitantes(Integer numero){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getMaxNumVisitantes().equals(numero)) {
                JOptionPane.showMessageDialog(null, "Numero de visitantes existente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    public void verificarNombreItinerario(String nombre){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> itinerarios = itinerariodao.consultarItinerarios();
        for (Itinerario itinerario : itinerarios) {
            if (itinerario.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, "Nombre existente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
}
