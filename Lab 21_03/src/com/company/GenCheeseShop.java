package com.company;

import java.util.*;

public class GenCheeseShop {

    public static void main(String[] args) {

        final int MAXCHEESE = 4;

        Scanner kybd = new Scanner(System.in);
        String[] names = new String[MAXCHEESE];
        double[] prices = new double[MAXCHEESE];
        int[] amounts = new int[MAXCHEESE];
        double subtotal = 0;
        double total = 0;
        int discount = 0;


        System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");
        // Three Special Cheeses
        if(MAXCHEESE >=  1) {
            names[0] = "Dalaran Sharp";
            prices[0] = 1.25;
            System.out.println(names[0] + ": $" + prices[0] + " per pound");
        }

        if(MAXCHEESE >=  2) {
            names[1] = "Stormwind Brie";
            prices[1] = 10.00;
            System.out.println(names[1] + ": $" + prices[1] + " per pound");
        }

        if(MAXCHEESE >= 3) {
            names[2] = "Alterac Swiss";
            prices[2] = 40.00;
            System.out.println(names[2] + ": $" + prices[2] + " per pound");
        }

        Random ranGen = new Random(100);

        for (int i = 3; i < MAXCHEESE; i++) {
            names[i] = "Cheese Type " + (char)('A' + i);
            prices[i] = ranGen.nextInt(1000)/100.0;
            amounts[i] = 0;
            System.out.print(names[i] + ": $" + prices[i] + " per pound");
            System.out.println("");
        }

        for (int j = 0; j < MAXCHEESE; j++){
            System.out.println("Enter the amount of " + names[j] + ":");
            amounts[j] = kybd.nextInt();
        }

        System.out.println("Display the itemized list? (1 for yes) ");
        int show = kybd.nextInt();

        if(show == 1){
            for(int k = 0; k < amounts.length; k++){
                if(amounts[k] > 0){
                    System.out.println(amounts[k] + " lbs of " + names[k] + " @ " + prices[k] );
                  subtotal +=  amounts[k] * prices[k] ;
                }
            }
        }

        if(subtotal > 100){
             discount = 25;
        }
        else if(subtotal > 50){
             discount = 10;
        }

        total = subtotal - discount;

        System.out.println("Sub Total: $" + subtotal);
        System.out.println("-Discount: $" + discount);
        System.out.println("Total    : $" + total);

    }

}
