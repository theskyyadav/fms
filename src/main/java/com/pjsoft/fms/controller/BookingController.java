package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Booking;
import com.pjsoft.fms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
@RestController
@RequestMapping("/api/bookings")
public
class BookingController {
    @Autowired
    BookingService bookingService;
    @GetMapping
    public
    List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @GetMapping(path = "/{id}")
    public
    ResponseEntity<Object> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }
    @PutMapping(path = "/{id}")
    public Booking updateBooking( @PathVariable Long id, @RequestBody Booking booking){
        booking.setId(id);
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
