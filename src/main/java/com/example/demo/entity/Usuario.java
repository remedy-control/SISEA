/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

/**
 *
 * @author CONSULTOR
 */
public class Usuario {
    private String usuario;
    
    // for deserialisation
    public Usuario() {}
    
    
    public Usuario(String usuario) {
        this.usuario = usuario;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   
}
