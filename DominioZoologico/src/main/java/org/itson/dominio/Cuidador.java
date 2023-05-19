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
public class Cuidador extends Persona {
    // ATRIBUTOS
    private List<Especie> especiesBasicas;
    private List<Especie> especiesExpertas;
    private Date fechaACargo;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Cuidador() {
    }
    /**
     * Constructor que inicializa los atributos de la clase padre
     * @param id Id de la persona
     * @param nombre Nombre de la persona
     * @param direccion Dirección de la persona
     * @param telefono Teléfono de la persona
     * @param fechaIngreso Fecha en la que ingresó al zoologico
     */
    public Cuidador(ObjectId id, String nombre, List<String> direccion, 
            String telefono, Date fechaIngreso) {
        super(id, nombre, direccion, telefono, fechaIngreso);
    }
    /**
     * Constructor que inicializa todos los atributos de la clase y los
     * de la clase padre
     * @param id Id de la persona
     * @param nombre Nombre de la persona
     * @param direccion Dirección de la persona
     * @param telefono Teléfono de la persona
     * @param fechaIngreso Fecha en la que ingresó al zoologico
     * @param especiesBasicas Especies en las que el cuidador 
     * se considera básico
     * @param especiesExpertas Especies en las que el cuidador 
     * se considera experto
     * @param fechaACargo Fecha en la que pusieron a cargo al cuidador
     */
    public Cuidador(ObjectId id, String nombre, List<String> direccion, 
            String telefono, Date fechaIngreso, List<Especie> especiesBasicas, 
            List<Especie> especiesExpertas, Date fechaACargo) {
        super(id, nombre, direccion, telefono, fechaIngreso);
        this.especiesBasicas = especiesBasicas;
        this.especiesExpertas = especiesExpertas;
        this.fechaACargo = fechaACargo;
    } 

    // GETTERS Y SETTERS
    public List<Especie> getEspeciesBasicas() {
        return especiesBasicas;
    }
    public void setEspeciesBasicas(List<Especie> especiesBasicas) {
        this.especiesBasicas = especiesBasicas;
    }
    public List<Especie> getEspeciesExpertas() {
        return especiesExpertas;
    }
    public void setEspeciesExpertas(List<Especie> especiesExpertas) {
        this.especiesExpertas = especiesExpertas;
    }
    public Date getFechaACargo() {
        return fechaACargo;
    }
    public void setFechaACargo(Date fechaACargo) {
        this.fechaACargo = fechaACargo;
    }
    
    // MÉTODOS
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Cuidador{" + "especiesBasicas=" + especiesBasicas + 
                ", especiesExpertas=" + especiesExpertas + ", fechaACargo=" 
                + fechaACargo + '}';
    }
}
