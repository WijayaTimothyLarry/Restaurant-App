package entityclass;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Invoice implements Serializable {

	private Order order;
	private int invoiceID;
	private int tableNumber;
	private double totalBill;
	private ArrayList<OrderItem> orderItems;
	private String waiterName;
	private double gst;
	private double subtotal;
	private Date dateTime;
	private double SCHARGE;

	public static final double GST = 0.07; // According to Singapore Goods and Services Tax
	public static final double serviceCharge = 0.10; 

	public Invoice(Order order) {
		this.order = order;
		this.invoiceID = Calendar.getInstance().hashCode(); // Assigning a unique value to an object by hashing
		this.subtotal = order.calTotalBill();
		this.gst = this.subtotal * GST;
		this.SCHARGE = this.subtotal * serviceCharge;
		this.totalBill = this.subtotal + this.gst + this.SCHARGE;
		this.dateTime = Calendar.getInstance().getTime();
		
	}

	public Date getDatetime() {
		return dateTime;
	}

	/**
	 * 
	 * @param invoiceDateTime
	 */
	public void setDatetime(Date invoiceDateTime) {
		this.dateTime = invoiceDateTime;
	}

	public int getInvoiceID() {
		return this.invoiceID;
	}

	/**
	 * 
	 * @param invoiceID
	 */
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
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

	public void printInvoice() {
		System.out.println("          RESTAURANT          ");
		System.out.println("******************************");
		System.out.println("Service staff: " + this.waiterName);
		System.out.println("Table: " + this.tableNumber);
		System.out.println("Pax: " + order.getPax());
		System.out.println("InvoiceID: " + this.invoiceID);
		System.out.println("Date: " + this.dateTime);
		System.out.println("..............................");
		System.out.println("Ordered items: ");
		System.out.println(order.toString());
		System.out.println("Subtotal: " + String.format("%.2f",this.subtotal));
		System.out.println("GST(7%): " + String.format("%.2f",this.gst));
		System.out.println("Service Charge(10%): " + String.format("%.2f",this.SCHARGE));
		System.out.println("TOTAL: " + String.format("%.2f",this.totalBill));
		System.out.println("******************************");
	}

}