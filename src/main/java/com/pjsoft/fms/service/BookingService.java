package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.model.Passenger;
import com.pjsoft.fms.repository.BookingRepository;
import com.pjsoft.fms.repository.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public
class BookingService {
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);
    @Autowired
    private
    BookingRepository bookingRepository;

    @Autowired
    private
    PassengerService passengerService;

    public
    List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    public
    Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow
                        (() -> new ResourceNotFoundException("Flight not found with id: " + id));
    }
    public Booking saveBooking(Booking booking) {

        Passenger passenger = passengerService.getPassengerById(booking.getPassenger().getId());
        booking.setPassenger(passenger);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}
