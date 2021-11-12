package boundaryclass;

import java.util.Calendar;

import controllerclass.SaleRevenueMgr;
import utils.CustomInput;

public class SaleRevenueInterface {
    static int choice;

    /**
     * Function to show options for user to display sales revenue
     * (1)- Display Daily Sales revenue of a specific date
     * (2)- Display Monthly Sales revenue of a specific month
     * (3)- Display Yearly Sales revenue of a specific year
     * (4)-Exit
     * @see SaleRevenueMgr
     */
    public static void showOption() {

        boolean on = true;
        Calendar date;

        while (on) {
            System.out.println("(1) Daily sales revenue");
            System.out.println("(2) Monthly sales revenue");
            System.out.println("(3) Yerly sales revenue");
            System.out.println("(0) Go back");
            choice = CustomInput.choice(0, 3);
            switch (choice) {
            case 1:
                System.out.println("Enter date to check daily revenue");
                date = CustomInput.dailyRevenueDateInput();
                double daySaleRevenue = SaleRevenueMgr.getDailyRevenue(date);
                System.out.print("Daily Revenue for above date:");
                System.out.printf(" = $%.2f\n\n", daySaleRevenue);
                break;
            case 2:
                System.out.println("Enter date to check daily revenue");
                date = CustomInput.mothlyRevenueDateInput();
                double monthSaleRevenue = SaleRevenueMgr.getMonthlyRevenue(date);
                System.out.print("Daily Revenue for above date:");
                System.out.printf(" = $%.2f\n\n", monthSaleRevenue);
                break;
            case 3:
                System.out.println("Enter date to check daily revenue");
                date = CustomInput.yearlyRevenueDateInput();
                double yearSaleRevenue = SaleRevenueMgr.getYearlyRevenue(date);
                System.out.print("Daily Revenue for above date:");
                System.out.printf(" = $%.2f\n\n", yearSaleRevenue);
                break;
            case 0:
                on = false;
            }

        }
        System.out.println("");

    }

}
