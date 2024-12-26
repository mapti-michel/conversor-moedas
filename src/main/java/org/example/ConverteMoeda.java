package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteMoeda {

    public void conversao(double amount, String baseCurrency, String targetCurrency){

        // URL da API (substitua pela sua chave de API)
        String apiKey = "f49a71ec7851fb5b3cfa4090"; // Coloque sua chave de API aqui
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        // Consumir a API e processar a conversão
        try {
            // Criar cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Enviar a requisição e obter a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar se a resposta é válida
            if (response.statusCode() == 200) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                // Parsear o JSON de resposta com Gson
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

                // Verificar se a moeda de destino existe
                if (conversionRates.has(targetCurrency)) {
                    // Obter a taxa de conversão
                    double conversionRate = conversionRates.get(targetCurrency).getAsDouble();

                    // Calcular o valor convertido
                    double convertedAmount = amount * conversionRate;

                    // Exibir os resultados
                    System.out.printf("Taxa de conversão %s para %s: %.2f%n", baseCurrency, targetCurrency, conversionRate);
                    System.out.printf("Valor convertido: %.2f %s%n", convertedAmount, targetCurrency);

                    CurrentData currentData = new CurrentData(baseCurrency, targetCurrency, amount, convertedAmount, conversionRate);

                    GeradorArquivo geradorArquivo = new GeradorArquivo();

                    geradorArquivo.salvarResultado(currentData, "resultado.json");


                } else {
                    System.err.println("Moeda de destino não encontrada: " + targetCurrency);
                }
            } else {
                System.err.println("Erro ao consultar a API: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
