package recursion;

public class DigitCount {

	public static void main(String[] args) {

		System.out.println(digitCount(314159));
	}
	
	// Fix the bug in digitCount, so that it returns correct values.
	// You only need to change one line.
	public static int digitCount(int value) {
		if(value >= 0 && value < 10) {
			return 1;
		} else {
			return 1 + digitCount(value/10);
		} 
	}
}
