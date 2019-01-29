import java.util.*;

public class RunShop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ShopArr shop = new ShopArr();
		shop.run();
		System.out.println("Ran with Cheese Total: " + Cheese.numCheese);
	}

}
