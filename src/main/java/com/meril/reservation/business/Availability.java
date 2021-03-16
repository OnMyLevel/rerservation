package com.meril.reservation.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Availability {
	
	private static final int DURATIONOLONGERTHANTHREEDAYS= 3;
	private static final int RESERVATIONLESSTHANTHIRTHYDAYS= 30;
	
	public Availability() {
	}
	
	public static int getReservationlessthanthirthydays() {
		return RESERVATIONLESSTHANTHIRTHYDAYS;
	}

	public static int getDurationolongerthanthreedays() {
		return DURATIONOLONGERTHANTHREEDAYS;
	}
	/**
	 * Test si les dates sont valide
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static boolean checkDate(String dateStart, String dateEnd) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
		Date dateOne = null;
		Date dateTwo = null;
		
		try {
			dateOne = simpleDateFormat.parse(dateStart);
			dateTwo = simpleDateFormat.parse(dateEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date today = new Date();
		if(dateOne.compareTo(dateTwo) == -1 
			&& today.compareTo(dateOne) == -1
			&& today.compareTo(dateOne) == -1 ) {
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Verification que la durée du séjour et bien inférieur à 3 jours
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static boolean nolongerThanThreeDays(String dateStart, String dateEnd) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
		Date dateOne = null;
		Date dateTwo = null;
		
		try {
			dateOne = simpleDateFormat.parse(dateStart);
			dateTwo = simpleDateFormat.parse(dateEnd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long diff = dateTwo.getTime() - dateOne.getTime();
	    float res = (diff / (1000*60*60*24));
		if((int)res <= Availability.getDurationolongerthanthreedays()) {
			
			return true;
		}
		
		return false;
	}
	/**
	 * La reservation n'est pas plus de 30 jours à l'avance
	 * @param dateStart
	 * @return
	 */
	public static boolean reservationDateLessThanThirdyDay(String dateStart) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
		Date dateOne = null;
		
		try {
			dateOne = simpleDateFormat.parse(dateStart);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long diff = dateOne.getTime() - new Date().getTime();
	    float res = (diff / (1000*60*60*24));
		if((int)res <= Availability.getReservationlessthanthirthydays()) {
			
			 return true;
		}
		return false;
	}
	/**
	 * La date de réservation suit la date d'arrivée 
	 * @param dateStart
	 * @return
	 */
	public static boolean nextEntryDate(String dateStart) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
		Date dateOne = null;
		
		try {
			dateOne = simpleDateFormat.parse(dateStart);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date today = new Date();
		Date nextDate = new Date(today.getTime() + (1000 * 60 * 60 * 24));
	    
		if(nextDate.compareTo(dateOne) == 0) {
			
			 return true;
		}
		return false;
	}

}
