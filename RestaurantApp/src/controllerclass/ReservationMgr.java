package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import database.Restaurant;
import entityclass.Reservation;
import entityclass.Table;
import utils.ReservationUtils;

public class ReservationMgr {
    /**
     * Array List of reservations under the restaurant
     */
    private static ArrayList<Reservation> reservationList = Restaurant.reservationList;

    /**
     * Array list of all the table lists under the Restaurant
     */
    private static ArrayList<Table> tableList = Restaurant.tableList;

    /**
     * public static void : newReservation Function to make a new Reservation with
     * the given Customer's Phone number, the Reservation's date, customer's name,
     * number of pax and the table's number
     * 
     * @param customerPhoneNumber (String) Customer's phone number to make
     *                            reservation under
     * @param reservationDate     (Calendar) Date to make the new reservation for
     * @param customerName        (String) Customer's name to make reservation under
     * @param noOfPax             (int) number of pax under the reservation
     * @param tableNumber         (int) Number of the table being used to make
     *                            reservation for
     */
    public static void newReservation(String customerPhoneNumber, Calendar reservationDate, String customerName,
            int noOfPax, int tableNumber) {

        Reservation newReserv = new Reservation(reservationDate, customerName, customerPhoneNumber, noOfPax,
                tableNumber);

        reservationList.add(newReserv);
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber)
                table.addReservation(newReserv);
        }
        System.out.println("New Reservation successfully made for Table Number: " + newReserv.getTableNumber());
        System.out.println(reservationList.size());

    }

    /**
     * public static Reservation : checkCustomerReservation Function to return
     * Reservation if a reservation for the given phone number exists
     * 
     * @param phoneNumber (String) phoneNumber of the Customer to check reservation
     *                    under
     * @return Reservation if reservation exists for the given customer's phone
     *         number else return null.
     */
    public static Reservation checkCustomerReservation(String phoneNumber) {
        for (Reservation reservation : reservationList) {
            if (reservation.getCustomerContactNo().equals(phoneNumber)) {
                return reservation;
            }
        }

        return null;
    }

    /**
     * public static ArrayList<Reservation> : checkTableReservation Function to
     * return the reservation list for a given table number
     * 
     * @param tableNumber (int) Number of the table to return reservation list for
     * @return ArrayList<Reservation> list of reservations for the given tableNumber
     *         or return null if an invalid table number is passed
     */
    public static ArrayList<Reservation> checkTableReservation(int tableNumber) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber)
                return table.getReservationList();
        }
        return null;
    }

    /**
     * public static void : removeReservation Function to remove a reservation for
     * the given Customer's phone number
     * 
     * @param phoneNumber (String) Customer's phone number
     */
    public static void removeReservation(String phoneNumber) {
        Iterator<Reservation> itr = reservationList.iterator();
        int reservationID;
        int tableNumber;
        while (itr.hasNext()) {
            Reservation reservation = itr.next();
            if (reservation.getCustomerContactNo().equals(phoneNumber)) {
                reservationID = reservation.getReservationID();
                tableNumber = reservation.getTableNumber();
                for (Table table : tableList) {
                    if (table.getTableNumber() == tableNumber) {
                        table.removeReservation(reservationID);
                    }
                }
                itr.remove();
                break;
            }
        }
    }

    /**
     * public static ArrayList<Reservation> : getAvailableTables Function to return
     * the list of available tables for a given number of pax and time
     * 
     * @param noOfPax (int) number of pax required to check for in a table
     * @param time    (Calendar) Time to check for table availability
     * @return ArrayList
     *         <Table>
     *         list of available tables according to the given number of pax and
     *         time
     */
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
                if (!ReservationUtils.diffOfTimings(reservationTime.getTime(), time.getTime())) {
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

    /**
     * public static void : removeExpiredReservation Function to remove an expired
     * reservation if there is a reservation made and the Table is not occcupied
     * after 15 minutes of the booking time
     */
    public static void removeExpiredReservation() {
        Calendar currentTime = Calendar.getInstance();
        Iterator<Reservation> itr = reservationList.iterator();
        while (itr.hasNext()) {
            Reservation reservation = itr.next();
            Calendar reservationTime = reservation.getReservationDateTime();
            if (ReservationUtils.expiryCheck(reservationTime.getTime(), currentTime.getTime())) {
                String phoneNumber = reservation.getCustomerContactNo();
                removeReservation(phoneNumber);
            }
        }

    }

}
