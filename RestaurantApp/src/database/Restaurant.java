package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entityclass.Menu;
import entityclass.Table;
import entityclass.MenuItem.ItemType;
import entityclass.Reservation;
import entityclass.Staff;
import entityclass.Invoice;
import entityclass.Order;
import entityclass.Customer;
import entityclass.MenuItem;
import entityclass.PackageItem;

public class Restaurant {

	public static Menu restaurantMenu;
	public static ArrayList<Table> tableList;
	public static ArrayList<Reservation> reservationList;
	public static ArrayList<Staff> staffList;
	public static ArrayList<Invoice> invoiceList;
	public static ArrayList<Order> orderList;
	public static ArrayList<Customer> memberList;

	public static void createRestaurant() {
		createMenu();
		createTableList();
		createReservationList();
		createStaffList();
		createInvoiceList();
		createOrderList();
		createMemberList();
	}

	/**
	 * Function to create and initialise menu for the restaurant Add sample items to
	 * Appetizer List, Main Course List, Dessert List, Drinks List and PackageList
	 */
	public static void createMenu() {

		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();

		// Initialize Appetizers
		MenuItem appetizer1 = new MenuItem("Mushroom Soup", 5, "Homemade cream of mushroom soup", "A1",
				ItemType.APPETIZER);
		MenuItem appetizer2 = new MenuItem("Zuppa Soup", 6, "Creamy soup topped with flaky puff pastry", "A2",
				ItemType.APPETIZER);
		MenuItem appetizer3 = new MenuItem("Goulash Soup", 6, "Hearty beef and vegetable soup with bread on the side",
				"A3", ItemType.APPETIZER);

		// add appetizer to appetizer menu
		menuList.add(appetizer1);
		menuList.add(appetizer2);
		menuList.add(appetizer3);

		// Initialize Main Course
		MenuItem mainCourse1 = new MenuItem("Chicken Cordon Bleu", 15,
				"Breaded fried chicken filled with creamy mozarella", "M1", ItemType.MAINCOURSE);
		MenuItem mainCourse2 = new MenuItem("Ribeye Steak", 20,
				"Grilled Beef Steak with Hollandaise Sauce and Sautéed Vegetables", "M2", ItemType.MAINCOURSE);
		MenuItem mainCourse3 = new MenuItem("Grilled Porterhouse steak", 20,
				"Bone in king of steak with Red Wine Sauce", "M3", ItemType.MAINCOURSE);

		// add maincourse to maincourse menu
		menuList.add(mainCourse1);
		menuList.add(mainCourse2);
		menuList.add(mainCourse3);

		// initialize dessert
		MenuItem dessert1 = new MenuItem("Tiramisu Cake", 7,
				"Coffee flavoured Italian dessert topped with brazillian espresso powder", "D1", ItemType.DESSERT);
		MenuItem dessert2 = new MenuItem("Strawberry Shortcake", 6,
				"Sweetsour strawberry to freshen you from the grease", "D2", ItemType.DESSERT);
		MenuItem dessert3 = new MenuItem("Blackforest Gateau ", 7, "chocolate sponge cake with a rich cherry filling",
				"D3", ItemType.DESSERT);

		// add dessert to dessert menu
		menuList.add(dessert1);
		menuList.add(dessert2);
		menuList.add(dessert3);

		// initialize drinks
		MenuItem drink1 = new MenuItem("The Red Hood", 4, "Mixed of fresh pomegranate and cranberry juices", "B1",
				ItemType.DRINKS);
		MenuItem drink2 = new MenuItem("Bloddy Marry", 5,
				"Want to spice things up? Bloody Mary with extra smoked Tabasco thrown into the mix", "B2",
				ItemType.DRINKS);
		MenuItem drink3 = new MenuItem("Ginger and Pear Punch", 4,
				"Suprise yourself with the punch of our house specialty ", "B3", ItemType.DRINKS);

		// add drinks to drinks menu
		menuList.add(drink1);
		menuList.add(drink2);
		menuList.add(drink3);

		// initialize packages
		ArrayList<MenuItem> packageList1 = new ArrayList<MenuItem>();
		packageList1.add(appetizer1);
		packageList1.add(mainCourse1);
		packageList1.add(drink1);
		PackageItem package1 = new PackageItem("Mushroom Chicken in the Hood", 22,
				"Start the night with mushroom soup, fill up with Chicken Cordon Bleu and fresh up with The Red Hood ",
				packageList1, "P1", ItemType.PACKAGE);

		ArrayList<MenuItem> packageList2 = new ArrayList<MenuItem>();
		packageList2.add(appetizer3);
		packageList2.add(mainCourse2);
		packageList2.add(drink2);
		PackageItem package2 = new PackageItem("Spicy Heavy Meal", 22,
				"Hearty meal of Goulash Soup and Grilled Porterhouse Steak coupled wiht Bloody Marry to spice up the night",
				packageList2, "P2", ItemType.PACKAGE);

		// add packages to packageList
		menuList.add(package1);
		menuList.add(package2);

		// initialize menu
		Restaurant.restaurantMenu = new Menu(menuList);

	}

	/**
	 * Function to create and initialise tables in the restaurant Add 5 tables of
	 * size 2, 5 tables of size 4, 3 tables of size 6 ,3 tables of size 8 and 1
	 * table of size 10 Initialize staff list
	 */
	public static void createTableList() {
		ArrayList<Table> tableList = new ArrayList<Table>();

		// initialize 5 tables for 2
		for (int i = 1; i <= 5; i++) {
			Table newTable = new Table(i, 2);
			tableList.add(newTable);
		}

		// intialize 5 tables for 4
		for (int i = 1; i <= 5; i++) {
			Table newTable = new Table(i + 5, 4);
			tableList.add(newTable);
		}

		// initialize 3 table for 6
		for (int i = 1; i <= 3; i++) {
			Table newTable = new Table(i + 10, 6);
			tableList.add(newTable);
		}

		// initialize 3 table for 8
		for (int i = 1; i <= 3; i++) {
			Table newTable = new Table(i + 13, 8);
			tableList.add(newTable);
		}

		// initialize 1 table for 10

		Table newTable = new Table(17, 10);
		tableList.add(newTable);

		Restaurant.tableList = tableList;

	}

	/**
	 * Create and initialize staff for the restaurant Add 5 waiters to the
	 * restaurant Add 3 chefs to the restaurant Add 1 manager to the restaurant
	 * Initialize staffList
	 */
	public static void createStaffList() {
		ArrayList<Staff> staffList = new ArrayList<Staff>();

		// intialize waiters
		Staff waiter1 = new Staff("John", "Male", "W1", "Waiter");
		Staff waiter2 = new Staff("Bill", "Male", "W2", "Waiter");
		Staff waiter3 = new Staff("Mary", "Female", "W3", "Waiter");
		Staff waiter4 = new Staff("Ronald", "Male", "W4", "Waiter");
		Staff waiter5 = new Staff("Joy", "Female", "W5", "Waiter");

		// add waiters to staffList
		staffList.add(waiter1);
		staffList.add(waiter2);
		staffList.add(waiter3);
		staffList.add(waiter4);
		staffList.add(waiter5);

		// initialize chefs
		Staff chef1 = new Staff("Ronnie", "Male", "C1", "Head Chef");
		Staff chef2 = new Staff("Bob", "Male", "C2", "Chef");
		Staff chef3 = new Staff("Lenny", "Male", "C3", "Chef");

		// add chefs to staffList
		staffList.add(chef1);
		staffList.add(chef2);
		staffList.add(chef3);

		// initialize manager
		Staff manager = new Staff("Roy", "Male", "M1", "Manager");

		// add manager to staffList
		staffList.add(manager);

		Restaurant.staffList = staffList;
	}

	/**
	 * Function to create and initialize Reservation List
	 */
	public static void createReservationList() {
		Restaurant.reservationList = new ArrayList<Reservation>();

	}

	/**
	 * Function to create and initialize Invoice List
	 */

	public static void createInvoiceList() {
		Restaurant.invoiceList = new ArrayList<Invoice>();
	}

	/**
	 * Function to create and initialize Order List
	 */
	public static void createOrderList() {
		Restaurant.orderList = new ArrayList<Order>();
	}

	/**
	 * Function to create and initialize Member List
	 */
	public static void createMemberList() {
		ArrayList<Customer> memberList = new ArrayList<Customer>();

		// initialize member
		Customer member1 = new Customer("Sherwin", "Male", "96448561", true);
		Customer member2 = new Customer("Larry", "Male", "23456789", true);
		Customer member3 = new Customer("Junhui", "Male", "34567891", true);
		Customer member4 = new Customer("Pheng Kai", "Male", "45678912", true);

		// add member to memberList
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);

		Restaurant.memberList = memberList;
	}

	/**
	 * Function to save restaurant in serializable form
	 */
	public static void saveRestaurant() {

		ArrayList<Object> data = new ArrayList<Object>();
		data.add(Restaurant.restaurantMenu);
		data.add(Restaurant.tableList);
		data.add(Restaurant.reservationList);
		data.add(Restaurant.staffList);
		data.add(Restaurant.invoiceList);
		data.add(Restaurant.orderList);
		data.add(Restaurant.memberList);

		try {
			FileOutputStream fos = new FileOutputStream("restaurant.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			System.out.println("Restaurant data is saved");
		} catch (IOException i) {
			i.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public static void loadRestaurant() {
		ArrayList<Object> deserialized = new ArrayList<Object>();
		try {
			FileInputStream fis = new FileInputStream("restaurant.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			deserialized = (ArrayList<Object>) ois.readObject();
			ois.close();
			fis.close();

		} catch (IOException i) {
			i.printStackTrace();
			return;

		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}

		Restaurant.restaurantMenu = (Menu) deserialized.get(0);
		Restaurant.tableList = (ArrayList<Table>) deserialized.get(1);
		Restaurant.reservationList = (ArrayList<Reservation>) deserialized.get(2);
		Restaurant.staffList = (ArrayList<Staff>) deserialized.get(3);
		Restaurant.invoiceList = (ArrayList<Invoice>) deserialized.get(4);
		Restaurant.orderList = (ArrayList<Order>) deserialized.get(5);
		Restaurant.memberList = (ArrayList<Customer>) deserialized.get(6);
	}
}
