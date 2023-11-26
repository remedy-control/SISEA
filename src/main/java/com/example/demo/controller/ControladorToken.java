
package com.example.demo.controller;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ControladorToken {
    
    @GetMapping(value = "/tokenRemedy")
    public String token() throws IOException {
        log.info("Ejecutando token");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "username=EX511912.telcel.mex.amx&password=vy6g08v#");
        Request request = new Request.Builder()
                .url("http://100.127.4.41:8008/api/jwt/login")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}