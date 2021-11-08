package entityclass;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import utils.StringUtils;
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
	private double discount;

	public static final double GST = 0.07; // According to Singapore Goods and Services Tax
	public static final double serviceCharge = 0.10;
	public static final double memDiscount = 0.10;

	public Invoice(Order order) {
		this.order = order;
		this.invoiceID = Calendar.getInstance().hashCode(); // Assigning a unique value to an object by hashing
		this.subtotal = order.calTotalBill();
		this.SCHARGE = this.subtotal * serviceCharge;
		this.gst = (this.SCHARGE + this.subtotal) * GST;
		this.discount = -(this.subtotal * memDiscount);
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
		System.out.println("**************************************************");
		System.out.println("                  STEAK & GRILLS                  ");
		System.out.println("**************************************************");
		System.out.println("Service staff: " + this.waiterName);
		System.out.println("Table: " + this.tableNumber);
		System.out.println("Pax: " + order.getPax());
		System.out.println("InvoiceID: " + this.invoiceID);
		System.out.println("Date: " + this.dateTime);
		System.out.println("--------------------------------------------------");
		System.out.println("                      Orders                      ");
		System.out.println("--------------------------------------------------");
		System.out.println("Quantity   " + StringUtils.rightPadding("Order Items", ' ', 30)
				+ StringUtils.rightPadding("Price", ' ', 9));
		System.out.println(order.toString());
		System.out.println("--------------------------------------------------");
		System.out.println("Subtotal: " + StringUtils.leftPadding(String.format("%.2f", this.subtotal), ' ', 40));
		System.out.println("--------------------------------------------------");
		// membership discount
		if (order.getIsMember()) {
			System.out.println("Membership Discount(10%): "
					+ StringUtils.leftPadding(String.format("%.2f", this.discount), ' ', 24));
			System.out.println(
					"Service Charge(10%): " + StringUtils.leftPadding(String.format("%.2f", this.SCHARGE), ' ', 29));
			System.out.println("GST(7%): " + StringUtils.leftPadding(String.format("%.2f", this.gst), ' ', 41));
			System.out.println("--------------------------------------------------");
			System.out.println("TOTAL: "
					+ StringUtils.leftPadding(String.format("%.2f", this.totalBill + this.discount), ' ', 43));
			System.out.println("--------------------------------------------------");
			System.out.println("TEL : 6737 4411          /  FAX : 6732 2366       ");
			System.out.println("         52 Nanyang Ave, Singapore 639816         ");
			System.out.println("**************************************************");

		} else {
			System.out.println(
					"Service Charge(10%): " + StringUtils.leftPadding(String.format("%.2f", this.SCHARGE), ' ', 29));
			System.out.println("GST(7%): " + StringUtils.leftPadding(String.format("%.2f", this.gst), ' ', 41));
			System.out.println("--------------------------------------------------");
			System.out.println("TOTAL: " + StringUtils.leftPadding(String.format("%.2f", this.totalBill), ' ', 43));
			System.out.println("--------------------------------------------------");
			System.out.println("TEL : 6737 4411          /  FAX : 6732 2366       ");
			System.out.println("         52 Nanyang Ave, Singapore 639816         ");
			System.out.println("**************************************************");
		}
	}

}