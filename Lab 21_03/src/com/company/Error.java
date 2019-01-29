package com.company;

import java.util.Random;

public class Error {

	public static void main(String[] args) {

        final int MAXCHEESE = 1;

        String[] names = new String[MAXCHEESE];
        double[] prices = new double[MAXCHEESE];
        int[] amounts = new int[MAXCHEESE];


        if (MAXCHEESE >= 0 && MAXCHEESE <= 20) {
            System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");
            // Three Special Cheeses
            if (MAXCHEESE >= 1) {
                names[0] = "Dalaran Sharp";
                prices[0] = 1.25;
                System.out.println(names[0] + ": $" + prices[0] + " per pound");
            }

            if (MAXCHEESE >= 2) {
                names[1] = "Stormwind Brie";
                prices[1] = 10.00;
                System.out.println(names[1] + ": $" + prices[1] + " per pound");
            }

            if (MAXCHEESE >= 3) {
                names[2] = "Alterac Swiss";
                prices[2] = 40.00;
                System.out.println(names[2] + ": $" + prices[2] + " per pound");
            }


            Random ranGen = new Random(100);

            for (int i = 3; i < MAXCHEESE; i++) {
                names[i] = "Cheese Type " + (char) ('A' + i);
                prices[i] = ranGen.nextInt(1000) / 100.0;
                amounts[i] = 0;

                System.out.println(names[i] + ": $" + prices[i] + " per pound");
            }

        }
    }

}
