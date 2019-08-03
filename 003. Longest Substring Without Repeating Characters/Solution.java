import java.util.ArrayList;
import java.util.List;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) {
            return s.length();
        }

        int lp = 0;
        int rp = 1;
        int max = 1;

        List<Character> charList = new ArrayList<>();

        charList.add(s.charAt(lp));

        while (rp < s.length() && s.length() - lp > max) {

            if (charList.contains(s.charAt(rp))) {
                charList.remove(0);
                lp++;
            } else {
                charList.add(s.charAt(rp));
                if (charList.size() > max)
                    max = charList.size();
                rp++;
            }
        }

        return max;
    }

}