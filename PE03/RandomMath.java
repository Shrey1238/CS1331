import java.util.Random;
import java.util.Scanner;

/**
 * PE03 - For Random's Sake.
 *
 * Asks the user which calculation to perform, then runs it using Math,
 * Scanner, and Random.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class RandomMath {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1, Powers of a Number");
        System.out.println("2, Random Positive Integer with Maximum");
        System.out.println("3, Area of Random Circle");
        System.out.println("4, Area of Random Square");
        System.out.println("What would you like to do?");

        int userInput = scanner.nextInt();
        while (userInput < 1 || userInput > 4) {
            System.out.println("Invalid user input, type a number 1-4.");
            userInput = scanner.nextInt();
        }

        if (userInput == 1) {
            System.out.print("What number would you like to calculate the powers of? ");
            userInput = scanner.nextInt();

            if (userInput == -1) {
                System.out.println("-1 raised to 0 is 1");
                System.out.println("-1 raised to odd powers greater than 0 is -1");
                System.out.println("-1 raised to even powers greater than 0 is 1");
            } else if (userInput == 0) {
                System.out.println("0 raised to the 0 is 1");
                System.out.println("0 raised to powers greater than 0 is 0");
            } else if (userInput == 1) {
                System.out.println("1 raised to ANY power is still 1");
            } else {
                int exponent = 0;
                int power = (int) Math.pow(userInput, exponent);
                do {
                    System.out.println(userInput + " raised to the " + exponent + " is " + power + ".");
                    exponent++;
                    power = (int) Math.pow(userInput, exponent);
                } while (Math.abs(power) < 100);
            }
        } else if (userInput == 2) {
            System.out.print("What is the max value you want your random number to be? ");
            userInput = scanner.nextInt();

            if (userInput <= 0) {
                System.out.println("User input must be positive and non-zero.");
            } else {
                int randomNumber = (int) (Math.random() * userInput) + 1;
                System.out.println("Your random number is " + randomNumber + ".");
            }
        } else if (userInput == 3) {
            Random rand = new Random(1331);
            int circleRadius = rand.nextInt(101);
            double circleArea = Math.PI * circleRadius * circleRadius;
            System.out.printf("A circle of radius %d has an area of %.2f.%n", circleRadius, circleArea);
        } else {
            int sideLength = (int) (Math.random() * 101);
            int squareArea = sideLength * sideLength;
            System.out.println("A square of side length " + sideLength + " has an area of " + squareArea + ".");
        }
    }
}
