/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

import java.util.List;
import org.itson.dominio.Queja;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IQuejaDAO {
    /**
     * Método que agrega un objeto de tipo Queja
     * @param queja Objeto a agregar
     * @return El objeto Queja agregado
     */
    public Queja agregar(Queja queja);
    /**
     * Método que elimina un objeto de tipo Queja
     * @param queja Objeto a eliminar
     * @return El objeto Queja eliminado
     */
    public Queja eliminar(Queja queja);
    /**
     * Método que guarda la queja creada, utilizando el correo y teléfono
     * @param queja Queja a guardar
     * @param correoElectronico Correo electrónico de la persona
     * @param telefono Teléfono de la persona
     */
    public void guardarQueja(String queja, String correoElectronico, String telefono);
    /**
     * Método que crea una lista con todos los objetos Queja existentes
     * @return Una lista de objetos Queja
     */
    public List<Queja> consultarQuejas();
}