package EntityClass;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Reservation implements Serializable {

	private LocalDateTime reservationDate;
	private String customerName;
	private long customerContactNo;
	private int noOfPax;
	private Table table;
	Scanner sc = new Scanner(System.in);


	public Reservation(LocalDateTime reservationDate, Table table) {
		// TODO - implement Reservation.Reservation
		throw new UnsupportedOperationException();
		this.reservationDate = reservationDate;
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