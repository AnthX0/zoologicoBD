/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.negocio;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IQuejaNegocio {
    // MÉTODOS
    public void guardarQueja(String queja, String correoElectronico, String telefono);
    public void validacionQueja(String queja, String correoElectronico, String telefono);
}