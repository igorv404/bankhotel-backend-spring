package io.igorv404.bankhotelbackendspring.controllers;

import io.igorv404.bankhotelbackendspring.models.Booking;
import io.igorv404.bankhotelbackendspring.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/res")
public class BookingController {
  private final BookingService bookingService;

  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping("/add")
  private void create(@RequestBody Booking booking) {
    bookingService.create(booking);
  }

  @GetMapping
  private Collection<Booking> getAll() {
    return bookingService.getAll();
  }

  @GetMapping("/{id}")
  private Booking get(@PathVariable Integer id) {
    return bookingService.get(id);
  }
}
