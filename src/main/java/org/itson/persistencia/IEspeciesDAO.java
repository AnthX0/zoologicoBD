/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.List;
import org.itson.dominio.Especie;
import org.itson.dominio.Habitat;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IEspeciesDAO {
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Especie
     * @param especie Objeto a agregar
     * @return El objeto Especie agregado
     */
    public Especie agregar(Especie especie);
    /**
     * Método que elimina un objeto de tipo Especie
     * @param especie Objeto a eliminar
     * @return El objeto Especie eliminado
     */
    public Especie eliminar(Especie especie);
    /**
     * Método que crea una lista con todos los objetos Especie creados
     * @return La lista de objetos Especie
     */
    public List<Especie> consultarEspecies();
    /**
     * Método que crea un lista con objetos Especie de ciertos habitats
     * @param habitats Lista de habitats
     * @return La lista de objetos Especie
     */
    public List<Especie> consultarEspeciesPorHabitat(List<Habitat> habitats);
}
