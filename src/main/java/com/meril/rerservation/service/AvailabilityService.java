package com.meril.rerservation.service;

import org.springframework.stereotype.Service;

import com.meril.reservation.business.Availability;

@Service
public class AvailabilityService {
  private Availability availability;

public Availability getAvailability() {
	return availability;
}

public void setAvailability(Availability availability) {
	this.availability = availability;
}
  
}
