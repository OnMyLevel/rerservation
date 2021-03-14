package com.meril.rerservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.meril.rerservation.model.Reservation;  
//repository that extends CrudRepository  

public interface ReservationRepository extends JpaRepository<Reservation, Integer>  
{  
}  