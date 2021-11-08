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
    private static ArrayList<Table> tableList = Restaurant.tableList;
    private static ArrayList<Customer> memberList = Restaurant.memberList;

    public static ArrayList<Table> getAvailableTables(int noOfPax, Calendar time) {

        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for (Table table : tableList) {
            if (table.getTableSize() >= noOfPax && table.getTableStatus() == TableStatus.EMPTY) {
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

    public static void registerCustomerToTable(String waiter, int noOfPax, int tableNumber, boolean isMember) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableStatus() == TableStatus.OCCUPIED) {
                    System.out.println("Please choose another table");
                } else {
                    table.registerCustomerToTable(waiter, noOfPax, isMember);
                    ;
                }
            }
        }
    }

    public static boolean checkTableOccupied(int tableNumber) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                return (table.getTableStatus() == TableStatus.OCCUPIED);
            }
        }
        return false;
    }

    public static void settleTable(int tableNumber) {

        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                table.getOrder().generateInvoice();
                table.setToEmpty();
                table.setOrder(null);
            }
        }
    }

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
