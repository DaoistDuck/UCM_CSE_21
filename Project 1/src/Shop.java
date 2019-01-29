import java.util.Scanner;

public class Shop {

    private static int intro(Scanner input) {
        System.out.println("This program supports 4 functions: ");
        System.out.println("    1. Setup Shop");
        System.out.println("    2. Buy");
        System.out.println("    3. List Items");
        System.out.println("    4. Checkout");
        System.out.print("Please choose the function you want: ");
        int function = input.nextInt();
        System.out.println("");
        return function;
    }

    private static double[] setupShop(Scanner input, String[] names, double[] prices) {
        System.out.print("Please enter the number of items: ");
        int number = input.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.print("Enter the name of the product " + i + ": ");
            names[i] = input.next();
            System.out.print("Enter the price of the product " + i + ": ");
            prices[i] = input.nextDouble();
        }

        System.out.print("Please enter the amount to qualify for discount:");
        int discount = input.nextInt();
        System.out.print("Please enter the discount rate(0.1 for 10%):");
        double discountRate = input.nextDouble();
        System.out.println("");
        double [] placeHolder = {number, discount, discountRate};
        return placeHolder;
    }

  private static double[] calcSubTotal(double[] prices, int[] amounts, double[] placeHolder) {

        double[] total = new double[(int) placeHolder[0]];

        for (int i = 0; i < placeHolder[0]; i++) {
            total[i] += prices[i] * amounts[i];
        }
        return total;
    }

    private static void buy(Scanner input, String[] names, int[] amounts, double[] placeHolder) {

        for (int i = 0; i < placeHolder[0]; i++) {
            System.out.print("Enter the amount of " + names[i] + ": ");
            amounts[i] = input.nextInt();
        }
        System.out.println("");
    }

    private static double listItems(String[] names, double[] prices, int[] amounts, double[] calcSubTotal, double[] placeHolder) {

        double subTotal = 0.0;

        for (int i = 0; i < placeHolder[0]; i++) {
            System.out.println(amounts[i] + " counts of " + names[i] + " @ " + prices[i] + " = " + calcSubTotal[i]);
            subTotal += amounts[i] * prices[i];
        }
        System.out.println("");
        return subTotal;
    }

    private static void checkOut(double subTotal, double[] placeHolder) {
        double realDiscount;

        if (subTotal >= placeHolder[1]) {
            realDiscount = subTotal * placeHolder[2];
        } else {
            realDiscount = 0;
        }
        double total = subTotal - realDiscount;
        System.out.println("Thanks for coming!");
        System.out.println("Sub Total: $" + subTotal);
        System.out.println("-Discount: $" + realDiscount);
        System.out.println("Total:     $" + total);
    }

    private static void errorShop(){
        System.out.println("");
        System.out.println("Shop isn't setup yet!");
        System.out.println("");
    }

    private static void errorBuy(){
        System.out.println("");
        System.out.println("Try again: You have not bought anything.");
        System.out.println("");
    }
    private static void errorFunction(int function){
        System.out.println("");
        System.out.println("Error: Do not know " + function);
        System.out.println("");
    }

    public static void main(String[] args) {
        int shop = 0, buy = 0, finish = 0;
        double subTotal = 0;

        final int MAX = 1000;

        String[] names = new String[MAX];
        double[] prices = new double[MAX];
        int[] amounts = new int[MAX];
        double[] placeHolder = new double[MAX];

        while (finish != 1) {

            Scanner input = new Scanner(System.in);

            int function = intro(input);

            if (function == 1) {
                placeHolder = setupShop(input, names, prices);
                shop = 1;
            }
            if (function == 2) {
                if (shop == 1) {
                    buy(input, names, amounts, placeHolder);
                    buy = 1;
                } else {
                    errorShop();
                }
            }
            if (function == 3) {
                if (shop == 1) {
                    if (buy == 1) {
                        subTotal = listItems(names, prices, amounts, calcSubTotal(prices, amounts, placeHolder), placeHolder);

                    } else {
                       errorBuy();
                    }
                } else {
                   errorShop();
                }
            }
            if (function == 4) {
                if (shop == 1) {
                    if (buy == 1) {
                        checkOut(subTotal, placeHolder);
                        finish = 1;
                    } else {
                        errorBuy();
                    }
                } else {
                  errorShop();
                }
            }
            if (function > 4) {
              errorFunction(function);
            }
        }
    }
}
