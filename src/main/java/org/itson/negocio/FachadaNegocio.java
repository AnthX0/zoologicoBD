/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import java.util.List;
import org.itson.dominio.Guia;
import org.itson.dominio.Zona;
import org.itson.persistencia.DAO.GuiasDAO;
import org.itson.persistencia.DAO.ZonaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class FachadaNegocio {
    // MÉTODOS
    public void recuperarZonasYGuias(){
        this.recuperarGuias();
        this.recuperarZonas();
    }
    
    public void recuperarZonas(){
        ZonaDAO zonadao = new ZonaDAO();
        zonadao.consultarZonas();
    }
    
    public void recuperarGuias(){
        GuiasDAO guiasdao = new GuiasDAO();
        guiasdao.consultarGuias();
    }
}