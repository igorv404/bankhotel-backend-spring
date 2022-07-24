package io.igorv404.bankhotelbackendspring.services;

import io.igorv404.bankhotelbackendspring.models.Room;
import io.igorv404.bankhotelbackendspring.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

@Service
public class RoomService {
  private final RoomRepository roomRepository;

  @Autowired
  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public String uploadImage(MultipartFile image) {
    try {
      Files.copy(image.getInputStream(), Paths.get(String.format("%s%s%s%s%s%s%s%s%s%s%s", System.getProperty("user.dir"),
              File.separator, "src", File.separator, "main", File.separator, "resources", File.separator, "images",
              File.separator, image.getOriginalFilename())));
    } catch (Exception e) {
      return e.getMessage();
    }
    return String.format("%s%s", "http://localhost:8080/rooms/images/", image.getOriginalFilename());
  }

  public ResponseEntity<Object> getImage(String name) {
    try {
      File image = new File(String.format("%s%s%s%s%s%s%s%s%s%s%s", System.getProperty("user.dir"),
              File.separator, "src", File.separator, "main", File.separator, "resources", File.separator, "images",
              File.separator, name));
      InputStreamResource resource = new InputStreamResource(new FileInputStream(image));
      HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Disposition", String.format("%s%s%s", "attachment; filename=\"", image.getName(), "\""));
      return ResponseEntity.ok().headers(headers).contentLength(image.length()).contentType(MediaType.IMAGE_PNG).body(resource);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public void create(Room room) {
    roomRepository.save(room);
  }

  public Collection<Room> getAll() {
    return roomRepository.findAll();
  }

  public Room get(Integer id) {
    return roomRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Transactional
  public Room update(Integer id, String name, List<String> images, String description, List<String> services) {
    Room room = roomRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    room.setName(name);
    room.setImages(images);
    room.setDescription(description);
    room.setServices(services);
    return room;
  }

  public void delete(Integer id) {
    roomRepository.deleteById(id);
  }
}
