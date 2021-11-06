package controllerclass;

import java.util.ArrayList;
import entityclass.Table;

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
            if(test.getTableStatus() == Table.TableStatus.EMPTY && test.getTableSize() == size)
            {
                availableTableList.add(test);
            }
        }
        if(availableTableList.isEmpty())
        {
            System.out.println("There are no empty tables of this size "+ newTableSize  );
        }
    }


    private int checkSizeofTable() {
        return 0;
    }

}
