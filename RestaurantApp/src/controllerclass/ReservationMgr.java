package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import database.Restaurant;
import entityclass.Reservation;
import entityclass.Table;
import utils.CustomInput;
import utils.ReservationUtils;

public class ReservationMgr {
    private static ArrayList<Reservation> reservationList = Restaurant.reservationList;
    private static ArrayList<Table> tableList = Restaurant.tableList;

    private static Scanner sc = new Scanner(System.in);

    public static void newReservation(String newCustomerContactNo) {
        System.out.println("Enter the date and time of reservation");
        Calendar reservationDate = CustomInput.dateInput();

        System.out.println("Enter the total number of people for this Reservation");
        int newNoOfPax = CustomInput.nextPositiveInt();
        ArrayList<Table> availableTable = getAvailableTables(newNoOfPax, reservationDate);
        if (availableTable.isEmpty()) {
            System.out.println("All tables are Reserved");
        }

        else {
            System.out.println("Enter Customer Name:");
            String newCustomerName = sc.next();

            Reservation newReserv = new Reservation(reservationDate, newCustomerName, newCustomerContactNo, newNoOfPax,
                    availableTable.get(0).getTableNumber());

            reservationList.add(newReserv);
            System.out.println("New Reservation successfully made for Table Number: " + newReserv.getTableNumber());

        }

    }

    public static Reservation checkCustomerReservation(String phoneNumber) {
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerContactNo().equals(phoneNumber)) {
                return reservation;
            }
        }

        return null;
    }

    public static void removeReservation(String phoneNumber) {
        Iterator<Reservation> itr = reservationList.iterator();
        while (itr.hasNext()) {
            Reservation reservation = itr.next();
            if (reservation.getCustomerContactNo().equals(phoneNumber)) {
                itr.remove();
            }
        }
    }

    public static ArrayList<Table> getAvailableTables(int noOfPax, Calendar time) {

        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for (Table table : tableList) {
            if (table.getTableSize() >= noOfPax) {
                availableTableList.add(table);
            }
        }
        if (availableTableList.isEmpty()) {
            System.out.println("There are no empty tables for " + noOfPax);
            return availableTableList;
        }
        Iterator<Table> itr = availableTableList.iterator();
        while (itr.hasNext()) {
            Table table = itr.next();
            ArrayList<Reservation> reservationList = table.getReservationList();
            for (Reservation reservation : reservationList) {
                Calendar reservationTime = reservation.getReservationDateTime();
                if (!ReservationUtils.diffOfTimings(reservationTime, time)) {
                    itr.remove();
                    break;
                }
            }
        }
        if (availableTableList.isEmpty()) {
            System.out.println("There are no empty tables for " + noOfPax);
        }
        return availableTableList;
    }

}
