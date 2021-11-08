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
    private static ArrayList<Table> tableList = Restaurant.tableList;

    public ArrayList<Table> getAvailableTables(int NoOfPax, Calendar time) {
        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for (Table table : tableList) {
            if (table.getTableSize() >= NoOfPax && table.getTableStatus() == TableStatus.EMPTY) {
                availableTableList.add(table);
            }
        }
        if (availableTableList.isEmpty()) {
            System.out.println("There are no empty tables for " + NoOfPax);
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
            System.out.println("There are no empty tables for " + NoOfPax);
        }
        return availableTableList;

    }

    public static void registerCustomerToTable(String waiter, int tableNumber) {
        Table customertable = null;
        for (Table table : tableList)

            if (table.getTableNumber() == tableNumber) {
                customertable = table;
            }
    }

    public static boolean checkTableOccupied(int tableNumber) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableStatus() == TableStatus.OCCUPIED)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

}
