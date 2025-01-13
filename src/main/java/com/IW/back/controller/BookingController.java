package com.IW.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.IW.back.model.Booking;
import com.IW.back.repository.BookingRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }

    @PutMapping
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingRepository.findById(id).orElse(null);
    }
}

