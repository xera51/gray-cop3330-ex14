/*
 *  UCF COP3330 Summer 2021 Exercise 14 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);
    static final double TAX_RATE = 0.055;

    public static void main(String[] args) {
        App myApp = new App();
        double orderAmount = myApp.readOrderAmount();
        String state = myApp.readState();

        String output = myApp.generateOutputString(orderAmount, state);
        myApp.displayOutput(output);
    }

    private double readOrderAmount() {
        System.out.print("What is the order amount? ");
        return Double.parseDouble(in.nextLine());
    }

    private String readState() {
        System.out.print("What is the state? ");
        return in.nextLine();
    }

    public String generateOutputString(double orderAmount, String state) {
        String output = "";

        if(state.equals("WI")) {
            double tax = roundToNearestCent(calculateTax(orderAmount));
            output = String.format("The subtotal is $%.2f.%nThe tax is $%.2f.%n",
                    roundToNearestCent(orderAmount), tax);
            orderAmount += tax;
        }
        output += generateTotalString(orderAmount);
        return output;
    }

    private static double calculateTax(double orderAmount) { return orderAmount * TAX_RATE; }

    public String generateTotalString(double orderAmount) {
        return String.format("The total is $%.2f.", roundToNearestCent(orderAmount));
    }

    private void displayOutput(String output) { System.out.println(output); }

    public static double roundToNearestCent(double in) { return Math.ceil(in * 100.0 - 0.00000001) / 100.0; }
}
