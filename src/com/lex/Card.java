package com.lex;

import java.util.Scanner;

/**
 * Created by alexishennings on 3/31/17.
 */
public class Card {

        static Scanner stringScanner = new Scanner(System.in);

        public static void main(String[] args) {

            //Ask user for credit card number. store number as a String.
            System.out.println("Please enter your credit card number: ");
            String ccNumber = stringScanner.nextLine();
            boolean isValid = isVisaCreditCardNumberValid(ccNumber);

            if (isValid) {
                System.out.println("This Credit Card number is valid!");
            } else {
                System.out.println("This Credit Card number is not valid!!");
            }

            stringScanner.close();
        }

        private static boolean isVisaCreditCardNumberValid(String cc) {

            //TODO Replace with your code to process the credit card number, and determine if it is valid.
            //TODO Make sure all the tests pass!
            if (!cc.startsWith("4") || (cc.length() != 16)){
                System.out.println("Credit Card needs to start with the number 4 and be 16 digits in length. \nTry again please.");
                System.out.println();
                return false;
            }
            // create a variable for card digit total
            int total = 0;
            // create a for loop to go over every other number from right to left
            // make an if else to multiply and divide doubled and not doubled numbers
            for (int i = 0; i < 16 ; i++ ) {
                int thisDigit = Integer.parseInt((cc.substring(i, i+1)));
                if (i % 2 == 1) {
                    total = total + thisDigit;
                } else {
                    int doubled = thisDigit * 2;
                    if (doubled > 9 ) {
                        int toAdd = 1 + (doubled % 10);
                        total = total + toAdd;
                    } else {
                        total = total + (thisDigit * 2);
                    }
                }
            }
            // create another if for total = 0 and return if true
            if (total % 10 == 0) {
                return true;
            }
            // create false if total doesn't equal 0
            return false;

    }
}