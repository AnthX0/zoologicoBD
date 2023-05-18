package org.itson.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Guia;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Zona;
import org.itson.persistencia.DAO.GuiasDAO;
import org.itson.persistencia.DAO.ItinerarioDAO;
import org.itson.persistencia.DAO.ZonaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class FachadaNegocio {

    // MÉTODOS
    public void recuperarZonasYGuias() {
        this.recuperarGuias();
        this.recuperarZonas();
    }

    public void recuperarZonas() {
        ZonaDAO zonadao = new ZonaDAO();
        zonadao.consultarZonas();
    }

    public void recuperarGuias() {
        GuiasDAO guiasdao = new GuiasDAO();
        guiasdao.consultarGuias();
    }

    public void buscarItinerarioUltimoMes() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        System.out.println(itinerariodao.consultarItinerariosUltimoMes());
    }

    public List<String> llenarListaNombreItinerarios() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> lista = itinerariodao.consultarItinerarios();
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al recuperar los itinerarios", "Error", JOptionPane.ERROR_MESSAGE);
        }
        List<String> listanombres = new ArrayList<>();;
        for (int i = 0; i < lista.size(); i++) {
            listanombres.add(lista.get(i).getNombre());
        }
        return listanombres;
    }

    public List<Date> llenarListaItinerarioFechaDia() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> lista = itinerariodao.consultarItinerarios();
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al recuperar los itinerarios", "Error", JOptionPane.ERROR_MESSAGE);
        }

        List<Date> listafechadia = new ArrayList<>();;
        for (int i = 0; i < lista.size(); i++) {
            listafechadia.add(lista.get(i).getFechaHoraItinerario());
        }
        return listafechadia;
    }

    public List<Date> llenarListaItinerarioHora() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> lista = itinerariodao.consultarItinerarios();
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al recuperar los itinerarios", "Error", JOptionPane.ERROR_MESSAGE);
        }
        List<Date> listafechadia = new ArrayList<>();;
        for (int i = 0; i < lista.size(); i++) {
            listafechadia.add(lista.get(i).getFechaHoraItinerario());
        }
        return listafechadia;
    }
}
