/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;
import org.itson.persistencia.DAO.HabitatDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class HabitatNegocio {

    // MÉTODOS
    public boolean verificarExistencia(Habitat habitat) {
        HabitatDAO habitatdao = new HabitatDAO();
        List<Habitat> habitats = habitatdao.consultarHabitats();
        for (Habitat h : habitats) {
            if (h.getNombre().equals(habitat.getNombre())
                    && h.getClima().equals(habitat.getClima())
                    && h.getTipoVegetacion().equals(habitat.getTipoVegetacion())) {
                JOptionPane.showMessageDialog(null, "Habitat existente", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean verificarNombreHabitat(String nombre) {
        HabitatDAO habitatdao = new HabitatDAO();
        List<Habitat> habitats = habitatdao.consultarHabitats();
        for (Habitat habitat : habitats) {
            if (habitat.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, "Nombre existente", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public void verificarTipoHabitat(String tipo) {
        HabitatDAO habitatdao = new HabitatDAO();
        List<Habitat> habitats = habitatdao.consultarHabitats();
        for (Habitat habitat : habitats) {
            if (habitat.getTipoVegetacion().equals(tipo)) {
                JOptionPane.showMessageDialog(null, "Tipo de vegetación existente", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    public void verificarContinente(Continente continente) {
        HabitatDAO habitatdao = new HabitatDAO();
        List<Habitat> habitats = habitatdao.consultarHabitats();
        List<Continente> continentes = new ArrayList<>();
        for (Habitat habitat : habitats) {
            List<Continente> listaContinentes = habitat.getContinentes();
            continentes.addAll(listaContinentes);
        }

        for (Continente continentess : continentes) {
            String nombreContinente = continentess.getNombre();
            String descripcionContinente = continentess.getDescripcion();
            for (Habitat h : habitats) {
                if (continente.getNombre().equals(nombreContinente) && continente.getDescripcion().equals(descripcionContinente)) {
                    JOptionPane.showMessageDialog(null, "Continente existente", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }
}
