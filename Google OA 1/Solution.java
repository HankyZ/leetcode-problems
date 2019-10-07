// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] plants, int capacity1, int capacity2) {
        // write your code in Java SE 8
        int numRefills = 0;

        int waterAmount1 = 0;
        int waterAmount2 = 0;

        int lp = 0;
        int rp = plants.length - 1;

        while (lp < rp) {
            if (waterAmount1 < plants[lp]) {
                numRefills++;
                waterAmount1 = capacity1;
            }
            if (waterAmount2 < plants[rp]) {
                numRefills++;
                waterAmount2 = capacity2;
            }
            waterAmount1 -= plants[lp++];
            waterAmount2 -= plants[rp--];
        }
        if (lp == rp && waterAmount1 + waterAmount2 < plants[lp]) {
            numRefills++;
        }
        return numRefills;
    }
}
