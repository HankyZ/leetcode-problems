class Solution {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < max)
                break;

            for (int j = i + 1; j <= s.length(); j++) {
                if (hasDuplicatedChar(s.substring(i, j))) {
                    break;
                }
                if (max < j - i)
                    max = j - i;
            }
        }
        return max;
    }

    private boolean hasDuplicatedChar(String s) {
        if (s.length() == 0)
            return false;

        String c = s.substring(0, 1);
        String substring = s.substring(1);
        if (substring.contains(c))
            return true;
        else
            return hasDuplicatedChar(substring);
    }
}