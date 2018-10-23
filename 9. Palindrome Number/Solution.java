import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        Queue<Integer> reversedDigits = new LinkedList<>();

        for (int i = 1; x / i > 0; i *= 10) {
            if (i < 1000000000) {
                reversedDigits.add(x % (i * 10) / i);
            } else {
                reversedDigits.add(x / i);
                break;
            }
        }

        int reversedNum = 0;

        while (!reversedDigits.isEmpty()) {
            reversedNum = reversedNum * 10 + reversedDigits.remove();
        }

        return x == reversedNum;
    }
}
