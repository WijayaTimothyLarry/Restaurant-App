package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

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
}
