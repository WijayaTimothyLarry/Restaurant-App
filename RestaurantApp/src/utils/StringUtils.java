package utils;

public class StringUtils {
    /**
     * Function to perform left padding
     * @param input input string to be padded
     * @param ch filling characters on the right
     * @param L Number of spaces to left pad
     * @return (String)New formatted string
     */
    public static String
    leftPadding(String input, char ch, int L) //put ch as whitespaces
    {
  
        String result
            = String
  
                  // First left pad the string with space up to length L
                  .format("%" + L + "s", input)
  
                  // Then replace all the spaces with the given character ch
                  .replace(' ', ch);
  
        // Return the resultant string
        return result;
    }
  
    // Function to perform right padding
    /**
     * Function to perform right padding
     * @param input input string to be padded
     * @param ch filling characters on the left
     * @param L Number of spaces to right pad
     * @return (String)New formmated string
     */
    public static String
    rightPadding(String input, char ch, int L) // put ch as whitespaces
    {
  
        String result
            = String
  
                  // First right pad the string with space up to length L
                  .format("%" + (-L) + "s", input)
  
                  // Then replace all the spaces with the given character ch
                  .replace(' ', ch); 
  
        // Return the resultant string
        return result;
    }
}
