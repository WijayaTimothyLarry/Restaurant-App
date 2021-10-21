package EntityClass;

import java.io.Serializable;

public class PackageItem extends MenuItem implements Serializable {

	private double packagePrice;
	private String description;
	private MenuItem[] packageList;

	public PackageItem(double price,String descript, MenuItem[] p) {
		// TODO - implement PackageItem.PackageItem
		this.packagePrice = price;
		this.description = descript;
		this.packageList = p;
		throw new UnsupportedOperationException();
	}

	public double getPackagePrice() {
		return this.packagePrice;
	}

	/**
	 * 
	 * @param packagePrice
	 */
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	public String getDesciption() {
		// TODO - implement PackageItem.getDesciption
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param desciption
	 */
	public void setDescription(String desciption) {
		this.description = desciption;
	}

}