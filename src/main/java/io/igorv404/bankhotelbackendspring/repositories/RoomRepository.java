package io.igorv404.bankhotelbackendspring.repositories;

import io.igorv404.bankhotelbackendspring.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
