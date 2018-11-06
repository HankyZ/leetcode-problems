class Solution {
    public int maxArea(int[] height) {

        int lp = 0;
        int rp = height.length - 1;
        int max = 0;

        while (lp < rp) {
            if (height[lp] > height[rp]) {
                max = Math.max(max, height[rp] * (rp - lp));
                rp--;
            } else {
                max = Math.max(max, height[lp] * (rp - lp));
                lp++;
            }
        }

        return max;
    }
}