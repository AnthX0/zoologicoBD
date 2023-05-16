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
public class QuejaDAO implements IQuejaDAO{

    @Override
    public Queja agregar(Queja queja) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Queja eliminar(Queja queja) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void guardarQueja(String queja, String correoElectronico, String telefono) {
    }

    @Override
    public List<Queja> consultarQuejas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
