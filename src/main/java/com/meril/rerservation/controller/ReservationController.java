package com.meril.rerservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meril.rerservation.model.Reservation;
import com.meril.rerservation.model.Room;
import com.meril.rerservation.service.AvailabilityService;
import com.meril.rerservation.service.ReservationService;
import com.meril.rerservation.service.RoomService;


import java.util.*;

@RestController
public class ReservationController {
	
	private Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	ReservationService reservationService; // Injection de la classe service réservations
	
	@Autowired
	RoomService roomService; // Injection de la classe service chambres
	
	@Autowired
	AvailabilityService availability; // Injection de la classe Availability
	
	//Récupération de toutes les reservations présents en BDD   
	@GetMapping("/reservations")  
	private List<Reservation> getAllReservations(){  
		return reservationService.getAllReservations();  
	}  
	
	//Récupération de toutes les reservations présents en BDD   
	@GetMapping("/rooms")  
	private List<Room> getAllRooms(){  
		return roomService.getAllRooms();  
	}  
	
	//Recuperation d'une reservation par Id
	@GetMapping("/reservation/{reservationid}")  
	private Reservation getReservation(@PathVariable("reservationid") int reservationid){  
		return reservationService.getReservationById(reservationid);  
	}  
	
	//Suppression d'une reservation 
	@DeleteMapping("/cancelReservation/{reservationid}")  
	private void deleteReservation(@PathVariable("reservationid") int reservationid){  
		reservationService.delete(reservationid);  
	}  
	
	//faire un une reservation 
	@PostMapping("/saveReservation")  
	private String saveReservation(@ModelAttribute Reservation reservation){
		logger.info(" /makeReservation");
		
		if( this.availability.getAvailability().checkDate(reservation.getDateStart(),reservation.getDateEnd()) 
			&& this.availability.getAvailability().nextEntryDate(reservation.getDateStart())
			&& this.availability.getAvailability().nolongerThanThreeDays(reservation.getDateStart(),reservation.getDateEnd())
			&& this.availability.getAvailability().reservationDateLessThanThirdyDay(reservation.getDateStart())) {
		   
			this.logger.info(" Date availability Checked ");
			if(roomService.getRoomById(1).getReservation()==0) {
			   
			   this.logger.info("Room availability checked");
			   
			   Reservation tmpReservation =reservationService.saveOrUpdate(reservation);
			   Room tmpRoom = roomService.getRoomById(1);
			   tmpRoom.setReservation(tmpReservation.getReservationId());
			   this.roomService.saveOrUpdate(tmpRoom); 
			   return "Resveration Made | Your reservation"+tmpReservation.toString();
		     }
		
			return "The "+ roomService.getRoomById(1).getRoomName().toString() +"is already reserved";
		}
		return "Not reserved : check your date availability ";
	
	}  
	
	//faire un une reservation 
		@PostMapping("/modifyReservation")  
		private String modifyReservation(@ModelAttribute Reservation reservation){
			logger.info(" /modifyReservation");
		    Reservation tmpReservation =reservationService.saveOrUpdate(reservation);
			return "Information about your reservation: " +tmpReservation.toString();
		
		}  
	
}
