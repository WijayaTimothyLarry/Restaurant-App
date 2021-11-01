package entityclass;

import java.io.Serializable;
import java.util.Calendar;
import java.util.ArrayList;

public class Invoice implements Serializable {

	private Order order;
	private int invoiceID;
	private int tableNumber;
	private double totalBill;
	private ArrayList<OrderItem> orderItems;
	private String waiterName;
	private double gst;
	private double price;
	private Calendar dateTime;

	public static final double GST = 0.07; // According to Singapore Goods and Services Tax
	public Invoice(Order order){
		this.order = order;
		this.invoiceID = Calendar.getInstance().hashCode(); // Assigning a unique value to an object by hashing
		this.price = order.calTotalBill();
		this.gst = this.price * GST;
		this.totalBill = this.price + this.gst;
		this.dateTime = Calendar.getInstance();
	}

	public Calendar getDatetime() {
		return dateTime;
	}

	/**
	 * 
	 * @param invoiceDateTime
	 */
	public void setDatetime(Calendar invoiceDateTime) {
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

	public void printInvoice(){
		System.out.println("          RESTAURANT          ");
		System.out.println("******************************");
		System.out.println("Service staff: " + this.waiterName);
		System.out.println("InvoiceID: " + this.invoiceID);
		System.out.println("Ordered items: " + this.order); // cannot print class: make a print function in orderitem and loop through orderitem that also outputs quantity
		System.out.println("Subtotal: " + this.price);
		System.out.println("GST: " + this.gst);
		System.out.println("TOTAL: " + this.totalBill);
		System.out.println("******************************");
	}

}