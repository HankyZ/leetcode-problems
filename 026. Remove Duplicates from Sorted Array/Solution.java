class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int lp = 0;
        int rp = 1;
        int max = nums[nums.length - 1];

        while (rp < nums.length && nums[lp] != max) {
            if (nums[lp] == nums[rp]) {
                rp++;
            } else {
                int tmp = nums[lp + 1];
                nums[lp + 1] = nums[rp];
                nums[rp] = tmp;
                lp++;
                rp++;
            }
        }
        return lp + 1;
    }
}