import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;
	
	// Initialize method
	private void init() {
		
		// Create max number of Cheese pointers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of Cheese: ");
        int max = input.nextInt();
		cheese = new Cheese[max]; 
		
		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Dalaran Sharp");
			cheese[0].setPrice(1.25);
		}
		if (max > 1) {
			cheese[1] = new Cheese("Stormwind Brie");
			cheese[1].setPrice(10.00);
		}
		if (max > 2) {
			cheese[2] = new Cheese("Alterac Swiss", 40.00);
			//cheese[2].setName("Wrong Name");
		}


        Random ranGen = new Random(100);
        for (int i = 3; i < cheese.length; i++) {
            // Fill-in Code
            cheese[i] = new Cheese();
            cheese[i].setName("Cheese Type " + (char)('A' + i));
            cheese[i].setPrice(ranGen.nextInt((1000)/100));
            cheese[i].setAmount(0);

        }


	}
	public ShopArr() {
		init();
	}
	
	public ShopArr(int max) {
		init();
	}

	private void intro(Scanner input) {

        System.out.println("We sell " + cheese.length + " types of Cheese");
        if(cheese.length > 0){
				System.out.println(cheese[0].getName() + ": $" + cheese[0].getPrice() + " per pound");
			}
			if(cheese.length > 1){
				System.out.println(cheese[1].getName() + ": $" + cheese[1].getPrice() + " per pound");
			}
			if(cheese.length > 2){
				System.out.println(cheese[2].getName() + ": $" + cheese[2].getPrice() + " per pound");
			}

			for(int i = 3; i < cheese.length; i++){
				System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
        }

        for(int i = 0; i < cheese.length; i++) {
            System.out.print("Enter amount of " + cheese[i].getName() + " : ");
            cheese[i].setAmount(input.nextInt());
        }
	}

	private double calcSubTotal() {
		double amount = 0;

		for(int i = 0; i<cheese.length; i++){
		    amount += cheese[i].getAmount() * cheese[i].getPrice();
        }

		return amount;
	}

	private double discount(double sub) {
		return ((sub > 100)? 25 : (sub > 50)? 10: 0);
	}

	private void itemizedList(){
		int amt;
		System.out.println();
        for(int i = 0; i < cheese.length; i ++) {
            if ((amt = cheese[i].getAmount()) > 0)
                System.out.println(amt + " lbs of Sharp  @ $1.25  = " + (amt * cheese[i].getPrice()));
        }
	}

	private void printTotal(double sub, double disc) {
		System.out.println();
		System.out.println("Sub Total:   $" + sub);
		System.out.println("- Discount:  $"+ disc);
		System.out.println("Total Price: $" + (sub - disc));
	}

	private void printFree(){
		int amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lbs of " + cheese[i].getName() + " @ $0 = " + 0);
		System.out.println("Total Price: FREE");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double sub = calcSubTotal();
		double disAmt = discount(sub);

		System.out.println();
		System.out.print("Do you want to see the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is "+ free);
		if (free != 0)
			printTotal(sub, disAmt);
		else {
			printFree();
			return ;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}
