/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.negocio;

import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dominio.Queja;
import org.itson.persistencia.DAO.QuejaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class QuejaNegocio {
    // MÉTODOS
    /**
     * Método que verifica si el nombre de una Queja ya existe
     * @param nombre Nombre a verificar
     * @return False si ya existe, True en caso contrario 
     */
    public boolean verificarNombreQueja(String nombre){
        QuejaDAO quejadao = new QuejaDAO();
        List<Queja> quejas = quejadao.consultarQuejas();
        for (Queja queja : quejas) {
            if (queja.getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null, 
                        "Nombre existente", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    /**
     * Método que verifica si el correo de una Queja ya existe
     * @param correo Correo a verificar
     * @return False si ya existe, True en caso contrario
     */
    public boolean verificarCorreoQueja(String correo){
        QuejaDAO quejadao = new QuejaDAO();
        List<Queja> quejas = quejadao.consultarQuejas();
        for (Queja queja : quejas) {
            if (queja.getCorreo().equals(correo)) {
                JOptionPane.showMessageDialog(null, 
                        "Correo existente", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    /**
     * Método que verifica si el telefono de una Queja ya existe
     * @param telefono Telefono a verificar
     * @return False si ya existe, True en caso contrario
     */
    public boolean verificarTelefonoQueja(String telefono){
        QuejaDAO quejadao = new QuejaDAO();
        List<Queja> quejas = quejadao.consultarQuejas();
        for (Queja queja : quejas) {
            if (queja.getTelefono().equals(telefono)) {
                JOptionPane.showMessageDialog(null, 
                        "Telefono existente", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
