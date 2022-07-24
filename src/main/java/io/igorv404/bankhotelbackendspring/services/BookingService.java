package io.igorv404.bankhotelbackendspring.services;

import io.igorv404.bankhotelbackendspring.models.Booking;
import io.igorv404.bankhotelbackendspring.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {
  private final BookingRepository bookingRepository;

  @Autowired
  public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  private List<Date> convertStringToDate(Booking booking) {
    Date firstDate;
    Date secondDate;
    try {
      firstDate = new SimpleDateFormat("dd/MM/yyyy").parse(booking.getReservationPeriod().get(0));
      secondDate = new SimpleDateFormat("dd/MM/yyyy").parse(booking.getReservationPeriod().get(1));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
    return List.of(firstDate, secondDate);
  }

  public void create(Booking booking) {
    Date startDate = convertStringToDate(booking).get(0);
    Date endDate = convertStringToDate(booking).get(1);
    Collection<Booking> reservations = bookingRepository.findBookingByRoomId(booking.getRoomId());

    for (Booking reservation : reservations) {
      Date startDateRes = convertStringToDate(reservation).get(0);
      Date endDateRes = convertStringToDate(reservation).get(1);

      if (startDate.equals(startDateRes) || endDate.equals(endDateRes) || startDate.equals(endDateRes) || endDate.equals(startDateRes)
              || (startDate.before(startDateRes) && !endDate.before(startDateRes)) || (!startDate.after(endDateRes) && endDate.after(endDateRes))
              || (!startDate.after(endDateRes) && !endDate.after(endDateRes))) {
        throw new IllegalStateException("At these days room is reserved");
      }
    }
    bookingRepository.save(booking);
  }

  public Collection<Booking> getAll() {
    return bookingRepository.findAll();
  }

  public Booking get(Integer id) {
    return bookingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
