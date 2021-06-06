/*
 *  UCF COP3330 Summer 2021 Exercise 13 Solution
 *  Copyright 2021 Christopher Gray
 */
package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    static App myApp = new App();

    @Test
    void output_generated_is_properly_formatted_WI() {
        double orderAmount = 10;
        String state = "WI";

        String expectedOutput = String.format("The subtotal is $10.00.%n" +
                "The tax is $0.55.%nThe total is $10.55.");
        String actualOutput = myApp.generateOutputString(orderAmount, state);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void output_generated_is_properly_formatted_not_WI() {
        double orderAmount = 10;
        String state = "MN";

        String expectedOutput = "The total is $10.00.";
        String actualOutput = myApp.generateOutputString(orderAmount, state);

        assertEquals(expectedOutput, actualOutput);
    }
}