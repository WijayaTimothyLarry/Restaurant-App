package controllerclass;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import entityclass.Reservation;

public class ReservationMgr 
{
    private static final File Reservation_File = new File( "data", "Reservations.txt");
    private TableMgr tableCtrl = new TableMgr();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private Scanner sc = new Scanner(System.in);


    public ReservationMgr()
    {
        readFileData(Reservation_File);
    }

    public void setTableMgr(TableMgr tableCtrl)
    {
        this.tableCtrl = tableCtrl;
    }


    public void newReservation()
    {
        int customerContactNo;
        
    }


    private void readFileData(File reservationFile) 
    {

    }


    



}
