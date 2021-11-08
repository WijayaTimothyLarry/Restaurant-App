package entityclass;

import java.io.Serializable;
import java.util.*;

public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 635888539451999683L;
	private ArrayList<MainCourse> mainCourseList;
	private ArrayList<Dessert> dessertList;
	private ArrayList<Drinks> drinksList;
	private ArrayList<Appetizer> appeList;
	private ArrayList<PackageItem> packagesList;
	private ArrayList<MenuItem> menuList;
	private static ArrayList<MenuItem> menuList2;

	public Menu(ArrayList<Appetizer> appeList, ArrayList<MainCourse> mainCourseList, ArrayList<Dessert> dessertList,
			ArrayList<Drinks> drinksList, ArrayList<PackageItem> packagesList) {
		// TODO - implement Menu.Menu
		this.appeList = appeList;
		this.mainCourseList = mainCourseList;
		this.dessertList = dessertList;
		this.drinksList = drinksList;
		this.packagesList = packagesList;
		this.menuList = new ArrayList<MenuItem>();
		this.menuList.addAll(appeList);
		this.menuList.addAll(mainCourseList);
		this.menuList.addAll(dessertList);
		this.menuList.addAll(packagesList);
		menuList2 = menuList;
	}

	public void printMainCourse() {
		System.out.println("          MAIN COURSE          ");
		System.out.println("******************************");
		if (mainCourseList.size() == 0) {
			System.out.println("This list is empty");
		}
		for (int i = 0; i < mainCourseList.size(); i++) {
			MainCourse item = mainCourseList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************\n");

		}

	}

	public void printDrinks() {
		System.out.println("          DRINKS         ");
		System.out.println("******************************");
		if (drinksList.size() == 0) {
			System.out.println("This list is empty");
		}
		for (int i = 0; i < drinksList.size(); i++) {
			Drinks item = drinksList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************\n");

		}

	}

	public void printDessert() {
		System.out.println("          DESSERT          ");
		System.out.println("******************************");
		if (dessertList.size() == 0) {
			System.out.println("This list is empty");
		}
		for (int i = 0; i < dessertList.size(); i++) {
			Dessert item = dessertList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************\n");

		}

	}

	public void printAppeList() {
		System.out.println("          APPETIZER          ");
		System.out.println("******************************\n");
		if (appeList.size() == 0) {
			System.out.println("This list is empty");
		}
		for (int i = 0; i < appeList.size(); i++) {
			Appetizer item = appeList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************\n");

		}

	}

	public void printPackage() {
		System.out.println("          SPECIAL PACKAGES         ");
		System.out.println("******************************");
		if (packagesList.size() == 0) {
			System.out.println("This list is empty");
		}
		for (int i = 0; i < packagesList.size(); i++) {
			PackageItem item = packagesList.get(i);
			ArrayList<MenuItem> packageList = item.getpackageList();
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			System.out.println("Items included are ");
			for (int j = 0; j < packageList.size(); j++) {
				MenuItem iteminpackage = packageList.get(j);
				System.out.printf("(%d) %s \n", j + 1, iteminpackage.getItemName());
			}
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************\n");

		}

	}

	public void printMenu() {
		System.out.println("          MENU          ");
		System.out.println("******************************");
		if (menuList.size() == 0) {
			System.out.println("This list is empty");
		}
		for (int i = 0; i < menuList.size(); i++) {
			MenuItem item = menuList.get(i);
			System.out.println("Name: " + item.getItemName());
			System.out.println("Price: " + item.getPrice());
			System.out.println("Description: " + item.getDescription());
			if (item instanceof PackageItem) {
				System.out.println("Items included are");
				PackageItem itemtopackage = (PackageItem) item;
				ArrayList<MenuItem> packageList = itemtopackage.getpackageList();
				for (int j = 0; j < packageList.size(); j++) {
					MenuItem iteminpackage = packageList.get(i);
					System.out.printf("%d) %s", j + 1, iteminpackage.getItemName());
				}
			}
			System.out.println("ID: " + item.getItemID());
			System.out.println("******************************\n");

		}
	}

	/**
	 * 
	 * @param mainCourseList
	 */

	public ArrayList<MainCourse> getMainCourseList() {
		return this.mainCourseList;
	}

	public void setMainCourseList(ArrayList<MainCourse> mainCourseList) {
		this.mainCourseList = mainCourseList;
	}

	public int removeforMainCourseList(String id) {
		Iterator<MainCourse> itr = mainCourseList.iterator();
		while (itr.hasNext()) {
			MainCourse food = itr.next();
			if (food.getItemID().equals(id)) {
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;
	}

	public void addintoMainCourseList(MainCourse maincourse) {
		mainCourseList.add(maincourse);
	}

	public int findforMainCourseList(String id) {
		int i = 0;
		for (MainCourse maincourse : mainCourseList) {
			String maincourseID = maincourse.getItemID();
			if (maincourseID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void setforMainCourseList(int index, MainCourse newMainCourse) {
		mainCourseList.set(index, newMainCourse);
	}

	/**
	 * 
	 * @param dessertList
	 */

	public ArrayList<Dessert> getDessertList() {
		return this.dessertList;
	}

	public void setDessertList(ArrayList<Dessert> dessertList) {
		this.dessertList = dessertList;
	}

	public int removeforDessertList(String id) {
		Iterator<Dessert> itr = dessertList.iterator();
		while (itr.hasNext()) {
			Dessert food = itr.next();
			if (food.getItemID().equals(id)) {
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}

	public void addintoDessertList(Dessert dessert) {
		dessertList.add(dessert);
	}

	public int findforDessertList(String id) {
		int i = 0;
		for (Dessert dessert : dessertList) {
			String dessertID = dessert.getItemID();
			if (dessertID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void setforDessertList(int index, Dessert newDessert) {
		dessertList.set(index, newDessert);
	}

	/**
	 * 
	 * @param drinksList
	 */

	public ArrayList<Drinks> getDrinksList() {
		return this.drinksList;
	}

	public void setDrinksList(ArrayList<Drinks> drinksList) {
		this.drinksList = drinksList;
	}

	public int removeforDrinksList(String id) {
		Iterator<Drinks> itr = drinksList.iterator();
		while (itr.hasNext()) {
			Drinks food = itr.next();
			if (food.getItemID().equals(id)) {
				
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}

	public void addintoDrinksList(Drinks drink) {
		drinksList.add(drink);
	}

	public int findforDrinksList(String id) {
		int i = 0;
		for (Drinks drinks : drinksList) {
			String drinksID = drinks.getItemID();
			if (drinksID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void setforDrinksList(int index, Drinks newDrinks) {
		drinksList.set(index, newDrinks);
	}

	/**
	 * 
	 * @param packageList
	 */

	public ArrayList<PackageItem> getPackagesList() {
		return this.packagesList;
	}

	public void setPackageList(ArrayList<PackageItem> packagesList) {
		this.packagesList = packagesList;
	}

	public int removeforPackageList(String id) {
		Iterator<PackageItem> itr = packagesList.iterator();
		while (itr.hasNext()) {
			PackageItem food = itr.next();
			if (food.getItemID().equals(id)) {
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}

	public void addintoPackageList(PackageItem package1) {
		packagesList.add(package1);
	}

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

	public void setforPackagesList(int index, PackageItem newPackageItem) {
		packagesList.set(index, newPackageItem);
	}

	/**
	 * 
	 * @param appeList
	 */
	public ArrayList<Appetizer> getAppeList() {
		return this.appeList;
	}

	public void setAppeList(ArrayList<Appetizer> appeList) {
		this.appeList = appeList;
	}

	public int removeforAppeList(String id) {
		Iterator<Appetizer> itr = appeList.iterator();
		while (itr.hasNext()) {
			Appetizer food = itr.next();
			if (food.getItemID().equals(id)) {
				System.out.println("Item found");
				itr.remove();
				System.out.println("Item deleted");
				return 1;
			}
		}
		return -1;

	}

	public void addintoAppeList(Appetizer appe) {
		appeList.add(appe);
	}

	public int findforAppeList(String id) {
		int i = 0;
		for (Appetizer appetizer : appeList) {
			String appeID = appetizer.getItemID();
			if (appeID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void setforAppeList(int index, Appetizer newAppetizer) {
		appeList.set(index, newAppetizer);
	}

	public void setMenuList(ArrayList<MenuItem> menuList) {
		this.menuList = menuList;
		menuList2 = menuList;
	}

	public ArrayList<MenuItem> getMenuList() {
		// TODO - implement Menu.getMenuList
		return menuList;
	}

	public static ArrayList<MenuItem> getMenu() {
		return menuList2;
	}

	public int removeforMenuList(String id) {
		Iterator<MenuItem> itr = menuList.iterator();
		while (itr.hasNext()) {
			MenuItem food = itr.next();
			if (food.getItemID().equals(id)) {
				itr.remove();
				return 1;
			}
		}
		return -1;
	}

	public void addintoMenuList(MenuItem food) {
		menuList.add(food);
	}

	public int findforMenuList(String id) {
		int i = 0;
		for (MenuItem menuitem : menuList) {
			String menuID = menuitem.getItemID();
			if (menuID.contains(id)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void setforMenuList(int index, MenuItem newMenuItem) {
		menuList2.set(index, newMenuItem);
		menuList.set(index, newMenuItem);
	}

}