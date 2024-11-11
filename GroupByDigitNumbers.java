import java.util.*;
import java.util.stream.Collectors;

public class GroupByDigitNumbers {
    /*
    - Group input integers into the map with the key being the number of digits,
    and the corresponding value is a list of numbers having that number of digits.
    - The type of each element in the list should be String.
    - Filter out negative values.
    - Each such string is an input element preceded by the letter 'e' if the number is even,
    and preceded by the letter 'o' if the number is odd.
    - For example, if the input list is (3, 44, 108, 8, 51),
      the output should be 1 -> ["o3", "e8"]; 2 -> ["e44", "o51"]; 3 -> ["e108"]
     */
    public Map<Integer, List<String>> groupByDigitNumbers(int[] input) {
        return Arrays.stream(input)
                .filter(number -> number >= 0).mapToObj(number -> {
                    String prefix = (number % 2 == 0) ? "e" : "o";
                    return prefix + number;
                })
                .collect(Collectors.groupingBy(
                        str -> str.length()-1,
                        Collectors.toList()
                ));
    }

    public static void main(String[] args) {
        GroupByDigitNumbers gbdn = new GroupByDigitNumbers();
        int[] input = {3, 44, 108, 8, 51};
        Map<Integer, List<String>> result = gbdn.groupByDigitNumbers(input);

        // Print the result
        for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
