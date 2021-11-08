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

	public void printReservationInfo() // Print the details of a given reservation
	{
		System.out.println("\nReservation ID: " + reservationID);
		System.out.println("\nCustomer's Contact Number: " + customerContactNo);
		System.out.println("\nCustomer's Name: " + customerName);
		System.out.println("\nDate Time: " + reservationDateTime.getTime());
		System.out.println("\nTable ID: " + tableNumber);
		System.out.println("");
	}
}