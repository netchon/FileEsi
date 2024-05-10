package com.esi.dao;

import com.esi.models.Booking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface BookingHandler {
    void saveBooking(List<Booking> bookings) throws IOException, SQLException;
    List<Booking> readBooking() throws IOException, SQLException;
}
