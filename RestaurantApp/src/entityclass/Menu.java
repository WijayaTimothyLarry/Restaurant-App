package entityclass;

import java.io.Serializable;
import java.util.*;

import entityclass.MenuItem.ItemType;

public class Menu implements Serializable {
	private ArrayList<PackageItem> packagesList;
	private ArrayList<MenuItem> menuList;

	/**
	 * Constructor for Menu
	 * @param menuList     (ArrayList<MenuItem>) List of all MenuItem
	 */
	public Menu(ArrayList<MenuItem> menuList) {
		this.menuList = menuList;
		this.packagesList = new ArrayList<PackageItem>();
		for (MenuItem menuitem : menuList) {
			if (menuitem.getItemType() == ItemType.PACKAGE) {
				packagesList.add((PackageItem) menuitem);
			}
		}
	}

	/**
	 * Function to remove an item from MenuList based on ID
	 * @param id ID of item to be removed
	 * @return (int)Index of item if found and removed,-1 if item not found
	 */
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

	/**
	 * Function to add a new menuItem into menu list
	 * @param menuitem menuitem to be added
	 */
	public void addintoMenuList(MenuItem menuitem) {
		menuList.add(menuitem);
	}

	/**
	 * Function to find an item from Menu based on ID
	 * @param id ID to search for
	 * @return (int) index of item if found,-1 if not found
	 */
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

	/**
	 * Function to set a new Menu item at a particular index
	 * @param index index of item to be replaced
	 * @param newMenuItem new menu item to insert into list
	 */
	public void setforMenuList(int index, MenuItem newMenuItem) {
		menuList.set(index, newMenuItem);
	}

	/**
	 * Setter function for menu list
	 * @param menuList
	 */

	public void setMenuList(ArrayList<MenuItem> menuList) {
		this.menuList = menuList;
	}

	/**
	 * Getter function for menu list
	 * @return
	 */
	public ArrayList<MenuItem> getMenuList() {
		return this.menuList;
	}

	/**
	 * Function to remove a promo package based on ID
	 * @param id ID of package to be removed
	 * @return (int)1 if found and removed, -1 if not found
	 */
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
	/**
	 * Function to remove an item from a specific promo package based on ID
	 * @param packageID ID of the promo package
	 * @param foodID ID of the item to be removed
	 * @return (int)1 if found and deleted, -1 if not found
	 */

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

	/**
	 * Function to add a MenuItem into the MenuList of a Package
	 * @param packageID ID of the Package
	 * @param food food to be added into the package
	 */
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

	/**
	 * Setter function for package list
	 * @param packagesList
	 */
	public void setPackageList(ArrayList<PackageItem> packagesList) {
		this.packagesList = packagesList;
	}

	/**
	 * Getter function of package list
	 * @return
	 */
	public ArrayList<PackageItem> getPackagesList() {
		return this.packagesList;
	}

	/**
	 * Function to get a list of item of a certain type
	 * @param type type of item(Appetizer, Main Course etc)
	 * @return list of the type of item from menu
	 */
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