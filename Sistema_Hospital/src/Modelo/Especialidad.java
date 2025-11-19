/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Especialidad {
    private int med_esp_id;
    private String med_esp_nombre;
    private String med_esp_descripcion;

    public Especialidad() {
    }

    public Especialidad(int med_esp_id, String med_esp_nombre, String med_esp_descripcion) {
        this.med_esp_id = med_esp_id;
        this.med_esp_nombre = med_esp_nombre;
        this.med_esp_descripcion = med_esp_descripcion;
    }

    public int getMed_esp_id() {
        return med_esp_id;
    }

    public void setMed_esp_id(int med_esp_id) {
        this.med_esp_id = med_esp_id;
    }

    public String getMed_esp_nombre() {
        return med_esp_nombre;
    }

    public void setMed_esp_nombre(String med_esp_nombre) {
        this.med_esp_nombre = med_esp_nombre;
    }

    public String getMed_esp_descripcion() {
        return med_esp_descripcion;
    }

    public void setMed_esp_descripcion(String med_esp_descripcion) {
        this.med_esp_descripcion = med_esp_descripcion;
    }
    
    
    
    
}
