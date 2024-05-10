package com.esi;

import com.esi.dao.BookingFileHandler;
import com.esi.services.HotelBookingService;

public class BookingManagement {

    public static void main(String[] args){
        BookingFileHandler fileHandler = new BookingFileHandler("reservahotels.txt");
        HotelBookingService hotelBookingService = new HotelBookingService(fileHandler);
        hotelBookingService.adicionarBooking();
        hotelBookingService.lerDoFicheiro();
    }
}
