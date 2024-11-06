import java.math.BigDecimal;
import java.util.*;

/**
 * Given an array, s, of n real number strings,
 * sort them in descending order — but wait, there's more!
 * Each number must be printed in the exact same format as it was read from stdin,
 * meaning that  is printed as .1, and  is printed as .1. If two numbers represent numerically equivalent
 * values (e.g., .1=0.1), then they must be listed in the same order as they were received as input).
 */
public class BigDecimalSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] input = new String[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }

        Arrays.sort(input, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                BigDecimal num1 = new BigDecimal(s1);
                BigDecimal num2 = new BigDecimal(s2);
                int comparison = num2.compareTo(num1);
                return (comparison != 0) ? comparison : 0;
            }
        });

        for (String s : input) {
            System.out.println(s);
        }
    }
}
