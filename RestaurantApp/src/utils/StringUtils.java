package utils;

public class StringUtils {
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
