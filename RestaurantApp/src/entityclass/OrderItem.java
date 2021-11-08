package entityclass;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private MenuItem item;
	private double price;
	private int quantity;
	private String name;

	public OrderItem(MenuItem food, int quant) {
		this.item = food;
		this.quantity = quant;
		this.price = food.getPrice();
		this.name = getItemName();

	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuItem getItem() {
		return this.item;
	}

	/**
	 * 
	 * @param item
	 */
	public void setItem(MenuItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setitemName(String itemName) {
		this.name = itemName;
	}

	public String getItemName() {
		return this.name;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		return this.getItem().getItemName();
	}

}