// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.toUpperCase;

class Solution {
    public String solution(String S, int K) {
        // write your code in Java SE 8

        char[] charArray = new char[S.length() + K];

        int charsTraversed = 0;

        int i = S.length() - 1;
        int p = charArray.length - 1;

        while (i >= 0) {
            char current = S.charAt(i);

            if (i == 0 && current == '-')
                break;

            if (charsTraversed == K) {
                if (current == '-') {
                    i--;
                }
                charArray[p--] = '-';
                charsTraversed = 0;
                continue;
            }

            if (current == '-') {
                i--;
                continue;
            }

            if (isLowerCase(current)) {
                current = toUpperCase(current);
            }
            charArray[p--] = current;
            charsTraversed++;
            i--;
        }
        return new String(Arrays.copyOfRange(charArray, p + 1, charArray.length));
    }

}
