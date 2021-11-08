package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import database.Restaurant;
import entityclass.Reservation;
import entityclass.Table;
import utils.ReservationUtils;

public class ReservationMgr {
    private static ArrayList<Reservation> reservationList = Restaurant.reservationList;
    private static ArrayList<Table> tableList = Restaurant.tableList;

    public static void newReservation(String customerPhoneNumber, Calendar reservationDate, String customerName,
            int noOfPax, int tableNumber) {

        Reservation newReserv = new Reservation(reservationDate, customerName, customerPhoneNumber, noOfPax,
                tableNumber);

        reservationList.add(newReserv);
        System.out.println("New Reservation successfully made for Table Number: " + newReserv.getTableNumber());
        System.out.println(reservationList.size());

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
