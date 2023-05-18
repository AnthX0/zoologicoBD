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
import org.itson.persistencia.FachadaPersistencia;
import org.itson.presentacion.RegistrarHabitatForm;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class FachadaNegocio {
    // ATRIBUTOS
    ItinerarioNegocio itiNeg = new ItinerarioNegocio();
    HabitatNegocio habNeg = new HabitatNegocio();
    QuejaNegocio quejaNeg = new QuejaNegocio();
    EspecieNegocio espNeg = new EspecieNegocio();
    

    // MÉTODOS
    public void recuperarZonasYGuias() {
        itiNeg.recuperarGuias();
        itiNeg.recuperarZonas();
    }

    public void buscarItinerarioUltimoMes() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        System.out.println(itinerariodao.consultarItinerariosUltimoMes());
    }
    
    public void buscarItinerarioExistente(String nombre){
        
    }
    
    public void mostrarItinerarioExistente(){
                
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
    /**
     * Método que valida los datos de un itinerario
     * DATOS DE PRUEBA: CAMBIAR POR DATOS DE ITINERARIO FORM
     */
    public void validacionDatosItinerario(){
        itiNeg.verificarCamposLlenos("");
        itiNeg.verificarHorarioElegido(new Date());
        itiNeg.verificarLongitudRecorrido(Float.NaN);
        itiNeg.verificarNombreItinerario("");
        itiNeg.verificarNumVisitantes(Integer.SIZE);
        itiNeg.verificarZonaElegida(new Zona());
    }
    
    // QUEJA
    /**
     * Método que valida los datos de una queja
     * DATOS DE PRUEBA: CAMBIAR POR DATOS DE HABITAT FORM
     */
    public void validacionQueja() {
        quejaNeg.verificarNombreQueja("");
        quejaNeg.verificarCorreoQueja("");
        quejaNeg.verificarTelefonoQueja("");
    }
    
    // HABITAT
    /**
     * Método que valida los datos de un habitat DATOS DE PRUEBA: CAMBIAR POR
     * DATOS DE HABITAT FORM
     */
    public void validacionDatosHabitat(String nombre, String clima, String tipo) {
        boolean opcion = habNeg.verificarExistencia(new Habitat(nombre, clima, tipo));
        if (opcion == true) {
            FachadaPersistencia fachadap = new FachadaPersistencia();
            
            fachadap.guardarHabitat(new Habitat(nombre, clima, tipo));
        }

    }

    public boolean validarNombreHabitat(String nombre) {
        if (habNeg.verificarNombreHabitat(nombre) == true) {
            return false;
        }
        return true;
    }

    public void agregarHabitat(Habitat habitat) {
       
    }
}
