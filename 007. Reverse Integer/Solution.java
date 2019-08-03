class Solution {
    public int reverse(int x) {

        boolean negative = false;

        if (x < 0) {
            negative = true;
            x *= -1;
        }

        String tempNum = Integer.toString(x);

        StringBuilder invertedNum = new StringBuilder();

        for (int i = 0; i < tempNum.length(); i++)
            invertedNum.insert(0, tempNum.charAt(i));

        try {
            if (negative)
                return Integer.parseInt(invertedNum.toString()) * -1;
            return Integer.parseInt(invertedNum.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}