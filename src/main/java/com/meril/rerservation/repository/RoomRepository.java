package com.meril.rerservation.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.meril.rerservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
