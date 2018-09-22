class Solution {
    public boolean find132pattern(int[] nums) {
        int previousNum = 0;
        int num;
        int lp;
        int rp;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0) {
                if (nums[i] < previousNum)
                    num = nums[i];
                else
                    continue;
            } else
                num = nums[i];

            previousNum = num;

            lp = i + 1;

            boolean foundSecondNumber = false;
            while (lp < nums.length - 1) {
                if (nums[lp] > num) {
                    foundSecondNumber = true;
                    break;
                }
                lp++;
            }
            if (!foundSecondNumber)
                continue;

            rp = lp + 1;
            while (rp < nums.length) {
                if (nums[rp] > num) {
                    if (nums[rp] < nums[lp])
                        return true;
                    else if (rp < nums.length - 1) {
                        lp = rp;
                    }
                }
                rp++;
            }
        }
        return false;
    }
}