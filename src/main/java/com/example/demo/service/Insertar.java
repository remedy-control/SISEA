
package com.example.demo.service;

import com.example.demo.controller.ControladorLocalidad;
import com.example.demo.controller.ControladorToken;
import com.example.demo.entity.Usuario;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Localidad")
public class Insertar {
    @PostMapping(value = "/InsertarRC")
    public String InsertarLocalidadesRC(@org.springframework.web.bind.annotation.RequestBody Usuario usuario) throws IOException {
        
        //Inicializamos el objeto de localidades.
        ControladorLocalidad cl = new ControladorLocalidad();
        List<String> Nombre = cl.localidades(usuario).getNombre();
        List<String> Clave = cl.localidades(usuario).getClave();
        List<Integer> Activo = cl.localidades(usuario).getActivo();

        System.out.println("longitud:" + cl.localidades(usuario).getActivo().size());
        //Creamos la iteracion que va a generar el consumo insert 
        for (int i=0;i<=Nombre.size()-1;i++) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url("http://10.119.79.190:8080/Remedy/servicios/RMDInsert?cSistema=TRANSFORMA&cForma=AMX:SISEA:MenuLocalidades&cColumnas='8'='" + usuario.getUsuario() + "' '536870913'='" + Clave.get(i) + "' '536870914'='" + Nombre.get(i) + "' '7'='" + Activo.get(i) + "'")
                    .method("POST", body)
                    .build();
            Response response = client.newCall(request).execute();
        }
        return "Se ha insertado los "+Nombre.size()+" del usuario: "+usuario.getUsuario();
    }
    
    @PostMapping(value = "/Insertar")
    public String InsertarLocalidades(@org.springframework.web.bind.annotation.RequestBody Usuario usuario) throws IOException {
               
        ControladorToken CT=new ControladorToken();
        //Inicializamos el objeto de localidades.
        ControladorLocalidad cl = new ControladorLocalidad();
        List<String> Nombre = cl.localidades(usuario).getNombre();
        List<String> Clave = cl.localidades(usuario).getClave();
        List<Integer> Activo = cl.localidades(usuario).getActivo();

        System.out.println("longitud:" + cl.localidades(usuario).getActivo().size());
//        System.out.println("ip: " + ip);

        for (int i = 0; i <= Nombre.size() - 1; i++) {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"values\":{\r\n        \"Usuario\":\""+usuario.getUsuario()+"\",\r\n        \"Nombre\":\""+Nombre.get(i)+"\",\r\n        \"Clave\":\""+Clave.get(i)+"\",\r\n        \"Status__c\":\""+Activo.get(i)+"\"\r\n    }\r\n}");
            Request request = new Request.Builder()
                    .url("http://100.127.4.47:8008/api/arsys/v1/entry/AMX:SISEA:MenuLocalidades?fields=values(1)")
                    .method("POST", body)
                    .addHeader("Authorization", "AR-JWT "+CT.token()+"")
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();}
        return "Se han insertado las "+Nombre.size()+" localidades del usuario: "+usuario.getUsuario();
    }
    
}
