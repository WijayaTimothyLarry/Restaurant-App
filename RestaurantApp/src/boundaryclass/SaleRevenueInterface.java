package boundaryclass;

import java.util.Calendar;

import controllerclass.SaleRevenueMgr;
import utils.CustomInput;

public class SaleRevenueInterface {
    static int choice;

    public static void showOption() {

        boolean on = true;
        Calendar date;

        while (on) {
            System.out.println("(1) Daily sales revenue");
            System.out.println("(2) Monthly sales revenue");
            System.out.println("(3) Yerly sales revenue");
            System.out.println("(0) Go back");
            choice = CustomInput.choice(0, 4);
            switch (choice) {
            case 1:
                System.out.println("Enter date to check daily revenue");
                date = CustomInput.dailyRevenueDateInput();
                double daySaleRevenue = SaleRevenueMgr.getDailyRevenue(date);
                System.out.println("Daily Revenue for above date:");
                System.out.printf(" = %.2f", daySaleRevenue);
                break;
            case 2:
                System.out.println("Enter date to check daily revenue");
                date = CustomInput.mothlyRevenueDateInput();
                double monthSaleRevenue = SaleRevenueMgr.getMonthlyRevenue(date);
                System.out.println("Daily Revenue for above date:");
                System.out.printf(" = %.2f", monthSaleRevenue);
                break;
            case 3:
                System.out.println("Enter date to check daily revenue");
                date = CustomInput.yearlyRevenueDateInput();
                double yearSaleRevenue = SaleRevenueMgr.getYearlyRevenue(date);
                System.out.println("Daily Revenue for above date:");
                System.out.printf(" = %.2f", yearSaleRevenue);
                break;
            }

        }
        System.err.println("");

    }

}
