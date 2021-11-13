package entityclass;

import java.io.Serializable;

public class MenuItem implements Serializable {

	private String itemName;
	private double price;
	private String description;
	private String itemID;

	public static enum ItemType {
		APPETIZER, MAINCOURSE, DESSERT, DRINKS, PACKAGE
	}

	private ItemType itemType;

	/**
	 * Constructor for MenuItem
	 * 
	 * @param itemName    (String)Name of MenuItem
	 * @param price       (double)Price of MenuItem
	 * @param description (String)Description of MenuItem
	 * @param itemID      (String)ID of MenuItem
	 * @param itemType    (String)Type of MenuItem
	 */
	public MenuItem(String itemName, double price, String description, String itemID, ItemType itemType) {
		this.itemName = itemName;
		this.price = price;
		this.description = description;
		this.itemID = itemID;
		this.itemType = itemType;
	}

	/**
	 * Return the name of MenuItem
	 * 
	 * @return name of MenuItem
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * Set Name of the MenuItem
	 * 
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Function to return Price of MenuItem
	 * 
	 * @return price of item
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * set the price of MenuItem
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
	 * Set the description of MenuItem
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return ID of item
	 */
	public String getItemID() {
		return this.itemID;
	}

	/**
	 * Set ID of Item
	 * 
	 * @param itemID
	 */
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public ItemType getItemType() {
		return itemType;
	}

}