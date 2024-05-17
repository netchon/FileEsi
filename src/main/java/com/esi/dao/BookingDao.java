package com.esi.dao;

import com.esi.config.DatabaseConfig;
import com.esi.models.Booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDao implements BookingHandler{
    private static final String INSERT_SQL = "INSERT INTO bookings (customer_name, room_number, check_in_date, check_out_date) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_SQL = "SELECT id, customer_name, room_number, check_in_date, check_out_date FROM bookings";

    public BookingDao() {
    }

    @Override
    public void saveBooking(List<Booking> bookings) throws IOException, SQLException {
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            for (Booking booking : bookings) {
                pstmt.setString(1, booking.getNomeCliente());
                pstmt.setString(2, booking.getNumeroQuarto());
                pstmt.setString(3, booking.getDataEntrada());
                pstmt.setString(4, booking.getDataSaida());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
    }

    @Override
    public List<Booking> readBooking() throws IOException, SQLException {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getString("customer_name"),
                        rs.getString("room_number"),
                        rs.getDate("check_in_date").toString(),
                        rs.getDate("check_out_date").toString()
                );
                bookings.add(booking);
            }
        }
        return bookings;
    }
}
