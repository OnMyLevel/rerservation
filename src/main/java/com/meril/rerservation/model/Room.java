package com.meril.rerservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table 
public class Room { 
	
	//Defining book id as primary key  
	@Id
	@Column(name = "roomid")
	private int roomId;  
	@Column(name = "roomname")
	private String roomName; 
	@Column(name = "reservationid")  
	private int reservationId;
	
	
	public Room(){
		
	}
	
	public Room(int roomId, String roomName, int reservation) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.reservationId = reservation;
	}



	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	public int getReservation() {
		return reservationId;
	}

	public void setReservation(int reservation) {
		this.reservationId = reservation;
	}

}
