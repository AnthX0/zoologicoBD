/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.persistencia;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IitinerarioDAO {
    public void consultarItinerariosUltimoMes();
    public void consultarItinerarioFechaDia(String nombre);
    public void consultarItinerarioHora(String nombre);
}
