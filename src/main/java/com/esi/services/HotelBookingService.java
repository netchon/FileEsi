package com.esi.services;

import com.esi.dao.BookingHandler;
import com.esi.models.Booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingService {

    private BookingHandler bookingFileHandler;

    public HotelBookingService(BookingHandler bookingFileHandler) {
        this.bookingFileHandler = bookingFileHandler;
    }

    public void adicionarBooking(){

        List<Booking> bookings = new ArrayList<>();

        bookings.add(new Booking("nelson", "401", "2022-02-02", "2022-03-03"));
        bookings.add(new Booking("Alice", "402", "2022-03-02", "2022-04-03"));

        try {
            bookingFileHandler.ecreverNoFicheiro(bookings);
            System.out.println("bookings inserido com sucesso");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lerDoFicheiro() throws IOException {
        List<Booking> bookings = bookingFileHandler.lerDoFicheiro();
        System.out.println("Reservas já efetuadas:");
        for(Booking booking:bookings)
            System.out.println(booking);
    }
}
