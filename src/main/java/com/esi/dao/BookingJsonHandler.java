package com.esi.dao;

import com.esi.models.Booking;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BookingJsonHandler implements  BookingHandler{

    private Path caminhoFicheiro;
    private ObjectMapper objectMapper;

    public BookingJsonHandler(String fileName) {
        this.caminhoFicheiro = Paths.get(fileName);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void ecreverNoFicheiro(List<Booking> bookings) throws IOException {
        objectMapper.writeValue(caminhoFicheiro.toFile(), bookings);
    }

    @Override
    public List<Booking> lerDoFicheiro() throws IOException {

        if(!Files.exists(caminhoFicheiro)){
            return List.of();
        }

        return objectMapper.readValue(Files.newInputStream(caminhoFicheiro), new TypeReference<List<Booking>>() {});
    }
}
