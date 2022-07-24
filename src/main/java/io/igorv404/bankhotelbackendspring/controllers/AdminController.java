package io.igorv404.bankhotelbackendspring.controllers;

import io.igorv404.bankhotelbackendspring.models.Booking;
import io.igorv404.bankhotelbackendspring.models.Room;
import io.igorv404.bankhotelbackendspring.services.BookingService;
import io.igorv404.bankhotelbackendspring.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class AdminController {
  private final RoomService roomService;
  private final BookingService bookingService;

  @Autowired
  public AdminController(RoomService roomService, BookingService bookingService) {
    this.roomService = roomService;
    this.bookingService = bookingService;
  }

  @GetMapping("/admin-rooms")
  String getAdminRooms(Model model) {
    Collection<Room> rooms = roomService.getAll();
    model.addAttribute("rooms", rooms);
    return "admin-rooms";
  }

  @GetMapping("/admin-res")
  String getAdminReservation(Model model) {
    Collection<Booking> reservations = bookingService.getAll();
    model.addAttribute("reservations", reservations);
    return "admin-res";
  }
}
