import static java.lang.Math.max;

class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int maxTwoBefore = nums[0];
        int maxBefore = max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int newMaxTwoBefore = maxBefore;
            maxBefore = max(maxTwoBefore + nums[i], maxBefore);
            maxTwoBefore = newMaxTwoBefore;
        }
        return maxBefore;
    }

}