import java.util.*;
public class RemainderFunc {

    public static void main(String[] args) {
        Scanner kybd = new Scanner(System.in);
        System.out.println("Please enter the max number:");
        int max = kybd.nextInt();
        System.out.println("Please enter the divisor:");
        int divi = kybd.nextInt();

        for(int i = 1; i <= max; i++){
            System.out.println("Num: " + i + "%" + divi + "= " + (i%divi) );
        }

    }
}