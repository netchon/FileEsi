package com.esi.dao;

import com.esi.models.Booking;

import java.io.IOException;
import java.util.List;

public interface BookingHandler {
    void ecreverNoFicheiro(List<Booking> bookings) throws IOException;
    List<Booking> lerDoFicheiro() throws IOException;
}
