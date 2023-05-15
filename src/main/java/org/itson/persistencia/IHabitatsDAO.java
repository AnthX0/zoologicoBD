/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.List;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IHabitatsDAO {
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Habitat
     * @param habitat Objeto a agregar
     * @return El objeto Habitat agregado
     */
    public Habitat agregar(Habitat habitat);
    /**
     * Método que elimina un objeto de tipo Habitat
     * @param habitat Objeto a eliminar
     * @return El objeto Habitat eliminado
     */
    public Habitat eliminar(Habitat habitat);
    /**
     * Método que crea una lista con todos los objetos Habitat creados
     * @return La lista de objetos Habitat
     */
    public List<Habitat> consultarHabitats();
    /**
     * Método que crea una lista con los objetos Habitat de ciertos continentes
     * @param continentes Lista de continentes
     * @return La lista de objetos Habitat
     */
    public List<Habitat> consultarHabitatsPorContinente(
            List<Continente> continentes);
}
