package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GeradorArquivo {

    public void salvaJson(String moeda, double valorConvertido) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(Map.of("moeda", moeda, "valorConvertido", valorConvertido));

        try(FileWriter escrita = new FileWriter("resultado.json")){
            escrita.write(json);
            System.out.println("Resultado salvo com sucesso como resultado.json");

        }
    }

}
