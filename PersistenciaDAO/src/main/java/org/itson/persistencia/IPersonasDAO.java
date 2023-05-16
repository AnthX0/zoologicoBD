/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.List;
import org.itson.dominio.Persona;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IPersonasDAO {
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Persona
     * @param persona Objeto a agregar
     * @return El objeto Persona agregado
     */
    public Persona agregar(Persona persona);
    /**
     * Método que elimina un objeto de tipo Persona
     * @param persona Objeto a eliminar
     * @return El objeto Persona eliminado
     */
    public Persona eliminar(Persona persona);
    /**
     * Método que crea una lista con todos los objetos Persona creados
     * @return La lista de objetos Persona
     */
    public List<Persona> consultarPersonas();
}
