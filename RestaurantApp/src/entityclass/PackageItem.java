package entityclass;

import java.util.ArrayList;

public class PackageItem extends MenuItem {

	private ArrayList<MenuItem> packageList;

	public PackageItem(String name, double price, String descript, ArrayList<MenuItem> p, String id) {
		super(name, price, descript, id);
		this.packageList = p;
	}

	public ArrayList<MenuItem> getpackageList() {
		return packageList;
	}

	public void setpackageList(ArrayList<MenuItem> packageList) {
		this.packageList = packageList;
	}

}