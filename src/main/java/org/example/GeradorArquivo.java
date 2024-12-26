package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GeradorArquivo {

    public static void salvarResultado(CurrentData currentData, String nomeArquivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) { // 'true' para adicionar novos resultados
            writer.write(gson.toJson(currentData) + System.lineSeparator());
            System.out.println("Resultado salvo no arquivo JSON: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo JSON: " + e.getMessage());
        }
    }
}
