package org.example;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {

    public void conversao(){

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/f49a71ec7851fb5b3cfa4090/latest/BRL");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try{
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Resposta da API: " + response.body());

        }catch(Exception e){
            System.out.println("Ocoprreu um erro: " + e.getMessage());
        }

    }

}
