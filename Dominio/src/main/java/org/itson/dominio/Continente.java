/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class Continente {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private String descripcion;
    
    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Continente() {
    }
    /**
     * Constructor que inicializa los atributos exceptuando Id
     * @param nombre Nombre del continente
     * @param descripcion Breve descripción del continente
     */
    public Continente(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id del continente
     * @param nombre Nombre del continente
     * @param descripcion Breve descripción del continente
     */
    public Continente(ObjectId id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Continente other = (Continente) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Continente{" + "id=" + id + ", nombre=" + nombre + 
                ", descripcion=" + descripcion + '}';
    }
}