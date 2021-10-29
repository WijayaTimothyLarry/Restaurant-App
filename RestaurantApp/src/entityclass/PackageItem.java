package entityclass;

import java.io.Serializable;

public class PackageItem extends MenuItem implements Serializable {

	private String packageName;
	private double packagePrice;
	private String description;
	private MenuItem[] packageList;
	private String packageID;

	public PackageItem(String name,double price,String descript, MenuItem[] p,String id) {
		// TODO - implement PackageItem.PackageItem
		this.packageName = name;
		this.packagePrice = price;
		this.description = descript;
		this.packageList = p;
		this.packageID - id;
		throw new UnsupportedOperationException();
	}
	public String getPackageName(){
		return this.packageName;
	}
	
	public String setPackageName(String name){
		this.packageName = name;
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
	public String getPackageID(){
		return this.packageID;
	}
	
	public String setPackageName(String ID){
		this.packageID = ID;
	}


}