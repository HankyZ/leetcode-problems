class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        String longest = strs[0];

        if (strs.length == 1)
            return longest;

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(longest)) {
                longest = longest.substring(0, longest.length() - 1);
            }
        }

        return longest;
    }
}