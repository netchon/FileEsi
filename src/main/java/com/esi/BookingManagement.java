package com.esi;

import com.esi.dao.BookingHandler;
import com.esi.dao.BookingJsonHandler;
import com.esi.dao.BookingTxtHandler;
import com.esi.services.HotelBookingService;

import java.io.IOException;

public class BookingManagement {

    public static void main(String[] args) throws IOException {
        BookingHandler textFileHandler = new BookingTxtHandler("reservahotels.txt");
        HotelBookingService textService = new HotelBookingService(textFileHandler);

        BookingHandler jsonFileHandler = new BookingJsonHandler("reservahotels.json");
        HotelBookingService jsonService = new HotelBookingService(jsonFileHandler);

        textService.adicionarBooking();
        textService.lerDoFicheiro();

        jsonService.adicionarBooking();
        jsonService.lerDoFicheiro();


    }
}
