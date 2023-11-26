/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;


import com.example.demo.entity.Usuario;
import com.example.demo.service.InsertarLocalidades;

public class test {
    public static void main(String[] args) throws Exception {
       
        InsertarLocalidades IL=new InsertarLocalidades();
        Usuario vl= new Usuario("57229");
        
        //Insertar localidades al formulario AMX:SISEA:MenuLocalidades}
        IL.InsertLocalid_api(vl);
    }
}
