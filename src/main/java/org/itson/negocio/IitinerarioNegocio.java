/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.negocio;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IitinerarioNegocio {
    // MÉTODOS
    public void buscarItinerarioUltimoMes();
    public void buscarItinerarioFechaDia();
    public void buscarItinerarioHora();
    public void llenarListaItinerarios(String nombre);
    public void llenarListaItinerariosFechaDia(String fecha, String dia);
    public void llenarListaItinerariosHora(String hora);
}