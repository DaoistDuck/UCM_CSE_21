import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	public static void intro(String[] names, double[]prices, int[] amounts) {
		// Fill-in
        System.out.println("We sell " + prices.length + " kinds of Cheese");
        // Three Special Cheeses
        if(prices.length >=  1) {
            names[0] = "Dalaran Sharp";
            prices[0] = 1.25;
            System.out.println(names[0] + ": $" + prices[0] + " per pound");
        }

        if(prices.length >=  2) {
            names[1] = "Stormwind Brie";
            prices[1] = 10.00;
            System.out.println(names[1] + ": $" + prices[1] + " per pound");
        }

        if(prices.length >= 3) {
            names[2] = "Alterac Swiss";
            prices[2] = 40.00;
            System.out.println(names[2] + ": $" + prices[2] + " per pound");
        }

        Random ranGen = new Random(100);

        for (int i = 3; i < prices.length; i++) {
            names[i] = "Cheese Type " + (char)('A' + i);
            prices[i] = ranGen.nextInt(1000)/100.0;
            amounts[i] = 0;
            System.out.print(names[i] + ": $" + prices[i] + " per pound");
            System.out.println("");
        }
	}

	public static void getAmount(Scanner input, String[] names, int[] amounts) {
		// Fill-in
        for (int j = 0; j <amounts.length; j++){
            System.out.println("Enter the amount of " + names[j] + ":");
            amounts[j] = input.nextInt();
        }
	}

	public static void itemizedList(String[] names, double[]prices, int[] amounts) {
		// Fill-in
        for(int k = 0; k < amounts.length; k++){
            if(amounts[k] > 0){
                System.out.println(amounts[k] + " lbs of " + names[k] + " @ " + prices[k] );
            }
        }
	}

	public static double calcSubTotal(double[] prices, int[] amounts) {
		// Fix
        int total = 0;
      for(int i = 0; i < prices.length; i ++){
          total += prices[i] * amounts[i];
        }

		return total;
	}

	public static int discount(double subTotal){
		// Fix
        int discount = 0;
        if(subTotal >= 50){
            if(subTotal >=100)
                return discount = 25;
            else
                return discount = 10;
        }
        return 0;

	}

	public static void printTotal(double subTotal, int discount) {
	    double total = subTotal - discount;
        System.out.println("Sub Total:   $" + subTotal);
        System.out.println("-Discount:   $" + discount);
	    System.out.println("Total price: $" + total);

	}

	public static void main(String[] args) {

		final int MAXCHEESE = 4;

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		Scanner input = new Scanner(System.in);

		intro(names, prices, amounts);

		getAmount(input, names, amounts);

		double total = calcSubTotal(prices, amounts);
		
		if (MAXCHEESE > 0) {
			System.out.print("Display the itemized list? (1 for yes) ");
			int itemized = input.nextInt();

			if (itemized == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		System.out.println();

		printTotal(total, discount(total));
	}
}