package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class CustomInput {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Function to ensure that inputted choice if valid Prompt user to reenter input
     * if choice is not valid
     * 
     * @param lower (int)Lower bound of valid input(inclusive)
     * @param upper (int)Upper bound of valid input(inclusive)
     * @return (int)valid input
     */
    public static int choice(int lower, int upper) {
        int input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your choice:");
                input = scanner.nextInt();
                if (input < lower || input > upper) {
                    throw new Exception("Please input valid input");
                }
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input an integer");
                scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * Function to scan in next positive integer as input Prompt user to reenter
     * input if input is not an integer or input is negative
     * 
     * @return (int)Valid Postive Integer input
     */

    public static int nextPositiveInt() {
        int input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                input = scanner.nextInt();
                if (input <= 0) {
                    throw new Exception("Please input value above 0");
                }
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input an integer");
                scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * Function to scan in next integer as input Prompt user to reenter input if
     * input is not an integer
     * 
     * @return (int)Valid Integer input
     */
    public static int nextInt() {
        int input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                input = scanner.nextInt();
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input an integer");
                scanner.next();
            }
        }
        return input;
    }

    /**
     * Function to scan in next Double as input Prompt user to reenter input if
     * input is not a double
     * 
     * @return (double)Valid Double Input
     */
    public static double nextDouble() {
        double input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                input = scanner.nextDouble();
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input a number\n");
                scanner.next();
            }
        }
        return input;
    }

    /**
     * Function to scan in next positive double as input Prompt user to reenter
     * input if input is not a positive double
     * 
     * @return (double)Valid Positive Double Input
     */
    public static double nextPositiveDouble() {
        double input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your value:");
                input = scanner.nextDouble();
                if (input <= 0) {
                    throw new Exception("Please input value above 0");
                }
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                scanner.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * Function to scan in next valid phone number as input Prompt user to reenter
     * input if input is not a valid phone number
     * 
     * @return (String) Valid Phone Number input
     */
    public static String phoneNumberInput() {
        System.out.println("Enter phone number:");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        while (!(phoneNumber.length() == 8 && (phoneNumber.charAt(0) == '9' || phoneNumber.charAt(0) == '8'))) {
            System.out.println("Enter a valid phone number:");
            phoneNumber = scanner.nextLine();
        }
        return phoneNumber;
    }

    /**
     * Function to scan in next valid date as input Prompt user to reenter input if
     * input is not a valid date
     * 
     * @return (Calendar) Valid formatted Date input
     */
    public static Calendar dateInput() {

        Calendar currentDateTime = (Calendar) Calendar.getInstance();
        Calendar futureDateTime = (Calendar) Calendar.getInstance();

        System.out.println("Current Date and Time:\n" + currentDateTime.getTime());

        int lowYear = currentDateTime.get(Calendar.YEAR);
        currentDateTime.add(Calendar.YEAR, 1);
        int uppYear = currentDateTime.get(Calendar.YEAR);

        System.out.printf("\nEnter year %d to %d\n", lowYear, uppYear);
        int year = choice(lowYear, uppYear);
        futureDateTime.set(Calendar.YEAR, year);

        System.out.println("Enter month(1-12): ");
        int month = choice(1, 12);
        futureDateTime.set(Calendar.MONTH, month - 1);

        System.out.println("Enter day: ");
        int numDays = 0;
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            numDays = 31;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            numDays = 30;
            break;
        case 2:
            if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
                numDays = 29;
            else
                numDays = 28;
            break;
        }
        int day = choice(1, numDays);
        futureDateTime.set(Calendar.DAY_OF_MONTH, day);

        System.out.println("Enter hour(16-23): ");
        int hour = choice(16, 23);
        futureDateTime.set(Calendar.HOUR_OF_DAY, hour);

        System.out.println("Enter minutes(0-59): ");
        int min = choice(0, 59);
        futureDateTime.set(Calendar.MINUTE, min);

        futureDateTime.set(Calendar.SECOND, 0);

        System.out.println("Date (future) :" + futureDateTime.getTime());
        return futureDateTime;
    }

    // method to compare date, month and year
    /**
     * Function to compare if two dates are the same
     * 
     * @param timing1 (Date)first timing to compare
     * @param timing2 (Date)second timing to compare
     * @return (boolean)true if the two timings are the same, false otherwise
     */
    public static boolean compareDMY(Date timing1, Date timing2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(timing1);
        cal2.setTime(timing2);
        boolean comparison = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
        return comparison;
    }

    // method to compare month and year
    /**
     * Function to compare if the month and year of two timings are the same
     * 
     * @param timing1 (Date)first timing to compare
     * @param timing2 (Date)second timing to compare
     * @return (boolean)True if the month and year of the two timings are the same,
     *         false otherwise
     */
    public static boolean compareMY(Date timing1, Date timing2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(timing1);
        cal2.setTime(timing2);
        boolean comparison = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return comparison;
    }

    // method to compare year
    /**
     * Function to compare if the year of two timings are the same
     * 
     * @param timing1 (Date)First timing to compare
     * @param timing2 (Date)Second timing to compare
     * @return (boolean)True if the year of the two timings are the same,false
     *         otherwise
     */
    public static boolean compareY(Date timing1, Date timing2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(timing1);
        cal2.setTime(timing2);
        boolean comparison = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return comparison;
    }

    /**
     * Function for user to input a day's date to record daily revenue
     * 
     * @return (Calendar)Today's date
     */
    public static Calendar dailyRevenueDateInput() {

        Calendar currentDateTime = (Calendar) Calendar.getInstance();
        Calendar futureDateTime = (Calendar) Calendar.getInstance();

        System.out.println("Current Date and Time:\n" + currentDateTime.getTime());

        System.out.println("\nEnter year:");
        int year = nextPositiveInt();
        futureDateTime.set(Calendar.YEAR, year);

        System.out.println("Enter month(1-12): ");
        int month = choice(1, 12);
        futureDateTime.set(Calendar.MONTH, month - 1);

        System.out.println("Enter day: ");
        int numDays = 0;
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            numDays = 31;
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            numDays = 30;
            break;
        case 2:
            if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
                numDays = 29;
            else
                numDays = 28;
            break;
        }
        int day = choice(1, numDays);
        futureDateTime.set(Calendar.DAY_OF_MONTH, day);

        System.out.printf("Inputted Date: %d/%d/%d\n", day, month, year);
        return futureDateTime;
    }

    /**
     * Function for user to input a month for revenue recording purposes
     * 
     * @return (Calendar)Month inputted by user
     */

    public static Calendar mothlyRevenueDateInput() {

        Calendar currentDateTime = (Calendar) Calendar.getInstance();
        Calendar futureDateTime = (Calendar) Calendar.getInstance();

        System.out.println("Current Date and Time:\n" + currentDateTime.getTime());

        System.out.println("\nEnter year:");
        int year = nextPositiveInt();
        futureDateTime.set(Calendar.YEAR, year);

        System.out.println("Enter month(1-12): ");
        int month = choice(1, 12);
        futureDateTime.set(Calendar.MONTH, month - 1);

        System.out.printf("Inputted month / year: %d/%d\n", month, year);
        return futureDateTime;
    }

    /**
     * Function for user to input a year for revenune recording purposes
     * 
     * @return (Calendar)Year inputted by user
     */

    public static Calendar yearlyRevenueDateInput() {

        Calendar currentDateTime = (Calendar) Calendar.getInstance();
        Calendar futureDateTime = (Calendar) Calendar.getInstance();

        System.out.println("Current Date and Time:\n" + currentDateTime.getTime());

        System.out.println("\nEnter year:");
        int year = nextPositiveInt();
        futureDateTime.set(Calendar.YEAR, year);

        System.out.printf("Inputted year: %d\n", year);
        return futureDateTime;
    }
}
