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
public class Queja {
    // ATRIBUTOS
    private ObjectId id;
    private String nombre;
    private String descripcion;
    private Integer telefono;
    private String email;

    // CONSTRUCTORES
    /**
     * Constructor vacío
     */
    public Queja() {
    }
    /**
     * Constructor que inicializa los atributos exceptuando id
     * @param nombre Nombre de la queja
     * @param descripcion Descripción breve de la queja
     * @param telefono Teléfono de la persona realizando la queja
     * @param email Correo electrónico de la persona realizando la queja
     */
    public Queja(String nombre, String descripcion, Integer telefono, 
            String email) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.email = email;
    }
    /**
     * Constructor que inicializa todos los atributos de la clase
     * @param id Id de la queja
     * @param nombre Nombre de la queja
     * @param descripcion Descripción breve de la queja
     * @param telefono Teléfono de la persona realizando la queja
     * @param email Correo electrónico de la persona realizando la queja
     */
    public Queja(ObjectId id, String nombre, String descripcion, 
            Integer telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.email = email;
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
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // MÉTODOS
    /**
     * Método hashCode
     * @return Un código hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }
    /**
     * Método equals
     * @param obj Objeto a compara
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
        final Queja other = (Queja) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString
     * @return Una cadena con el valor de los atributos de la clase 
     */
    @Override
    public String toString() {
        return "Queja{" + "id=" + id + ", nombre=" + nombre + 
                ", descripcion=" + descripcion + ", telefono=" + telefono + 
                ", email=" + email + '}';
    } 
}