package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Exibir o menu
            System.out.println("\n");
            System.out.println("==========================================");
            System.out.println("Seja bem-vindo ao conversor de moedas");
            System.out.println("==========================================");
            System.out.println("1) Dólar ==> Peso argentino");
            System.out.println("2) Peso argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real brasileiro");
            System.out.println("4) Real brasileiro ==> Dólar");
            System.out.println("5) Dólar ==> Peso colombiano");
            System.out.println("6) Peso colombiano ==> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("================================");

            int opcao = scanner.nextInt();
            String baseCurrency = "";
            String targetCurrency = "";

            switch (opcao) {
                case 1:
                    baseCurrency = "USD";
                    targetCurrency = "ARS";
                    break;
                case 2:
                    baseCurrency = "ARS";
                    targetCurrency = "USD";
                    break;
                case 3:
                    baseCurrency = "USD";
                    targetCurrency = "BRL";
                    break;
                case 4:
                    baseCurrency = "BRL";
                    targetCurrency = "USD";
                    break;
                case 5:
                    baseCurrency = "USD";
                    targetCurrency = "COP";
                    break;
                case 6:
                    baseCurrency = "COP";
                    targetCurrency = "USD";
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Saindo... Obrigado por usar o conversor!");
                    continue;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            // Solicitar o valor a ser convertido
            if (continuar) {
                System.out.print("Digite o valor a ser convertido: ");
                double amount = scanner.nextDouble();

                ConverteMoeda converteMoeda = new ConverteMoeda();
                converteMoeda.conversao(amount, baseCurrency, targetCurrency);
            }
        }

        scanner.close();
    }
}