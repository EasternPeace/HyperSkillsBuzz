package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        Scanner scanner = new Scanner(System.in);
        int input;

        try {
            input = scanner.nextInt();
            if (input <  1) {
                System.out.println("This number is not natural!");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("This number is not natural!");
            return;
        }
        System.out.println("This number is " + calculateParity(input) + ".");

        Object[] result = calculateBuzzness(input);

        if ((boolean) result[0]) {
            System.out.println("It is a Buzz number.");
        } else {
            System.out.println("It is not a Buzz number.");
        }

        System.out.println("Explanation:");
        System.out.println(result[1]);
    }

    static String calculateParity(int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }

    static Object[] calculateBuzzness(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isBuzz = false;
        boolean isDivisibleBy7 = false;
        boolean endsWith7 = false;

        if (number % 7 == 0) {
            isBuzz = true;
            isDivisibleBy7 = true;
            stringBuilder.append(number).append(" is divisible by 7");
        }

        if (number % 10 == 7) {
            isBuzz = true;
            endsWith7 = true;
            if (isDivisibleBy7) {
                stringBuilder.append(" and ends with 7");
            } else {
                stringBuilder.append(number).append(" ends with 7");
            }
        } else if (!isDivisibleBy7) {
            stringBuilder.append(number).append(" is neither divisible by 7 nor does it end with 7");
        }

        stringBuilder.append(".");
        String explanation = stringBuilder.toString();

        return new Object[]{isBuzz, explanation};
    }
}
