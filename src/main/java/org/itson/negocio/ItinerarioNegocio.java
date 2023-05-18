/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import java.util.Date;
import org.itson.dominio.Zona;
import org.itson.persistencia.DAO.GuiasDAO;
import org.itson.persistencia.DAO.ZonaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ItinerarioNegocio {
    //MÉTODOS
    /**
     * Recupera los datos de todas las zonas existentes
     */
    public void recuperarZonas(){
        ZonaDAO zonadao = new ZonaDAO();
        zonadao.consultarZonas();
    }
    /**
     * Recupera los datos de todos los guias existentes
     */
    public void recuperarGuias(){
        GuiasDAO guiasdao = new GuiasDAO();
        guiasdao.consultarGuias();
    }
    public void verificarCamposLlenos(String campos){
    }
    public void verificarZonaElegida(Zona zona){
    }
    public void verificarHorarioElegido(Date horario){
    }
    public void verificarLongitudRecorrido(Float longitud){
    }
    public void verificarNumVisitantes(Integer numero){
    }
    public void verificarNombreItinerario(String nombre){
    }
}
