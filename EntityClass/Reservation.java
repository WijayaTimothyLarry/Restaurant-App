package EntityClass;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Calendar;

public class Reservation implements Serializable {

	private LocalDateTime reservationDate;
	private String customerName;
	private long customerContactNo;
	private int noOfPax;
	private int reservationID;
	private Table table;
	private Calender arrivalTime;
	Scanner sc = new Scanner(System.in);
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("E, dd/MM/yyy, HH:mm");


	public Reservation( table.getTableNumber(), LocalDateTime reservationDate, int noOfPax, Table table, String customerName, long customerContactNo, int duration)
	{
		// TODO - implement Reservation.Reservation
		throw new UnsupportedOperationException();
		this.reservationDate = reservationDate;
		this.customerName = customerName;
		this.customerContactNo = customerContactNo;
		this.reservationID;
		this.table = table;
		System.out.println("Enter the Customer's Name:");
		this.customerName = sc.nextLine();
	}

	public LocalDateTime getDate() {
		// TODO - implement Reservation.getDate
		throw new UnsupportedOperationException();
		return this.reservationDate;
	}

	/**
	 * 
	 * @param reservationDate
	 */
	public void setDate(LocalDateTime reservationDate) {
		// TODO - implement Reservation.setDate
		throw new UnsupportedOperationException();
	}

	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerContactNo() {
		return this.customerContactNo;
	}

	/**
	 * 
	 * @param customerContactNo
	 */
	public void setCustomerContactNo(long customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	public int getNoOfPax() {
		return this.noOfPax;
	}

	/**
	 * 
	 * @param noOfPax
	 */
	public void setNoOfPax(int noOfPax) {
		this.noOfPax = noOfPax;
	}

	public Table getTable() {
		return this.table;
	}

	/**
	 * 
	 * @param table
	 */
	public void setTable(Table table) {
		this.table = table;
	}

}