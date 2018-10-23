class Solution {

    private final int INT_MAX = 2147483647;
    private final int INT_MIN = -2147483648;

    public int myAtoi(String str) {

        int sign = 1;
        int start = 0;
        int end = 0;

        // remove leading spaces
        while (start < str.length()) {
            if (str.charAt(start) != ' ') {
                break;
            }
            start++;
        }
        str = str.substring(start);

        if (str.isEmpty())
            return 0;

        // determine sign
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            sign = -1;
            str = str.substring(1);
        }

        // remove trailing non digit characters
        while (end < str.length()) {
            if (47 > str.charAt(end) || str.charAt(end) > 58) {
                break;
            }
            end++;
        }

        str = str.substring(0, end);

        // remove leading zeros
        start = 0;
        while (start < str.length()) {
            if (str.charAt(start) != '0') {
                break;
            }
            start++;
        }

        str = str.substring(start);

        // convert to integer
        start = 0;
        int result = 0;
        while (start < str.length()) {
            if (result * 10 / 10 == result) {
                result *= 10;
                if (start == 9) {
                    int i = 0;
                }
                result += Character.getNumericValue(str.charAt(start)) * sign;
                start++;
            } else {
                if (sign > 0)
                    return INT_MAX;
                else
                    return INT_MIN;
            }
        }

        if (sign > 0 && result < 0)
            return INT_MAX;
        if (sign < 0 && result > 0)
            return INT_MIN;

        return result;
    }
}