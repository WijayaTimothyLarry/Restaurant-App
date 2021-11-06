package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;

import database.Restaurant;
import entityclass.Table;
import entityclass.Table.TableStatus;
import utils.ReservationUtils;

public class TableMgr {
    private static ArrayList<Table> tableList = Restaurant.tableList;

    public ArrayList<Integer> getAvailTableNoByPax(int newNoOfPax) {
        return null;
    }

    public void getAvailableTables(int NoOfPax, Calendar time) 
    {
        int newTableSize;
        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for (Table table : tableList) 
        {
            if (table.getTableSize() >= NoOfPax && (table.getTableStatus() == TableStatus.EMPTY) ) 
            {
                availableTableList.add(table);
            }
        }
        if (availableTableList.isEmpty()) {
            System.out.println("There are no empty tables of this size " + newTableSize);
            return;
        }
        else{
            Calendar timeBEF = ReservationUtils.reservationWindowBEF(time);
            Calendar timeAFT = ReservationUtils.reservationWindowAFT(time);
            if( (ReservationUtils.diffOfTimings(timeBEF, time)) && (ReservationUtils.diffOfTimings(time, timeAFT) ))
            {
                
            }
            
        }
    }

    private void printTablesFormatted(ArrayList<Table> availableTableList) {
    }

    private int checkSizeofTable() 
    {
        return tables
    }

    public void printAllTables() {
        if (tables.size() == 0) {
            System.out.println("There are no Tables");
            return;
        }
        printTablesFormatted(tables);
    }

    public static void registerCustomerToTable(String waiter, int tableNumber) {
        Table customertable = null;
        for (Table table : tableList)

            if (table.getTableNumber() == tableNumber) {
                customertable = table;
            }
    }

    }

    public static boolean checkTableOcuupied(int tableNumber) {
        for (Table table : tableList) {
            if (table.getTableNumber() == tableNumber) {
                if (table.getTableStatus() == TableStatus.OCCUPIED)
                    return true;
                else
                    return false;
            }
        }
    }

}
