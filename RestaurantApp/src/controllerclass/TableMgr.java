package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import database.Restaurant;
import entityclass.Reservation;
import entityclass.Table;
import entityclass.Table.TableStatus;
import utils.ReservationUtils;

public class TableMgr {
    public static ArrayList<Table> tableList = Restaurant.tableList;

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

    public static void registerCustomerToTable(String waiter, int tableNumber) {
        for (Table table : tableList){
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableStatus() == TableStatus.OCCUPIED) {
                    System.out.println("Please choose another table");
                } else {
                    table.registerCustomerToTable(waiter);
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

    public static void unassignTable(int tableNumber){
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                table.setToEmpty();
            }
    }
}

}
