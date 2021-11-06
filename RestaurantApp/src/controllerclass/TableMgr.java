package controllerclass;

import java.util.ArrayList;
import entityclass.Table;
import entityclass.Table.TableStatus;

public class TableMgr 
{
    private ArrayList<Table> tables = new ArrayList<Table>();

    public ArrayList<Integer> getAvailTableNoByPax(int newNoOfPax) 
    {
        return null;
    }
    

    public void getAvailableTables()
    {
        int newTableSize = checkSizeofTable();
        ArrayList<Table> availableTableList = new ArrayList<Table>();
        for(int i=0; i< tables.size(); i++)
        {
            Table test = tables.get(i);
            if(test.getTableStatus() == Table.TableStatus.EMPTY && test.getTableSize() == newTableSize)
            {
                availableTableList.add(test);
            }
        }
        if(availableTableList.isEmpty())
        {
            System.out.println("There are no empty tables of this size "+ newTableSize  );
        }
        else
        {
            System.out.printf("\n Size: %d, Status: %s", newTableSize, TableStatus.EMPTY.name());
            printTablesFormatted(availableTableList);

        }
    }


    private void printTablesFormatted(ArrayList<Table> availableTableList) {
    }


    private int checkSizeofTable() 
    {
        return 0;
    }

    public void printAllTables()
    {
        if(tables.size() == 0)
        {
            System.out.println("There are no Tables");
            return;
        }
        printTablesFormatted(tables);
    }

}
