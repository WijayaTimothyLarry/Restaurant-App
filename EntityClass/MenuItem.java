package EntityClass;

import java.io.Serializable;

public class MenuItem implements Serializable {

	private String itemName;
	private double price;
	private String description;
	private String itemID;

	public MenuItem(String inputName, double inputPrice, String descript, String inputID) {
		this.itemName = inputName;
		this.price = inputPrice;
		this.description = descript;
		this.itemID = inputID;
		// TODO - implement MenuItem.MenuItem
		throw new UnsupportedOperationException();
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