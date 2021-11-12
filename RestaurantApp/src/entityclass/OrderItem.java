package entityclass;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private MenuItem item;
	/**
	 * Price of item derived from MenuItem
	 * @see MenuItem
	 */
	private double price;
	private int quantity;
	/**
	 * Price of item derived from MenuItem
	 * @see MenuItem
	 */
	private String name;

	/**
	 * Constructor of OrderItem
	 * @param item (MenuItem)MenuItem it corresponds to
	 * @param quantity (int)Number of this item ordered
	 */
	public OrderItem(MenuItem item, int quantity) {
		this.item = item;
		this.quantity = quantity;
		this.price = item.getPrice();
		this.name = getItemName();

	}

	/**
	 * Function to get the price of the item ordered
	 * @return (int)Price of item ordered
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Function to set the price of the item ordered
	 * @param price (int)Price to be set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Function to get the item ordered
	 * @return (MenuItem)the MenuItem ordered
	 */
	public MenuItem getItem() {
		return this.item;
	}

	/**
	 * Function to set the order item
	 * @param item (MenuItem)MenuItem to be set
	 */
	public void setItem(MenuItem item) {
		this.item = item;
	}

	/**
	 * Function to get quantity of item ordered
	 * @return (int)Quantity of item ordered
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Function to set the name of the order item
	 * @param itemName (String)name of OrderItem to be set
	 */
	public void setitemName(String itemName) {
		this.name = itemName;
	}

	/**
	 * Function to get the name of the Order item
	 * @return (String)Name of item ordered
	 */

	public String getItemName() {
		return this.name;
	}

	/**
	 * Function to set the quantity of items ordered
	 * @param quantity (int)Number of item ordered to be set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Function to get item name
	 * @return (String)Item name
	 * @see MenuItem
	 */

	public String toString() {
		return this.getItem().getItemName();
	}

}