package io.igorv404.bankhotelbackendspring.controllers;

import io.igorv404.bankhotelbackendspring.models.Room;
import io.igorv404.bankhotelbackendspring.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
  private final RoomService roomService;

  @Autowired
  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @PostMapping("/images/add")
  private String uploadImage(@RequestParam("image") MultipartFile image) {
    return roomService.uploadImage(image);
  }

  @GetMapping("/images/{name}")
  private ResponseEntity<Object> getImage(@PathVariable("name") String name) {
    return roomService.getImage(name);
  }

  @PostMapping("/add")
  private void create(@RequestBody Room room) {
    roomService.create(room);
  }

  @GetMapping
  private Collection<Room> getAll() {
    return roomService.getAll();
  }

  @GetMapping("/{id}")
  private Room get(@PathVariable Integer id) {
    return roomService.get(id);
  }

  @PutMapping("/update/{id}")
  private Room update(@PathVariable("id") Integer id, @RequestParam String name, @RequestParam List<String> images,
                      @RequestParam String description, @RequestParam List<String> services) {
    return roomService.update(id, name, images, description, services);
  }

  @DeleteMapping("/del/{id}")
  private void delete(@PathVariable Integer id) {
    roomService.delete(id);
  }
}
