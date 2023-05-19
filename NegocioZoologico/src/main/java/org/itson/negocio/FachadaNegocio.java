package org.itson.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Habitat;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Queja;
import org.itson.dominio.Zona;
import org.itson.persistencia.DAO.ItinerarioDAO;
import org.itson.persistencia.FachadaPersistencia;

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
    // ITINERARIO
    /**
     * Método que recupera las zonas y los guias existentes
     */
    public void recuperarZonasYGuias() {
        itiNeg.recuperarGuias();
        itiNeg.recuperarZonas();
    }
    /**
     * Método que busca un itinerario existente en la base de datos
     * @param nombre 
     */
    public void buscarItinerarioExistente(String nombre){
        
    }
    /**
     * Método que muestra el itinerario en caso de que exista
     */
    public void mostrarItinerarioExistente(){
                
    }
    /**
     * Método que valida los datos de un itinerario
     * @param horario
     * @param longitud
     * @param nombre
     * @param numVisitantes
     * @param zona
     */
    public void validacionDatosItinerario(Date horario, Float longitud, 
            String nombre, Integer numVisitantes, Zona zona){
        itiNeg.verificarHorarioElegido(horario);
        itiNeg.verificarLongitudRecorrido(longitud);
        itiNeg.verificarNombreItinerario(nombre);
        itiNeg.verificarNumVisitantes(numVisitantes);
        itiNeg.verificarZonaElegida(zona);
    }
    
    // QUEJA
    /**
     * Método que busca un itinerario existente del último mes
     */
    public void buscarItinerarioUltimoMes() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        System.out.println(itinerariodao.consultarItinerariosUltimoMes());
    }
    /**
     * Método que llena una lista con los nombre de los itinerarios
     * @return Una lista de nombres de itinerarios
     */
    public List<String> llenarListaNombreItinerarios() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> lista = itinerariodao.consultarItinerarios();
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Error al recuperar los itinerarios", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        List<String> listanombres = new ArrayList<>();;
        for (int i = 0; i < lista.size(); i++) {
            listanombres.add(lista.get(i).getNombre());
        }
        return listanombres;
    }
    /**
     * Método que llena una lista con las fechas de los itinerario
     * @return Una lista con las fechas de los itinerarios
     */
    public List<Date> llenarListaItinerarioFechaDia() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> lista = itinerariodao.consultarItinerarios();
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Error al recuperar los itinerarios", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        List<Date> listafechadia = new ArrayList<>();;
        for (int i = 0; i < lista.size(); i++) {
            listafechadia.add(lista.get(i).getFechaHoraItinerario());
        }
        return listafechadia;
    }
    /**
     * Método que llena una lista con los horarios de los itinerarios
     * @return Una lista con los horarios de los itinerarios
     */
    public List<Date> llenarListaItinerarioHora() {
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        List<Itinerario> lista = itinerariodao.consultarItinerarios();
        if (lista == null || lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                    "Error al recuperar los itinerarios", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        List<Date> listafechadia = new ArrayList<>();;
        for (int i = 0; i < lista.size(); i++) {
            listafechadia.add(lista.get(i).getFechaHoraItinerario());
        }
        return listafechadia;
    }
    /**
     * Método que valida los datos de una queja
     * @param nombre
     * @param correo
     * @param telefono
     */
    public void validacionQueja(String nombre, String telefono, String correo) {
        boolean opc = quejaNeg.verificarNombreQueja(nombre);
        boolean opc2 = quejaNeg.verificarTelefonoQueja(telefono);
        boolean opc3 = quejaNeg.verificarCorreoQueja(correo);
        if (opc == true && opc2 == true && opc3 == true) {
            FachadaPersistencia fachadaP = new FachadaPersistencia();
            fachadaP.guardarQueja(new Queja(nombre, telefono, correo));
        }
    }
    
    // HABITAT
    /**
     * Método que valida los datos de un habitat DATOS DE PRUEBA: CAMBIAR POR
     * DATOS DE HABITAT FORM
     * @param nombre
     * @param clima
     * @param tipo
     */
    public void validacionDatosHabitat(String nombre, String clima, String tipo) {
        boolean opcion = habNeg.verificarExistencia(new Habitat(nombre, clima, 
                tipo));
        if (opcion == true) {
            FachadaPersistencia fachadap = new FachadaPersistencia();
            fachadap.guardarHabitat(new Habitat(nombre, clima, 
                    tipo));
        }
    }
    /**
     * Método que valida si el nombre del habitat existe
     * @param nombre Nombre del habitat
     * @return False si existe, true en caso de que no
     */
    public boolean validarNombreHabitat(String nombre) {
        if (habNeg.verificarNombreHabitat(nombre) == true) {
            return false;
        }
        return true;
    }
}