package com.meril.rerservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meril.rerservation.model.Reservation;
import com.meril.rerservation.model.Room;
import com.meril.rerservation.service.ReservationService;
import com.meril.rerservation.service.RoomService;
import com.meril.reservation.business.Availability;

import java.util.*;

@RestController
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	Availability testAvailability;
	
	//creating a get mapping that retrieves all the reservations detail from the database   
	@GetMapping("/reservation")  
	private List<Reservation> getAllReservations()   
	{  
		return reservationService.getAllReservations();  
	}  
	//creating a get mapping that retrieves the detail of a specific reservation 
	@GetMapping("/reservation/{reservationid}")  
	private Reservation getReservation(@PathVariable("reservationid") int reservationid)   
	{  
		return reservationService.getReservationById(reservationid);  
	}  
	//creating a delete mapping that deletes a specified reservation  
	@DeleteMapping("/reservation/{reservationid}")  
	private void deleteReservation(@PathVariable("reservationid") int reservationid)   
	{  
		reservationService.delete(reservationid);  
	}  
	//creating post mapping that post the reservation detail in the database  
	@PostMapping("/reservation")  
	private String saveReservation(@RequestBody Reservation reservation)   
	{  
		if( this.testAvailability.checkDate(reservation.getDateStart(),reservation.getDateEnd()) 
			&& this.testAvailability.nextEntryDate(reservation.getDateStart())
			&& this.testAvailability.nolongerThanThreeDays(reservation.getDateStart(),reservation.getDateEnd())
			&& this.testAvailability.reservationDateLessThanThirdyDay(reservation.getDateStart())) {
		   if(roomService.getRoomById(1).getReservation()!=0) {
			  
			   Reservation tmpReservation =reservationService.saveOrUpdate(reservation);
			   Room tmpRoom = roomService.getRoomById(1);
			   tmpRoom.setReservation(tmpReservation.getReservationId());
			   this.roomService.saveOrUpdate(tmpRoom); 
			   return "Save";
		     }
		
			return "Not Save";
		}
		return "Not Save";
	
	}  
	
}
