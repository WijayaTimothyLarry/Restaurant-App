package utils;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class ReservationUtils {

    // use when checking if table is available for booking by checking if there are
    // any reservations or diners 2h before timing in booking request
    // use with before(Object when) Calendar function
    /** 
    *Function to check if table is available for booking by checking if there are any reservations or diners
    * 2h before timing in booking request
    * use with before(Object when) Calendar function
    * @param bookingTime time of actual reservation
    * @return time that is 2h before timing in booking request
    */
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
    /**
     * use when checking if table is available for booking by checking if there are any reservation
     * or diners 2h after timing in booking request
     * @param bookingTime time of actual reservation
     * @return time that is 2h after timing in booking request
     */
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

        System.out.println("Time that is 2h after timing in booking request: " + t2hafter.getTime());
        return t2hafter;
    }

    // method to get difference between 2 Calendar timings
    /**
     * Function to compare if difference in two timings is less than 2 hours apart
     * @param timing1 (Date)first timing to compare
     * @param timing2 (Date)second timing to compare
     * @return (boolean)true if the two timings are less than 2 hours apart, false otherwise
     */
    public static boolean diffOfTimings(Date timing1, Date timing2) {
        long hoursBetween = ChronoUnit.HOURS.between(timing1.toInstant(), timing2.toInstant());
        if (hoursBetween < 0) {
            hoursBetween = ChronoUnit.HOURS.between(timing2.toInstant(), timing1.toInstant());
        }
        if (hoursBetween < 2)
            return false;
        else
            return true;
    }

    // method to get difference between 2 Calendar timings (check for 15mins expiry)
    /**
     * Function to check for 15 mins expirt
     * @param timing1 (Date)first timing to compare
     * @param timing2 (Date)second timing to compare
     * @return (boolean)true if difference in two timings is more than 15 minutes, false otherwise
     */
    public static boolean expiryCheck(Date timing1, Date timing2) {
        long minsBetween = ChronoUnit.MINUTES.between(timing1.toInstant(), timing2.toInstant());
        if (minsBetween < 15)
            return false;
        else
            return true;
    }
}
