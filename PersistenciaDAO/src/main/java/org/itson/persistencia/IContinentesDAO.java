/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.List;
import org.itson.dominio.Continente;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IContinentesDAO {
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Continente
     * @param continente Objeto a agregar
     * @return El objeto Continente agregado
     */
    public Continente agregar(Continente continente);
    /**
     * Método que elimina un objeto de tipo Continente
     * @param continente Objeto a eliminar
     * @return El objeto Continente eliminado
     */
    public Continente eliminar(Continente continente);
    /**
     * Método que crea una lista con todos los objetos Continente creados
     * @return La lista de objetos Continente
     */
    public List<Continente> consultarContinentes();
}
