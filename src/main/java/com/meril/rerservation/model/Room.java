package com.meril.rerservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table 
public class Room { 
	
	//Defining book id as primary key  
	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;  
	@Column  
	private String roomName; 
	@Column  
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
