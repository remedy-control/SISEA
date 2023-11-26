/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Localidad;
import com.example.demo.entity.Usuario;
import com.google.gson.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/Controlador")
public class ControladorLocalidad {

    @PostMapping(value = "/localidades")
    public Localidad localidades(Usuario usuario) throws IOException {
        
        //Se aplica el consumo para consultar las localidades
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"usuario\": \""+usuario.getUsuario()+"\"\r\n}");
        Request request = new Request.Builder()
                .url("http://10.119.160.221:9086/sgaremedy/api/listaLocalidades")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String Json = response.body().string();
        Gson gson = new Gson();
        JsonObject gsonobject = gson.fromJson(Json, JsonObject.class);
        JsonElement data = gsonobject.get("listLocalidades");
        JsonArray jsonArray = data.getAsJsonArray();
        
        //Se generan arreglos para cada uno de los datos
        List<String> list=new ArrayList<>();
        List<String> clave=new ArrayList<>();
        List<String> nombre=new ArrayList<>();
        List<Integer> activo=new ArrayList<>();
        
        //Se iteran los datos y se almacenan en cada uno de los datos correspondientes
        for(int i=0; i<jsonArray.size();i++){
            list.add(jsonArray.get(i).toString());
            JsonObject propertiesJson = gson.fromJson(list.get(i),JsonObject.class);
            JsonElement Clave = propertiesJson.get("clave");
            JsonElement Nombre = propertiesJson.get("nombre");
            JsonElement Activo = propertiesJson.get("activo");

            clave.add(Clave.toString().replaceAll("\"", ""));
            nombre.add(Nombre.toString().replaceAll("\"", ""));
            activo.add(Activo.getAsInt());
        }
        
        Localidad localidad=new Localidad(clave,nombre,activo);
//        System.out.println("Nombres: "+localidad.getNombre().get(0));
//        System.out.println("Clave: "+localidad.getClave().get(0));
//        System.out.println("Activo: "+localidad.getActivo().get(0));
        
        return localidad;
        
        }
    }
