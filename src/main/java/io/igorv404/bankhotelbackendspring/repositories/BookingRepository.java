package io.igorv404.bankhotelbackendspring.repositories;

import io.igorv404.bankhotelbackendspring.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
  Collection<Booking> findBookingByRoomId(Integer roomId);
}
