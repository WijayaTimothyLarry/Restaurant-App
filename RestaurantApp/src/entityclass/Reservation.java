package entityclass;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Timer;

public class Reservation implements Serializable {
	// private Calendar reservationDateTime;
	private LocalTime arrivalTime;										// Customer's arrival Time
	private LocalDate date;												// Customer's arrival Date
	private Timer timer;												// Customer's Arrival date

	private String customerName;										// Customer's name
	private long customerContactNo;										// Customer's contact number
	private int noOfPax;												// Number of customers under reservation
	private int reservationID = 0;										// Unique ID for each reservation
	private int tableNumber;											// Unique ID for each table

	public Reservation(LocalDate reservationDate, LocalTime arrivalTime, String customerName, long customerContactNo, int noOfPax, int tableNumber) 
	{
		// TODO - implement Reservation.Reservation
		// this.reservationDateTime = Calendar.getInstance();
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
		this.noOfPax = noOfPax;
		this.reservationID = Calendar.getInstance().hashCode(); 		// assigning a unique Reservation ID based on the hashed value
		this.tableNumber = tableNumber;
		this.timer = new Timer();
		// throw new UnsupportedOperationException();
	}

	/*
	 * public Calendar getDate() { // TODO - implement Reservation.getDate return
	 * reservationDateTime; //throw new UnsupportedOperationException(); }
	 * 
	 * public LocalTime getArrivalTime() { return this.arrivalTime; }
	 */


	public Timer getTimer() 											// Current value of timer for given Reservation Object
	{
		return this.timer;
	}

	public void stopTimer() 											// To stop the running timer for given Reservation Object
	{
		this.timer.cancel();
	}

	/**
	 * 
	 * @param reservationDate
	 */
	public void setDate(LocalDateTime reservationDate) 					// To set the date of given Reservation Object
	{

		// throw new UnsupportedOperationException();
	}

	public String getCustomerName() 									// Return the Customer's name for given Reservation Object
	{
		return this.customerName;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) 					// To set the Customer's name for given Reservation Object
	{
		this.customerName = customerName;
	}

	public long getCustomerContactNo() 									// Return the Customer's contact number for given Reservation Object
	{
		return this.customerContactNo;
	}

	/**
	 * 
	 * @param customerContactNo
	 */
	public void setCustomerContactNo(long customerContactNo) 			// Set the Customer's contact number for given Reservation Object
	{
		this.customerContactNo = customerContactNo;
	}

	public int getNoOfPax() 											// Return the number of Customers under the given Reservation
	{
		return this.noOfPax;
	}

	/**
	 * 
	 * @param noOfPax
	 */
	public void setNoOfPax(int noOfPax) 								// To set the number of Customers under the given Reservation
	{
		this.noOfPax = noOfPax;
	}

	public int getTableNumber() 										// To return the Table ID for given Reservation
	{
		return this.tableNumber;
	}

	/**
	 * 
	 * @param table
	 */
	public void setTableNumber(int tableNumber) 						// To set the Table ID for given Reservation
	{
		this.tableNumber = tableNumber;
	}

	public int getReservationID() 										// To return the unique ReservationID for given Reservation
	{
		return this.reservationID;
	}

	public boolean checkReservationAvail(LocalDateTime time) 			// Checks if the next reservation can be made for a given time
	{ 																	// by comparing to see if the new arrival time overlaps with an existing
		boolean available = false;										// Reservation timing
		if (time.toLocalDate().compareTo(date) == 0) {
			if (time.toLocalTime().compareTo(LocalTime.parse("14:00")) < 0) {
				if (arrivalTime.compareTo(LocalTime.parse("14:00")) < 0) {
					available = true;
				}
			} else {
				if (arrivalTime.compareTo(LocalTime.parse("19:00")) < 0) {
					available = true;
				}
			}
		}
		return available;
	}

	public void printReservationInfo() 									// Print the details of a given reservation
	{
		System.out.println(" \n Reservation ID: " + reservationID);
		System.out.println(" \n Customer's Contact Number: " + customerContactNo);
		System.out.println(" \n Customer's Name: " + customerName);
		System.out.println(" \n Date: " + date);
		System.out.println(" \n Customer's Arrival Time: " + arrivalTime);
		System.out.println(" \n Table ID: " + tableNumber);
	}

	/*
	 * public void setReservationID(int reservationID) { this.reservationID =
	 * reservationID; this.status = TableStatus.OCCUPIED; }
	 */

	/*
	 * 
	 * - function to remove Res based on time
	 * 
	 * - Adding new Reservation by array or immediately upon object creation to be
	 * passed to the constructor
	 * 
	 */
}