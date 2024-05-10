package com.esi.dao;

import com.esi.models.Booking;

import java.io.IOException;
import java.util.List;

public class BookingJsonHandler implements  BookingHandler{
    @Override
    public void ecreverNoFicheiro(List<Booking> bookings) throws IOException {

    }

    @Override
    public List<Booking> lerDoFicheiro() throws IOException {
        return null;
    }
}
