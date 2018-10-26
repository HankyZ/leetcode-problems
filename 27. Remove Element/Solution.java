class Solution {
    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0)
            return 0;

        int rp = nums.length - 1;
        int i = 0;
        for (; i <= rp; i++) {
            if (nums[i] == val) {
                while (nums[rp] == val) {
                    if (rp == i)
                        return i;
                    rp--;
                }
                nums[i] = nums[rp];
                rp--;
            }
        }
        return i;
    }
}