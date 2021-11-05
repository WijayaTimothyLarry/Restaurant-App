package entityclass;

import java.util.ArrayList;

public class PackageItem extends MenuItem {

	private ArrayList<MenuItem> packageList;

	public PackageItem(String name, double price, String descript, ArrayList<MenuItem> p, String id) {
		// TODO - implement PackageItem.PackageItem
		super(name, price, descript, id);
		this.packageList = p;
	}

	public ArrayList<MenuItem> getpackageList() {
		// TODO - implement Menu.getMenuList
		return packageList;
	}

	public void setpackageList(ArrayList<MenuItem> packageList) {
		this.packageList = packageList;
	}

}