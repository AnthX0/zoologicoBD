/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class Guia extends Persona {
    // ATRIBUTOS
    private List<Itinerario> itinerarios;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Guia() {
    }
    /**
     * Constructor que inicializa los atributos de la clase padre
     * @param id Id de la persona
     * @param nombre Nombre de la persona
     * @param direccion Dirección de la persona
     * @param telefono Teléfono de la persona
     * @param fechaIngreso Fecha en la que ingresó al zoologico
     */
    public Guia(ObjectId id, String nombre, List<String> direccion, 
            Integer telefono, Date fechaIngreso) {
        super(id, nombre, direccion, telefono, fechaIngreso);
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * y los de la clase padre
     * @param id Id de la persona
     * @param nombre Nombre de la persona
     * @param direccion Dirección de la persona
     * @param telefono Teléfono de la persona
     * @param fechaIngreso Fecha en la que ingresó al zoologico
     * @param itinerarios Lista de itinerarios que maneja el guia
     */
    public Guia(ObjectId id, String nombre, List<String> direccion, 
            Integer telefono, Date fechaIngreso, List<Itinerario> itinerarios) {
        super(id, nombre, direccion, telefono, fechaIngreso);
        this.itinerarios = itinerarios;
    }

    // GETTERS Y SETTERS
    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }
    public void setItinerarios(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }

    // MÉTODOS
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Guia{" + "itinerarios=" + itinerarios + '}';
    }
}