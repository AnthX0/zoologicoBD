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

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ZoologicoBD {
    public static void main(String[] args) {
          ItinerarioDAO idao = new ItinerarioDAO();
          Itinerario itinerario = new Itinerario("itinerario", 22, 3f, 24, new Date(2023, 4, 1, 3, 00));
          Itinerario itinerario2 = new Itinerario("itinerario", 22, 3f, 24, new Date(2022, 4, 2,3, 00));
          Itinerario itinerario3 = new Itinerario("itinerario", 22, 3f, 24, new Date(2024, 4, 4, 3, 00));
          System.out.println(itinerario.getFechaHoraItinerario());
          idao.agregar(itinerario);
          idao.agregar(itinerario2);
          idao.agregar(itinerario3);
          System.out.println(idao.consultarItinerariosUltimoMes());
          
        
          FachadaNegocio fn = new FachadaNegocio();

    }
}
