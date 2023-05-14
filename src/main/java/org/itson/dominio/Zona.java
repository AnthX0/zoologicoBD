/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class Zona {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private Float extension;
    private List<Especie> especies;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Zona() {
    }
    /**
     * Constructor que inicializa los atributos exceptuando id
     * @param nombre Nombre de la zona
     * @param extension Extensión
     * @param especies Especies que habitan en la zona
     */
    public Zona(String nombre, Float extension, List<Especie> especies) {
        this.nombre = nombre;
        this.extension = extension;
        this.especies = especies;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id de la zona
     * @param nombre Nombre de la zona
     * @param extension Extensión
     * @param especies Especies que habitan en la zona
     */
    public Zona(ObjectId id, String nombre, Float extension, 
            List<Especie> especies) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
        this.especies = especies;
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
    public Float getExtension() {
        return extension;
    }
    public void setExtension(Float extension) {
        this.extension = extension;
    }
    public List<Especie> getEspecies() {
        return especies;
    }
    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }

    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Zona other = (Zona) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Zona{" + "id=" + id + ", nombre=" + nombre + ", extension=" + 
                extension + ", especies=" + especies + '}';
    }
}