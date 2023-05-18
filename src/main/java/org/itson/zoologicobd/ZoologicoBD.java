package org.itson.zoologicobd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.itson.dominio.Continente;
import org.itson.dominio.Cuidador;
import org.itson.dominio.Especie;
import org.itson.dominio.Guia;
import org.itson.dominio.Habitat;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Persona;
import org.itson.dominio.Queja;
import org.itson.dominio.Zona;
import org.itson.negocio.FachadaNegocio;
import org.itson.persistencia.DAO.ContinentesDAO;
import org.itson.persistencia.DAO.CuidadoresDAO;
import org.itson.persistencia.DAO.EspeciesDAO;
import org.itson.persistencia.DAO.GuiasDAO;
import org.itson.persistencia.DAO.HabitatDAO;
import org.itson.persistencia.DAO.ItinerarioDAO;
import org.itson.persistencia.DAO.PersonasDAO;
import org.itson.persistencia.DAO.ZonaDAO;
import org.itson.persistencia.DAO.QuejaDAO;
import org.itson.presentacion.pantallaPrincipal;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ZoologicoBD {
    public static void main(String[] args) {
          pantallaPrincipal ventana = new pantallaPrincipal();
          ventana.setVisible(true);

    }
}
