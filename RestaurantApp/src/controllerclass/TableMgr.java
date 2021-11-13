package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import database.Restaurant;
import entityclass.Customer;
import entityclass.Reservation;
import entityclass.Table;
import entityclass.Table.TableStatus;
import utils.ReservationUtils;

public class TableMgr {
    /**
     * tableList of all Tables in the Restaurant
     */
    private static ArrayList<Table> tableList = Restaurant.tableList;

    /**
     * member list of all the members under the Restaurant
     */
    private static ArrayList<Customer> memberList = Restaurant.memberList;

    /**
     * publiv static ArrayList
     * <Table>
     * : getAvailableTables Function to return the List of all available Tables for
     * a given number of Pax and given time
     * 
     * @param noOfPax (int) Number of pax to find table availability by
     * @param time    (Calendar) Time to find table availability for
     * @return ArrayList
     *         <Table>
     *         List of all tables available with given noOfPax and time
     */
    public static ArrayList<Table> getAvailableTables(int noOfPax, Calendar time) {

        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for (Table table : tableList) {
            if (table.getTableSize() >= noOfPax && table.getTableStatus() == TableStatus.EMPTY) {
                availableTableList.add(table);
            }
        }
        if (availableTableList.isEmpty()) {
            System.out.printf("There are no empty tables for %d\n\n", noOfPax);
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
            System.out.printf("There are no empty tables for %d\n\n", noOfPax);
        }
        return availableTableList;
    }

    /**
     * public static void : registerCustomerToTable Function to register a given
     * customer to a Table
     * 
     * @param waiter      (String) Name of waiter to be assigned with a customer for
     *                    a given Table
     * @param noOfPax     (int) Number of pax to be registered for a given Table
     * @param tableNumber (int) Table's Number to be registered to the customer
     * @param isMember    (boolean) boolean value to desribe a customer's membership
     */
    public static void registerCustomerToTable(String waiter, int noOfPax, int tableNumber, boolean isMember) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableStatus() == TableStatus.OCCUPIED) {
                    System.out.println("Please choose another table\n");
                } else {
                    if (table.getTableSize() < noOfPax) {
                        System.out.println("Please choose a bigger table\n");
                    }
                    table.registerCustomerToTable(waiter, noOfPax, isMember);
                    ;
                }
            }
        }
    }

    /**
     * public static boolean : checkTableOccupied Function to return a boolean value
     * descibing if a Table is occupied
     * 
     * @param tableNumber (int) The number of a given Table
     * @return boolean value based on Table's Occupancy
     */
    public static boolean checkTableOccupied(int tableNumber) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                return (table.getTableStatus() == TableStatus.OCCUPIED);
            }
        }
        return false;
    }

    /**
     * public static boolean : checkTableSize Function to return the boolean value
     * describing if the given table can accomodate the given number of pax
     * 
     * @param tableNumber (int) Number of the given Table
     * @param noOfPax     (int) Number of pax
     * @return boolean value true if the table size is more than or equal to the
     *         given number of pax and return false if the table size is less than
     *         the given number of pax
     */
    public static boolean checkTableSize(int tableNumber, int noOfPax) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableSize() < noOfPax)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }

    /**
     * public static void : settleTable Function to settle and unassign a table.
     * 
     * @param tableNumber (int) The number of a given Table
     */
    public static void settleTable(int tableNumber) {

        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableStatus() != TableStatus.OCCUPIED) {
                    System.out.println("There is no customer in this table");
                    return;
                }
                table.getOrder().generateInvoice();
                table.setToEmpty();
                table.setOrder(null);
            }
        }
    }

    /**
     * public static boolean : checkMembership Function to return a boolean value
     * describing if membership exists for a given phone number of a customer
     * 
     * @param phoneNumber
     * @return boolean
     */
    public static boolean checkMembership(String phoneNumber) {
        for (Customer member : memberList) {
            if (member.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("\nThis customer is a member 10% discount will be applied on the bill\n");
                return true;
            }
        }
        System.err.println("\nThis customer is not a member\n");
        return false;
    }

}
