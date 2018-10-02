class Solution {

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }

        // this variable is to keep track of the longest palindrome word already found
        String longest = "";

        for (int cursor = 0; cursor < s.length() - longest.length() / 2; cursor++) {

            // set the left pointer to be the beginning of the origin of the palindrome
            int lp = cursor;

            // set the right pointer to be the end of the origin of the palindrome
            int rp = cursor;
            while (rp < s.length() - 1 && s.charAt(lp) == s.charAt(rp + 1)) {
                rp++;
            }

            // start moving the two pointers outwards until the end of the palindrome
            while (lp > 0 && rp < s.length() - 1 && s.charAt(lp - 1) == s.charAt(rp + 1)) {
                lp--;
                rp++;
            }

            String palindrome = s.substring(lp, rp + 1);

            // replace longest if needed
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }

        }

        return longest;
    }

}