/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import org.itson.dominio.Especie;
import org.itson.dominio.Habitat;
import org.itson.dominio.Itinerario;
import org.itson.dominio.Queja;
import org.itson.persistencia.DAO.EspeciesDAO;
import org.itson.persistencia.DAO.HabitatDAO;
import org.itson.persistencia.DAO.ItinerarioDAO;
import org.itson.persistencia.DAO.QuejaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class FachadaPersistencia {
    // MÉTODOS
    /**
     * Método que guarda un habitat en la base de datos
     * @param habitat Habitat a guardar
     */
    public void guardarHabitat(Habitat habitat){
        HabitatDAO habitatdao = new HabitatDAO();
        habitatdao.agregar(habitat);
    }
    /**
     * Método que guarda una especie en la base de datos
     * @param especie Especie a guardar
     */
    public void guardarEspecie(Especie especie){
        EspeciesDAO especiedao = new EspeciesDAO();
        especiedao.agregar(especie);
    }
    /**
     * Método que guarda un itinerario en la base de datos
     * @param itinerario Itinerario a guardar
     */
    public void guardarItinerario(Itinerario itinerario){
        ItinerarioDAO itinerariodao = new ItinerarioDAO();
        itinerariodao.agregar(itinerario);
    }
    /**
     * Método que guarda una queja en la base de datos
     * @param queja Queja a guardar
     */
    public void guardarQueja(Queja queja){
        QuejaDAO quejadao =  new QuejaDAO();
        quejadao.agregar(queja);
    }
}