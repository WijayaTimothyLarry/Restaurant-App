package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class CustomInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int choice(int lower, int upper) {
        int input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your choice:");
                input = scanner.nextInt();
                if (input < lower || input > upper) {
                    throw new Exception("Please input value from above choice");
                }
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input an integer");
                scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static int nextPositiveInt() {
        int input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your choice:");
                input = scanner.nextInt();
                if (input <= 0) {
                    throw new Exception("Please input value above 0");
                }
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input an integer");
                scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static int nextInt() {
        int input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your choice:");
                input = scanner.nextInt();
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input an integer");
                scanner.nextInt();
            }
        }
        return input;
    }

    public static double nextDouble() {
        double input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your choice:");
                input = scanner.nextDouble();
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                scanner.nextInt();
            }
        }
        return input;
    }

    public static double nextPositiveDouble() {
        double input = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            try {
                System.out.println("Enter your choice:");
                input = scanner.nextDouble();
                if (input <= 0) {
                    throw new Exception("Please input value above 0");
                }
                invalidInput = false;
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please input a number");
                scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public static Calendar dateInput() {

        Calendar currentDateTime = (Calendar) Calendar.getInstance();
        Calendar futureDateTime = (Calendar) Calendar.getInstance();

        System.out.println(" Date  (now):" + currentDateTime.getTime());

        System.out.println("Enter year(up to next year): ");
        int lowYear = currentDateTime.get(Calendar.YEAR);
        currentDateTime.add(Calendar.YEAR, 1);
        int uppYear = currentDateTime.get(Calendar.YEAR);

        int year = choice(lowYear, uppYear);
        futureDateTime.set(Calendar.YEAR, year);

        System.out.println("Enter month(1-12): ");
        int month = choice(1, 12);
        futureDateTime.set(Calendar.MONTH, month);

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

    // use when checking if table is available for booking by checking if there are
    // any reservations or diners 2h before timing in booking request
    // use with before(Object when) Calendar function
    public static Calendar reservationWindowBEF(Calendar bookingTime) {

        Calendar t2hbefore = (Calendar) Calendar.getInstance();
        t2hbefore.set(Calendar.YEAR, bookingTime.get(Calendar.YEAR));
        t2hbefore.set(Calendar.MONTH, bookingTime.get(Calendar.MONTH));
        t2hbefore.set(Calendar.DAY_OF_MONTH, bookingTime.get(Calendar.DAY_OF_MONTH));

        t2hbefore.set(Calendar.HOUR_OF_DAY, bookingTime.get(Calendar.HOUR_OF_DAY)); // set 2h before time to 2h before
                                                                                    // booking time
        t2hbefore.add(Calendar.HOUR_OF_DAY, -2);
        t2hbefore.set(Calendar.MINUTE, bookingTime.get(Calendar.MINUTE));
        t2hbefore.set(Calendar.SECOND, 0);

        System.out.println("Time that is 2h before timing in booking request: " + t2hbefore.getTime());
        return t2hbefore;
    }

    // use when checking if table is available for booking by checking if there are
    // any reservations or diners 2h after timing in booking request
    // use with after(Object when) Calendar function
    public static Calendar reservationWindowAFT(Calendar bookingTime) {

        Calendar t2hafter = (Calendar) Calendar.getInstance();
        t2hafter.set(Calendar.YEAR, bookingTime.get(Calendar.YEAR));
        t2hafter.set(Calendar.MONTH, bookingTime.get(Calendar.MONTH));
        t2hafter.set(Calendar.DAY_OF_MONTH, bookingTime.get(Calendar.DAY_OF_MONTH));

        t2hafter.set(Calendar.HOUR_OF_DAY, bookingTime.get(Calendar.HOUR_OF_DAY)); // set 2h before time to 2h before
                                                                                   // booking time
        t2hafter.add(Calendar.HOUR_OF_DAY, 2);

        t2hafter.set(Calendar.MINUTE, bookingTime.get(Calendar.MINUTE));
        t2hafter.set(Calendar.SECOND, 0);

        System.out.println("Time that is 2h before timing in booking request: " + t2hafter.getTime());
        return t2hafter;
    }

    // method to get difference between 2 Calendar timings
    public static boolean diffOfTimings(Calendar booking1, Calendar booking2) {
        long hoursBetween = ChronoUnit.HOURS.between(booking1.toInstant(), booking2.toInstant());
        if (hoursBetween < 2)
            return false;
        else
            return true;
    }
}
