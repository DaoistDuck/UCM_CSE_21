package com.company;
import java.util.*;
public class CheeseShop {

    public static void main(String[] args) {
        int sharp, brie, swiss, list;
        double totalSharp, totalBrie, totalSwiss;
        double subTotal, discount, total;
        Scanner kybd = new Scanner(System.in);

        System.out.println("We sell 3 kinds of cheeses.");
        System.out.println("Dalaran Sharp: $1.25 per pound.");
        System.out.println("Stormwind Brie: $10.00 per pound.");
        System.out.println("Alterac Swiss: $40.00 per pound.");

        System.out.println("Enter the amount of Sharp in lbs: ");
        sharp = kybd.nextInt();
        System.out.println("Enter the amount of Brie in lbs: ");
        brie = kybd.nextInt();
        System.out.println("Enter the amount of Swiss in lbs: ");
        swiss = kybd.nextInt();

        System.out.println("Display the itemized list? (1 for yes) ");
        list = kybd.nextInt();

        totalSharp = 1.25*sharp;
        totalBrie = 10.00*brie;
        totalSwiss = 40.00*swiss;

      if(list == 1){
          if(sharp >= 1){
              System.out.println(sharp +" lbs of Sharp @ $1.25 = $" + totalSharp);
          }
          if(brie >= 1){
              System.out.println(brie +" lbs of Brie @ $10.00 = $" + totalBrie);
          }
          if(swiss >= 1){
              System.out.println(swiss +" lbs of Swiss @ $40.00 = $" + totalSwiss);
          }
      } else{
      }
       subTotal = totalSharp + totalBrie + totalSwiss;

       if(subTotal > 100){
           discount = 25;
       }else if(subTotal > 50){
           discount = 10;
       }else{
           discount = 0;
       }
        total = subTotal - discount;

        System.out.println("Sub Total : $" + subTotal);
        System.out.println("- Discount: $" + discount);
        System.out.println("Total     : $" + total);

    }
}
