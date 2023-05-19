/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.persistencia;

import org.itson.dominio.Cuidador;
import org.itson.dominio.Guia;
import org.itson.dominio.Persona;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class PersonasFactory {
    // MÉTODOS
    public static Persona getPersona(String tipo){
        if (tipo.equalsIgnoreCase("Cuidador")){
            return new Cuidador();
        } else if(tipo.equalsIgnoreCase("Guia")){
            return new Guia();
        }
        return null;
    }
}
