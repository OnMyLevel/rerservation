package com.meril.rerservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meril.rerservation.model.Reservation;
import com.meril.rerservation.model.Room;
import com.meril.rerservation.service.AvailabilityService;
import com.meril.rerservation.service.ReservationService;
import com.meril.rerservation.service.RoomService;
import com.meril.reservation.business.Availability;

import java.util.*;

@RestController
public class ReservationController {
	
	@Autowired
	ReservationService reservationService; // Injection de la classe service réservations
	
	@Autowired
	RoomService roomService; // Injection de la classe service chambres
	
	@Autowired
	AvailabilityService availability; // Injection de la classe Availability
	
	//Récupération de toutes les reservations présents en BDD   
	@GetMapping("/reservation")  
	private List<Reservation> getAllReservations()   
	{  
		return reservationService.getAllReservations();  
	}  
	
	//Recuperation d'une reservation par Id
	@GetMapping("/reservation/{reservationid}")  
	private Reservation getReservation(@PathVariable("reservationid") int reservationid)   
	{  
		return reservationService.getReservationById(reservationid);  
	}  
	
	//Suppression d'une reservation 
	@DeleteMapping("/reservation/{reservationid}")  
	private void deleteReservation(@PathVariable("reservationid") int reservationid)   
	{  
		reservationService.delete(reservationid);  
	}  
	
	//Modification d'une reservation 
	@PostMapping("/reservation")  
	private String saveReservation(@RequestBody Reservation reservation)   
	{  
		if( this.availability.getAvailability().checkDate(reservation.getDateStart(),reservation.getDateEnd()) 
			&& this.availability.getAvailability().nextEntryDate(reservation.getDateStart())
			&& this.availability.getAvailability().nolongerThanThreeDays(reservation.getDateStart(),reservation.getDateEnd())
			&& this.availability.getAvailability().reservationDateLessThanThirdyDay(reservation.getDateStart())) {
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
