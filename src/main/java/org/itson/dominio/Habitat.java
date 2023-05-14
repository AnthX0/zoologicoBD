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
public class Habitat {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private String clima;
    private String tipoVegetacion;
    private List<Continente> continentes;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Habitat() {
    }
    /**
     * Constructor que inicializa los atributos de la clase exceptuando Id
     * @param nombre Nombre del habitat
     * @param clima Clima del habitat
     * @param tipoVegetacion Tipo de vegetación del habitat
     * @param continentes Lista de los continentes donde se encuentra el habitat
     */
    public Habitat(String nombre, String clima, String tipoVegetacion, 
            List<Continente> continentes) {
        this.nombre = nombre;
        this.clima = clima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentes = continentes;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id del habitat
     * @param nombre Nombre del habitat
     * @param clima Clima del habitat
     * @param tipoVegetacion Tipo de vegetación del habitat
     * @param continentes Lista de los continentes donde se encuentra el habitat
     */
    public Habitat(ObjectId id, String nombre, String clima, 
            String tipoVegetacion, List<Continente> continentes) {
        this.id = id;
        this.nombre = nombre;
        this.clima = clima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentes = continentes;
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
    public String getClima() {
        return clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public String getTipoVegetacion() {
        return tipoVegetacion;
    }
    public void setTipoVegetacion(String tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }
    public List<Continente> getContinentes() {
        return continentes;
    }
    public void setContinentes(List<Continente> continentes) {
        this.continentes = continentes;
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
        final Habitat other = (Habitat) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Habitat{" + "id=" + id + ", nombre=" + nombre + ", clima=" + 
                clima + ", tipoVegetacion=" + tipoVegetacion + 
                ", continentes=" + continentes + '}';
    }
}