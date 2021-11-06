package controllerclass;

import java.util.ArrayList;
import java.util.Calendar;

import database.Restaurant;
import entityclass.Table;
import entityclass.Table.TableStatus;

public class TableMgr {
    private static ArrayList<Table> tableList = Restaurant.tableList;

    public ArrayList<Integer> getAvailTableNoByPax(int newNoOfPax) {
        return null;
    }

    public void getAvailableTables(int NoOfPax, Calendar time) {
        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for (Table table : tableList) {
            if (table.getTableSize() <= NoOfPax) {
            }
        }
        if (availableTableList.isEmpty()) {
            System.out.println("There are no empty tables of this size " + newTableSize);
        } else {
            System.out.printf("\n Size: %d, Status: %s", newTableSize, TableStatus.EMPTY.name());
            printTablesFormatted(availableTableList);

        }
    }

    private void printTablesFormatted(ArrayList<Table> availableTableList) {
    }

    private int checkSizeofTable() {
        return 0;
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
