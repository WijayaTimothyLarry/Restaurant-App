package entityclass;

import java.io.Serializable;
import java.util.*;

import entityclass.MenuItem.ItemType;

public class Menu implements Serializable {
	private ArrayList<PackageItem> packagesList;
	private ArrayList<MenuItem> menuList;

	/**
	 * Constructor for Menu
	 * 
	 * @param menuList     (ArrayList<MenuItem>) List of all MenuItem
	 * @param packagesList (ArrayList<PackageItem>) List of MenuItem PackageItem
	 */
	public Menu(ArrayList<MenuItem> menuList) {
		this.menuList = menuList;
		for (MenuItem menuitem : menuList) {
			if (menuitem.getItemType() == ItemType.PACKAGE) {
				packagesList.add((PackageItem)menuitem);
			}
		}
	}

	public int removeforMenuList(String id) {
		Iterator<MenuItem> itr = menuList.iterator();
		while (itr.hasNext()) {
			MenuItem food = itr.next();
			if (food.getItemID().equals(id)) {
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;
	}

	public void addintoMenuList(MenuItem menuitem) {
		menuList.add(menuitem);
	}

	public int findforMenuList(String id) {
		int i = 0;
		for (MenuItem menuitem : menuList) {
			String menuitemID = menuitem.getItemID();
			if (menuitemID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void setforMenuList(int index, MenuItem newMenuItem) {
		menuList.set(index, newMenuItem);
	}

	public void setMenuList(ArrayList<MenuItem> menuList) {
		this.menuList = menuList;
	}

	public ArrayList<MenuItem> getMenuList() {
		return this.menuList;
	}

	public int removeforPackageList(String id) {
		Iterator<PackageItem> itr = packagesList.iterator();
		while (itr.hasNext()) {
			PackageItem food = itr.next();
			if (food.getItemID().equals(id)) {
				removeforMenuList(id);
				itr.remove();
				return 1;
			}
		}
		return -1;

	}

	public int removeforitemsinPackageList(String packageID, String foodID) {
		try {
			PackageItem packageofInterest = packagesList.get(findforPackageList(packageID));
			ArrayList<MenuItem> listofInterest = packageofInterest.getpackageList();
			Iterator<MenuItem> itr = listofInterest.iterator();
			while (itr.hasNext()) {
				MenuItem itemofInterest = itr.next();
				if (itemofInterest.getItemID().equals(foodID)) {
					System.out.println("Item found");
					System.out.println();
					itr.remove();
					System.out.println("Item deleted");
					System.out.println();
					return 1;
				}
			}
			return -1;
		} catch (IndexOutOfBoundsException e) {
			return -1;
		}
	}

	/**
	 * Function to add a package into the package list
	 * 
	 * @param package1 (PackageItem) item to be added into the package list
	 */

	public void addintoPackageList(PackageItem package1) {
		packagesList.add(package1);
	}

	public void addIntoItemsInPackageList(String packageID, MenuItem food) {
		try {
			PackageItem packageofInterest = packagesList.get(findforPackageList(packageID));
			ArrayList<MenuItem> listofInterest = packageofInterest.getpackageList();
			listofInterest.add(food);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid Package!");
		}
	}

	/**
	 * Function to find the index of package item from its id in the package item
	 * list
	 * 
	 * @param id (String) package item id to be found
	 * @return (int)index of the package item found
	 */

	public int findforPackageList(String id) {
		int i = 0;
		for (PackageItem p : packagesList) {
			String packageID = p.getItemID();
			if (packageID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	/**
	 * Function to set a new package item and its index into the packages list
	 * 
	 * @param index          (int) index of the package item to be set into the
	 *                       packages list
	 * @param newPackageItem (PackageItem) item to be set in the package item list
	 */

	public void setforPackagesList(int index, PackageItem newPackageItem) {
		packagesList.set(index, newPackageItem);
	}

	public void setPackageList(ArrayList<PackageItem> packagesList) {
		this.packagesList = packagesList;
	}

	public ArrayList<PackageItem> getPackagesList() {
		return this.packagesList;
	}

	// Functions to get specific type of food
	// 1)Appetizer
	public ArrayList<MenuItem> getItemListByType(ItemType type) {
		ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuList) {
			if (menuItem.getItemType() == type) {
				itemList.add(menuItem);
			}
		}
		return itemList;

	}

}