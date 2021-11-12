package entityclass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import database.Restaurant;
import utils.StringUtils;

public class Order implements Serializable {

	private int orderID;
	private Calendar orderDate;
	private int tableNumber;
	private String waiterName;
	private boolean isMember;
	private ArrayList<OrderItem> orderItems;
	private double totalBill;
	private Invoice invoice;
	private int pax;
	// private Reservation reservation;

	public Order(Calendar date, int tableNo, int pax, String waiterName, boolean isMember) {
		this.orderID = Calendar.getInstance().hashCode();
		this.orderDate = date;
		this.tableNumber = tableNo;
		this.waiterName = waiterName;
		this.isMember = isMember;
		this.orderItems = new ArrayList<OrderItem>();
		this.invoice = null;
		this.pax = pax;
	}

	public int getPax() {
		return this.pax;
	}

	public void setPax(int pax) {
		this.pax = pax;
	}

	public int getOrderID() {
		return this.orderID;
	}

	/**
	 * 
	 * @param orderID
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Calendar getOrderDate() {
		return this.orderDate;
	}

	/**
	 * 
	 * @param orderDate
	 */
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
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
	 * @param isMember
	 */
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public boolean getIsMember() {
		return this.isMember;
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

	public double calTotalBill() {
		double bill = 0;
		for (OrderItem orderItem : orderItems) {
			int quantity = orderItem.getQuantity();
			double price = orderItem.getPrice();
			bill += (quantity * price);
		}
		return bill;
	}

	public void addOrderItem(OrderItem newItem) {

		if (this.invoice != null)
			return; // lock order for editing when invoice already generated
		this.orderItems.add(newItem);

	}

	public void removeOrderItem(OrderItem removeItem) {

		if (this.invoice != null)
			return; // lock order for editing when invoice already generated
		this.orderItems.add(removeItem);
	}

	public void generateInvoice() {

		if (this.invoice != null)
			return; // lock order for editing when invoice
		// already generated
		this.invoice = new Invoice(this);
		Restaurant.invoiceList.add(invoice);
		invoice.printInvoice();
	}

	/**
	 * prints order items in the order's orderlineitems
	 */

	public String toString() {
		String orderString = "";
		for (OrderItem orderItem : orderItems) {

			orderString += StringUtils.rightPadding(Integer.toString(orderItem.getQuantity()), ' ', 2) + "   "
					+ StringUtils.rightPadding(orderItem.getItem().getItemName(), ' ', 30) + "   "
					+ orderItem.getPrice() + " " + StringUtils.leftPadding(
							String.format("%.2f", orderItem.getPrice() * orderItem.getQuantity()), ' ', 7)
					+ "\n";

		}
		if (orderString.length() == 0)
			return "There are no order yet";
		return orderString;
	}

}