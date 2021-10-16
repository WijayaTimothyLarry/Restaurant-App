package entityclass;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

	private String orderID;
	private LocalDateTime orderDate;
	private int tableNumber;
	private String waiterName;
	private ArrayList<OrderItem> orderItems;
	private double totalBill;

	public Order() {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	public String getOrderID() {
		return this.orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public LocalDateTime getOrderDate() {
		return this.orderDate;
	}

	/**
	 * 
	 * @param orderDate
	 */
	public void setOrderDate(LocalDateTime orderDate) {
		// TODO - implement Order.setOrderDate
		throw new UnsupportedOperationException();
	}

	public int getTableNumber() {
		return this.tableNumber;
	}

	/**
	 * 
	 * @param tableNumber
	 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getWaiterName() {
		return this.waiterName;
	}

	/**
	 * 
	 * @param waiterName
	 */
	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	/**
	 * 
	 * @param orderItems
	 */
	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public double getTotalBill() {
		return this.totalBill;
	}

	/**
	 * 
	 * @param totalBill
	 */
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public void printReciept() {
		// TODO - implement Order.printReciept
		throw new UnsupportedOperationException();
	}

}