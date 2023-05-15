/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class Itinerario {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private Integer duracionRecorrido;
    private Float longitud;
    private Integer maxNumVisitantes;
    private Date fechaHoraItinerario;
    private List<Zona> zonas;
    private List<Persona> guias;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Itinerario() {
    }
    /**
     * Constructor que inicializa los atributos exceptuando id
     * @param nombre Nombre del itinerario
     * @param duracionRecorrido Duración del recorrido
     * @param longitud Longitud del recorrido
     * @param maxNumVisitantes Máximo número de visitantes de un itinerario
     * @param fechaHoraItinerario Fecha y hora del itinerario
     */
    public Itinerario(String nombre, Integer duracionRecorrido, Float longitud, 
            Integer maxNumVisitantes, Date fechaHoraItinerario) {
        this.nombre = nombre;
        this.duracionRecorrido = duracionRecorrido;
        this.longitud = longitud;
        this.maxNumVisitantes = maxNumVisitantes;
        this.fechaHoraItinerario = fechaHoraItinerario;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id del itinerario
     * @param nombre Nombre del itinerario
     * @param duracionRecorrido Duración del recorrido
     * @param longitud Longitud del recorrido
     * @param maxNumVisitantes Máximo número de visitantes de un itinerario
     * @param fechaHoraItinerario Fecha y hora del itinerario
     */
    public Itinerario(ObjectId id, String nombre, Integer duracionRecorrido, 
            Float longitud, Integer maxNumVisitantes, 
            Date fechaHoraItinerario) {
        this.id = id;
        this.nombre = nombre;
        this.duracionRecorrido = duracionRecorrido;
        this.longitud = longitud;
        this.maxNumVisitantes = maxNumVisitantes;
        this.fechaHoraItinerario = fechaHoraItinerario;
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
    public Integer getDuracionRecorrido() {
        return duracionRecorrido;
    }
    public void setDuracionRecorrido(Integer duracionRecorrido) {
        this.duracionRecorrido = duracionRecorrido;
    }
    public Float getLongitud() {
        return longitud;
    }
    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }
    public Integer getMaxNumVisitantes() {
        return maxNumVisitantes;
    }
    public void setMaxNumVisitantes(Integer maxNumVisitantes) {
        this.maxNumVisitantes = maxNumVisitantes;
    }
    public Date getFechaHoraItinerario() {
        return fechaHoraItinerario;
    }
    public void setFechaHoraItinerario(Date fechaHoraItinerario) {
        this.fechaHoraItinerario = fechaHoraItinerario;
    }
    public List<Zona> getZonas() {
        return zonas;
    }
    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }
    public List<Persona> getGuias() {
        return guias;
    }
    public void setGuias(List<Persona> guias) {
        this.guias = guias;
    }
    
    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Itinerario other = (Itinerario) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase
     */
    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + 
                ", duracionRecorrido=" + duracionRecorrido + ", longitud=" + 
                longitud + ", maxNumVisitantes=" + maxNumVisitantes + 
                ", fechaHoraItinerario=" + fechaHoraItinerario + ", zonas=" + 
                zonas + ", guias=" + guias + '}';
    }
}