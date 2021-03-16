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
public class Reservation { 
	
	//Defining book id as primary key  
	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reservationId;  
	@Column  
	private String reservationName;  
	@Column  
	private String dateStart;  
	@Column  
	private String dateEnd; 
	
	public Reservation(int reservationId, String reservationName, String dateStart, String dateEnd) {
			super();
			this.reservationId = reservationId;
			this.reservationName = reservationName;
			this.dateStart = dateStart;
			this.dateEnd = dateEnd;
	}
	
	public Reservation(){}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + reservationId;
		result = prime * result + ((reservationName == null) ? 0 : reservationName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (reservationId != other.reservationId)
			return false;
		if (reservationName == null) {
			if (other.reservationName != null)
				return false;
		} else if (!reservationName.equals(other.reservationName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationName=" + reservationName + ", dateStart="
				+ dateStart + ", dateEnd=" + dateEnd + "]";
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	

}
