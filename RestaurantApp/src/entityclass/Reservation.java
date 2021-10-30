package entityclass;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservation implements Serializable 
{

	private LocalDateTime reservationDate;
	public enum TableStatus { EMPTY, OCCUPIED};
	private TableStatus status;
	private ArrayList <Reservation> reservedfor;
	private String customerName;
	private long customerContactNo;
	private int noOfPax;
	private int reservationID=0;
	private Table table;
	Scanner sc = new Scanner(System.in);

	

	public Reservation(LocalDateTime reservationDate, String customerName, long customerContactNo, int noOfPax, int reservationID, Table table) 
	{
		// TODO - implement Reservation.Reservation
		throw new UnsupportedOperationException();
		this.reservationDate = reservationDate;
		this.reservedfor = new ArrayList<Reservation>();
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
		this.noOfPax = noOfPax;
		this.reservationID = reservationID;
		this.table = table;
		this.status = TableStatus.EMPTY;
		throw new UnsupportedOperationException();
	}
	public void checkReservation(Table tableNumber)
	{
		if(getReservationID(tableNumber) > 0)
		{
			printReservationInfo(tableNumber);		
		}
		else
		{
			System.out.println("No Reservation");
		}
	}

	public void removeReservation(Table tableNumber)
	{
		if(this.Table.unassignTable(tableNumber))
		{
			clearReservation(tableNumber);
		}
	}

	public void clearReservation(Table tableNumber)
	{
		this.setCustomerName("EMPTY");
		this.setCustomerContactNo(0);
		this.setDate(null);
		this.setNoOfPax(0);
		this.setReservationID(0);
		this.status = TableStatus.EMPTY;
		System.out.println("Reservation Cleared");

	}

	public void printReservationInfo(Table tableNumber)
	{
		System.out.println(this.table.reservationDate);
		System.out.println(this.getCustomerName(tableNumber));
		System.out.println(this.getCustomerContactNo(tableNumber));
		System.out.println(this.getNoOfPax(tableNumber));
		System.out.println(this.getreservationID(tableNumber));
		System.out.println(this.getTable(table));
	}

	public LocalDateTime getDate() 
	{
		// TODO - implement Reservation.getDate
		throw new UnsupportedOperationException();
		return this.reservationDate;
	}

	/**
	 * 
	 * @param reservationDate
	 */
	public void setDate(LocalDateTime reservationDate) 
	{
		// TODO - implement Reservation.setDate
		throw new UnsupportedOperationException();
	}

	public String getCustomerName(Table tableNumber) 
	{
		return this.customerName;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}

	public long getCustomerContactNo(Table tableNumber) 
	{
		return this.customerContactNo;
	}

	/**
	 * 
	 * @param customerContactNo
	 */
	public void setCustomerContactNo(long customerContactNo) 
	{
		this.customerContactNo = customerContactNo;
	}

	public int getNoOfPax(Table tableNumber) 
	{
		return this.noOfPax;
	}

	/**
	 * 
	 * @param noOfPax
	 */
	public void setNoOfPax(int noOfPax) 
	{
		this.noOfPax = noOfPax;
	}

	public Table getTable(Table tableNumber) 
	{
		return this.table;
	}

	/**
	 * 
	 * @param table
	 */
	public void setTable(Table table) 
	{
		this.table = table;
	}

	public int getReservationID(Table tableNumber)
	{
		return this.reservationID;
	}

	public void setReservationID(int reservationID)
	{
		this.reservationID = reservationID;
		this.status = TableStatus.OCCUPIED;
	}

	public TableStatus getStatus()
	{
		return status;
	}

	public void setStatus(TableStatus status)
	{
		this.status = status;
	}
	/*
	public ArrayList<Reservation>setReservationFor()
	{
		return this.reservingfor;
	}

	public void addReservation(Reservation reservation)
	{
		this.reservingfor.add(reservation);
	}
	*/

	/*

	- function to remove Res based on time

	- Adding new Reservation by array or immediately upon object creation to be passed to the constructor

	*/
}