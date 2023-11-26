/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

import java.util.List;



public class Localidad {
    private List<String> clave; 
    private List<String> nombre;
    private List<Integer> activo;

    public Localidad(List<String> clave, List<String> nombre, List<Integer> activo) {
        this.clave = clave;
        this.nombre = nombre;
        this.activo = activo;
    }

    public List<String> getClave() {
        return clave;
    }

    public void setClave(List<String> clave) {
        this.clave = clave;
    }

    public List<String> getNombre() {
        return nombre;
    }

    public void setNombre(List<String> nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getActivo() {
        return activo;
    }

    public void setActivo(List<Integer> activo) {
        this.activo = activo;
    }

    
}
