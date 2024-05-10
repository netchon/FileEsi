package com.esi;

import com.esi.dao.BookingDao;
import com.esi.dao.BookingHandler;
import com.esi.dao.BookingJsonHandler;
import com.esi.dao.BookingTxtHandler;
import com.esi.services.HotelBookingService;

import java.io.IOException;
import java.sql.SQLException;

public class BookingManagement {

    public static void main(String[] args) throws IOException, SQLException {
        BookingHandler textFileHandler = new BookingTxtHandler("reservahotels.txt");
        HotelBookingService textService = new HotelBookingService(textFileHandler);

        BookingHandler jsonFileHandler = new BookingJsonHandler("reservahotels.json");
        HotelBookingService jsonService = new HotelBookingService(jsonFileHandler);

        BookingHandler bdHandler = new BookingDao();
        HotelBookingService bdService = new HotelBookingService(bdHandler);

        textService.adicionarBooking();
        textService.lerDoFicheiro();

        jsonService.adicionarBooking();
        jsonService.lerDoFicheiro();

        bdService.adicionarBooking();
        bdService.lerDoFicheiro();


    }
}
