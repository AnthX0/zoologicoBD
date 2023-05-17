/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.Date;
import java.util.List;
import org.itson.dominio.Cuidador;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface ICuidadoresDAO {
    // MÉTODOS
    /**
     * Método que crea un objeto de tipo Cuidador
     * @param cuidador Objeto a agregar
     * @return El objeto Cuidador agregado
     */
    public Cuidador agregar(Cuidador cuidador);
    /**
     * Método que elimina un objeto de tipo Cuidador
     * @param cuidador Objeto a eliminar
     * @return El objeto Cuidador eliminado
     */
    public Cuidador eliminar(Cuidador cuidador);
    /**
     * Método que crea un lista con todos los objetos Cuidador creados
     * @return La lista de objetos Cuidador
     */
    public List<Cuidador> consultarCuidadores();
    /**
     * Método que crea una lista con los objetos Cuidador que coincidan
     * con la fecha establecida en el parámetro
     * @param fecha Fecha a establecer
     * @return La lista de objetos Cuidador
     */
    public List<Cuidador> consultarCuidadoresPorFecha(Date fecha);
}