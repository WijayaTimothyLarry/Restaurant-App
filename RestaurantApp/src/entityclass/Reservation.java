package entityclass;

import java.io.Serializable;
import java.util.Calendar;

public class Reservation implements Serializable {
	private Calendar reservationDateTime;
	private String customerName; // Customer's name
	private String customerContactNo; // Customer's contact number
	private int noOfPax; // Number of customers under reservation
	private int reservationID = 0; // Unique ID for each reservation
	private int tableNumber; // Unique ID for each table

	public Reservation(Calendar reservationDateTime, String customerName, String customerContactNo, int noOfPax,
			int tableNumber) {
		// TODO - implement Reservation.Reservation
		// this.reservationDateTime = Calendar.getInstance();
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
		this.noOfPax = noOfPax;
		this.reservationID = Calendar.getInstance().hashCode();
		this.reservationDateTime = reservationDateTime;
		this.tableNumber = tableNumber;

	}

	public Calendar getReservationDateTime() {
		return reservationDateTime;
	}

	/**
	 * 
	 * @param reservationDateTime
	 */
	public void setReservationDateTime(Calendar reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

	public String getCustomerName() // Return the Customer's name for given Reservation Object
	{
		return this.customerName;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) // To set the Customer's name for given Reservation Object
	{
		this.customerName = customerName;
	}

	public String getCustomerContactNo() // Return the Customer's contact number for given Reservation Object
	{
		return this.customerContactNo;
	}

	/**
	 * 
	 * @param customerContactNo
	 */
	public void setCustomerContactNo(String customerContactNo) // Set the Customer's contact number for given
																// Reservation Object
	{
		this.customerContactNo = customerContactNo;
	}

	public int getNoOfPax() // Return the number of Customers under the given Reservation
	{
		return this.noOfPax;
	}

	/**
	 * 
	 * @param noOfPax
	 */
	public void setNoOfPax(int noOfPax) // To set the number of Customers under the given Reservation
	{
		this.noOfPax = noOfPax;
	}

	public int getTableNumber() // To return the Table ID for given Reservation
	{
		return this.tableNumber;
	}

	/**
	 * 
	 * @param table
	 */
	public void setTableNumber(int tableNumber) // To set the Table ID for given Reservation
	{
		this.tableNumber = tableNumber;
	}

	public int getReservationID() // To return the unique ReservationID for given Reservation
	{
		return this.reservationID;
	}

	// public boolean checkReservationAvail(LocalDateTime time) // Checks if the
	// next reservation can be made for a given
	// // time
	// { // by comparing to see if the new arrival time overlaps with an existing
	// boolean available = false; // Reservation timing
	// if (time.toLocalDate().compareTo(date) == 0) {
	// if (time.toLocalTime().compareTo(LocalTime.parse("14:00")) < 0) {
	// if (arrivalTime.compareTo(LocalTime.parse("14:00")) < 0) {
	// available = true;
	// }
	// } else {
	// if (arrivalTime.compareTo(LocalTime.parse("19:00")) < 0) {
	// available = true;
	// }
	// }
	// }
	// return available;
	// }

	public void printReservationInfo() // Print the details of a given reservation
	{
		System.out.println(" \n Reservation ID: " + reservationID);
		System.out.println(" \n Customer's Contact Number: " + customerContactNo);
		System.out.println(" \n Customer's Name: " + customerName);
		System.out.println(" \n Date Time: " + reservationDateTime);
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