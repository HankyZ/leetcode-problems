class Solution {
    public boolean isMatch(String s, String p) {

        if (p.length() == 0 && s.length() == 0)
            return true;
        if (p.length() == 0)
            return false;

        if (p.length() == 1 && p.charAt(0) == '.')
            return s.length() == 1;
        if (p.length() == 1)
            return s.equals(p);

        if (s.length() == 0) {
            if (p.charAt(1) == '*')
                return isMatch(s, p.substring(2));
            return false;
        }

        if (p.charAt(1) != '*') {
            if (p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            }
            if (s.charAt(0) == p.charAt(0)) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }

        if (p.startsWith(".*")) {
            if (isMatch(s, p.substring(2)))
                return true;
            return isMatch(s.substring(1), p);
        }

        if (s.charAt(0) == p.charAt(0)) {
            if (isMatch(s, p.substring(2)))
                return true;
            return isMatch(s.substring(1), p);
        }

        return isMatch(s, p.substring(2));
    }
}