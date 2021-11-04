package entityclass;

import java.io.Serializable;

public class MenuItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -699417389557533574L;
	private String itemName;
	private double price;
	private String description;
	private String itemID;

	public MenuItem(String foodName, double foodprice, String foodDescription, String foodID) {
		// TODO - implement MenuItem.MenuItem
		this.itemName = foodName;
		this.price = foodprice;
		this.description = foodDescription;
		this.itemID = foodID;
	}

	public String getItemName() {
		return this.itemName;
	}

	/**
	 * 
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemID() {
		return this.itemID;
	}

	/**
	 * 
	 * @param itemID
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

}