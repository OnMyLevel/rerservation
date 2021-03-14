
package com.meril.rerservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meril.rerservation.model.Reservation;
import com.meril.rerservation.repository.ReservationRepository;

import java.util.*;

@Service
public class ReservationService {
	
	@Autowired
	ReservationRepository reservationRepository;
  
	//getting all reservations record by using the method findaAll() of CrudRepository  
	public List<Reservation> getAllReservations()   
	{  
	  List<Reservation> reservations = new ArrayList<Reservation>();  
	  reservationRepository.findAll().forEach(reservation -> reservations.add(reservation));  
	  return reservations;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Reservation getReservationById(int id)   
	{  
	  return reservationRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public Reservation saveOrUpdate(Reservation reservation)   
	{  
		return reservationRepository.save(reservation);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		reservationRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(Reservation reservation, int reservationid)   
	{  
		reservationRepository.save(reservation);  
	} 
}
