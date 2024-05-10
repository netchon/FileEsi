package com.esi.models;

public class Booking {

    private String nomeCliente;
    private String numeroQuarto;
    private String dataEntrada;
    private String dataSaida;


    public Booking(String nomeCliente, String numeroQuarto, String dataEntrada, String dataSaida) {
        this.nomeCliente = nomeCliente;
        this.numeroQuarto = numeroQuarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Booking() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", nomeCliente, numeroQuarto, dataEntrada, dataSaida);
    }

    public static Booking formStringToObject(String linha){
        String[] partes = linha.split(",");
        if(partes.length ==4){
            return new Booking(partes[0], partes[1], partes[2], partes[3]);
        }
        throw new IllegalArgumentException("verifcar dados no ficheiro (estrutura)");
    }
}
