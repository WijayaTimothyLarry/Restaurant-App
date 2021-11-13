package entityclass;

import java.util.ArrayList;

public class PackageItem extends MenuItem {

	private ArrayList<MenuItem> packageList;

	/**
	 * Consturctor for PromoPackages Child class of MenuItem
	 * 
	 * @param name     name of PromoPackage
	 * @param price    price of PromoPackage
	 * @param descript description of PromoPackage
	 * @param p        list of MenuItem contained in the PromoPackage
	 * @param id       id of PromoPackage
	 * @param itemType type of item
	 * @see MenuItem
	 */
	public PackageItem(String name, double price, String descript, ArrayList<MenuItem> p, String id,
			ItemType itemType) {
		super(name, price, descript, id, itemType);
		this.packageList = p;
	}

	/**
	 * 
	 * @return (ArrayList<MenuItem>)List of MenuItem contained in PromoPackage
	 */
	public ArrayList<MenuItem> getpackageList() {
		return packageList;
	}

	/**
	 * Set the List of MenuItem contained in PromoPackage
	 * 
	 * @param packageList List of MenuItem contained in PromoPackage
	 */
	public void setpackageList(ArrayList<MenuItem> packageList) {
		this.packageList = packageList;
	}

}