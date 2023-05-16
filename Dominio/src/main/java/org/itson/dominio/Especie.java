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
public class Especie {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private String nombreCientifico;
    private String descripcion;
    private List<Habitat> habitats;
    private List<Zona> zonas;
    private List<Persona> cuidadores;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Especie() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando Id
     * @param nombre Nombre común de la especie
     * @param nombreCientifico Nombre científico de la especie
     * @param descripcion Descripción breve de la especie
     */
    public Especie(String nombre, String nombreCientifico, 
            String descripcion) {    
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id de la especie
     * @param nombre Nombre común de la especie
     * @param nombreCientifico Nombre científico de la especie
     * @param descripcion Descripción breve de la especie
     */
    public Especie(ObjectId id, String nombre, String nombreCientifico, 
            String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
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
    public String getNombreCientifico() {
        return nombreCientifico;
    }
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Habitat> getHabitats() {
        return habitats;
    }
    public void setHabitats(List<Habitat> habitats) {
        this.habitats = habitats;
    }
    public List<Zona> getZonas() {
        return zonas;
    }
    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }
    public List<Persona> getCuidadores() {
        return cuidadores;
    }
    public void setCuidadores(List<Persona> cuidadores) {
        this.cuidadores = cuidadores;
    }

    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Especie other = (Especie) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nombre=" + nombre + 
                ", nombreCientifico=" + nombreCientifico + ", descripcion=" + 
                descripcion + ", habitats=" + habitats + ", zonas=" + zonas + 
                ", cuidadores=" + cuidadores + '}';
    }
}