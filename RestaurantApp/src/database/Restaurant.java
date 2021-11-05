package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entityclass.*;

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
	}

	public static void createMenu() {

		ArrayList<Appetizer> appeList = new ArrayList<Appetizer>();
		ArrayList<MainCourse> mainCourseList = new ArrayList<MainCourse>();
		ArrayList<Dessert> dessertList = new ArrayList<Dessert>();
		ArrayList<Drinks> drinkList = new ArrayList<Drinks>();
		ArrayList<PackageItem> packageList = new ArrayList<PackageItem>();

		// Initialize Appetizers
		Appetizer appetizer1 = new Appetizer("Mushroom Soup", 5, "Homemade cream of mushroom soup", "A1");
		Appetizer appetizer2 = new Appetizer("Zuppa Soup", 6, "Creamy soup topped with flaky puff pastry", "A2");
		Appetizer appetizer3 = new Appetizer("Goulash Soup", 6, "Hearty beef and vegetable soup with bread on the side",
				"A3");

		// add appetizer to appetizer menu
		appeList.add(appetizer1);
		appeList.add(appetizer2);
		appeList.add(appetizer3);

		// Initialize Main Course
		MainCourse mainCourse1 = new MainCourse("Chicken Cordon Bleu", 15,
				"Breaded fried chicken filled with creamy mozarella", "M1");
		MainCourse mainCourse2 = new MainCourse("Ribeye Steak", 20,
				"Grilled Beef Steak with Hollandaise Sauce and Sautéed Vegetables", "M2");
		MainCourse mainCourse3 = new MainCourse("Grilled Porterhouse steak", 20,
				"Bone in king of steak with Red Wine Sauce", "M3");

		// add maincourse to maincourse menu
		mainCourseList.add(mainCourse1);
		mainCourseList.add(mainCourse2);
		mainCourseList.add(mainCourse3);

		// initialize dessert
		Dessert dessert1 = new Dessert("Tiramisu Cake", 7,
				"Coffee flavoured Italian dessert topped with brazillian espresso powder", "D1");
		Dessert dessert2 = new Dessert("Strawberry Shortcake", 6, "Sweetsour strawberry to freshen you from the grease",
				"D2");
		Dessert dessert3 = new Dessert("Blackforest Gâteau ", 7, "chocolate sponge cake with a rich cherry filling",
				"D3");

		// add dessert to dessert menu
		dessertList.add(dessert1);
		dessertList.add(dessert2);
		dessertList.add(dessert3);

		// initialize drinks
		Drinks drink1 = new Drinks("The Red Hood", 4, "Mixed of fresh pomegranate and cranberry juices", "B1");
		Drinks drink2 = new Drinks("Bloddy Marry", 5,
				"Want to spice things up? Bloody Mary with extra smoked Tabasco thrown into the mix", "B2");
		Drinks drink3 = new Drinks("Ginger and Pear Punch", 4,
				"Suprise yourself with the punch of our house specialty ", "B3");

		// add drinks to drinks menu
		drinkList.add(drink1);
		drinkList.add(drink2);
		drinkList.add(drink3);

		// initialize packages
		ArrayList<MenuItem> packageList1 = new ArrayList<MenuItem>();
		packageList1.add(appetizer1);
		packageList1.add(mainCourse1);
		packageList1.add(drink1);
		PackageItem package1 = new PackageItem("Mushroom Chicken in the Hood", 22,
				"Start the night with mushroom soup, fill up with Chicken Cordon Bleu and fresh up wiht The Red Hood ",
				packageList1, "P1");

		ArrayList<MenuItem> packageList2 = new ArrayList<MenuItem>();
		packageList1.add(appetizer3);
		packageList1.add(mainCourse2);
		packageList1.add(drink2);
		PackageItem package2 = new PackageItem("Spicy Heavy Meal", 22,
				"Hearty meal of Goulash Soup and Grilled Porterhouse Steak coupled wiht Bloody Marry to spice up the night",
				packageList2, "P2");

		// add packages to packageList
		packageList.add(package1);
		packageList.add(package2);

		// initialize menu
		Restaurant.restaurantMenu = new Menu(appeList, mainCourseList, dessertList, drinkList, packageList);

	}

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

		Table newTable = new Table(17, 8);
		tableList.add(newTable);

		Restaurant.tableList = tableList;

	}

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

	public static void createReservationList() {
		Restaurant.reservationList = new ArrayList<Reservation>();

	}

	public static void createInvoiceList() {
		Restaurant.invoiceList = new ArrayList<Invoice>();
	}

	public static void createOrderList() {
		Restaurant.orderList = new ArrayList<Order>();
	}

	public static void createMemberList() {
		ArrayList<Customer> memberList = new ArrayList<Customer>();

		// initialize member
		Customer member1 = new Customer("Sherwin", "Male", "12345678", true);
		Customer member2 = new Customer("Larry", "Male", "23456789", true);
		Customer member3 = new Customer("Junhui", "Male", "34567891", true);
		Customer member4 = new Customer("Pheng Kai", "Male", "45678912", true);

		// add member to memberList
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
	}

	public static void saveRestaurant() {

		ArrayList<Object> data = new ArrayList<Object>();
		data.add(Restaurant.restaurantMenu);
		data.add(Restaurant.tableList);
		data.add(Restaurant.reservationList);
		data.add(Restaurant.staffList);
		data.add(Restaurant.invoiceList);
		data.add(Restaurant.orderList);

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
	}

	public static void testing() {
		System.out.println("testing");
	}
}
