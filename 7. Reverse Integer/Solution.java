class Solution {
    public int reverse(int x) {
        String tempNum = Integer.toString(x);

        StringBuilder invertedNum = new StringBuilder();

        if (tempNum.charAt(0) == '-') {
            for (int i = 1; i < tempNum.length(); i++)
                invertedNum.insert(0, tempNum.charAt(i));
            invertedNum.insert(0, '-');
        } else {
            for (int i = 0; i < tempNum.length(); i++)
                invertedNum.insert(0, tempNum.charAt(i));
        }

        try {
            return Integer.parseInt(invertedNum.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}