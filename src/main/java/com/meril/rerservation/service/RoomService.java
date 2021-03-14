package com.meril.rerservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.meril.rerservation.model.Room;
import com.meril.rerservation.repository.RoomRepository;

public class RoomService {
	
	@Autowired
	RoomRepository RoomRepository;
  
	//getting all Rooms record by using the method findaAll() of CrudRepository  
	public List<Room> getAllRooms()   
	{  
	  List<Room> Rooms = new ArrayList<Room>();  
	  RoomRepository.findAll().forEach(Room -> Rooms.add(Room));  
	  return Rooms;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Room getRoomById(int id)   
	{  
	  return RoomRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public Room saveOrUpdate(Room Room)   
	{  
		return RoomRepository.save(Room);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		RoomRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(Room Room, int Roomid)   
	{  
		RoomRepository.save(Room);  
	} 

}
