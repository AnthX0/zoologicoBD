/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class Persona {

    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private List<String> direccion;
    private Integer telefono;
    private Date fechaIngreso;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Persona() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando Id
     * @param nombre Nombre de la persona
     * @param direccion Dirección de la persona
     * @param telefono Teléfono de la persona
     * @param fechaIngreso Fecha de ingreso al zoológico
     */
    public Persona(String nombre, List<String> direccion, Integer telefono, 
            Date fechaIngreso) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id de la persona
     * @param nombre Nombre de la persona
     * @param direccion Dirección de la persona
     * @param telefono Teléfono de la persona
     * @param fechaIngreso Fecha de ingreso al zoológico
     */
    public Persona(ObjectId id, String nombre, List<String> direccion, 
            Integer telefono, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    // GETTERS Y SETTERS
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<String> getDireccion() {
        return direccion;
    }
    public void setDireccion(List<String> direccion) {
        this.direccion = direccion;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }
    /**
     * Método equals
     * @param obj Objeto a comparar
     * @return True si es igual, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Método toString
     *
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso + '}';
    }

}
