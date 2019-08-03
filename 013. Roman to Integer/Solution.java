import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('M', 1000);
        romanNumerals.put('D', 500);
        romanNumerals.put('C', 100);
        romanNumerals.put('L', 50);
        romanNumerals.put('X', 10);
        romanNumerals.put('V', 5);
        romanNumerals.put('I', 1);

        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int currentValue = romanNumerals.get(s.charAt(i));
            int nextValue = romanNumerals.get(s.charAt(i + 1));

            if (currentValue < nextValue) {
                sum += -1 * currentValue;
            } else {
                sum += currentValue;
            }
        }

        sum += romanNumerals.get(s.charAt(s.length() - 1));

        return sum;
    }
}