package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import entityclass.*;

public class Restaurant {

	private Menu menu;
	private ArrayList<Table> tableList;
	private ArrayList<Reservation> reservationList;
	private ArrayList<Staff> staffList;
	private ArrayList<Invoice> invoiceList;

	public void createRestaurant() {
		createMenu();
		createTableList();
		createReservationList();
		createStaffList();
		createInvoiceList();
	}

	public void createMenu() {

	}

	public void createTableList() {

	}

	public void createStaffList() {
	}

	public void createReservationList() {

	}

	public void createInvoiceList() {
		invoiceList = new ArrayList<Invoice>();
	}

	public void saveRestaurant() {

		ArrayList<Object> data = new ArrayList<Object>();
		data.add(menu);
		data.add(tableList);
		data.add(reservationList);
		data.add(staffList);
		data.add(invoiceList);

		try {
			FileOutputStream fos = new FileOutputStream("restaurant.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.close();
			fos.close();
			System.out.println("Restaurant data is saved");
		} catch (IOException i) {
			i.printStackTrace();
			// TODO: handle exception
		}
	}

	public void loadRestaurant() {
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
			// TODO: handle exception
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}

		this.menu = (Menu) deserialized.get(0);
		this.tableList = (ArrayList<Table>) deserialized.get(1);
		this.reservationList = (ArrayList<Reservation>) deserialized.get(2);
		this.staffList = (ArrayList<Staff>) deserialized.get(3);
		this.invoiceList = (ArrayList<Invoice>) deserialized.get(4);
	}
}
