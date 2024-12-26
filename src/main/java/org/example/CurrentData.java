package org.example;

import java.util.Map;

public class CurrentData {

    private String moedaOrigem;
    private String moedaDestino;
    private double valorOriginal;
    private double valorConvertido;
    private double taxaConversao;

    public CurrentData(String moedaOrigem,
                       String moedaDestino,
                       double valorOriginal,
                       double valorConvertido,
                       double taxaConversao) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.taxaConversao = taxaConversao;
    }

}
