class Solution {
    public void sortColors(int[] nums) {

        int lp = -1, cp = 0, rp = nums.length;

        while (cp < rp) {
            if (nums[cp] == 0) {
                int tmp = nums[cp];
                nums[cp] = nums[++lp];
                nums[lp] = tmp;
                cp++;
                continue;
            }
            if (nums[cp] == 2) {
                int tmp = nums[cp];
                nums[cp] = nums[--rp];
                nums[rp] = tmp;
                continue;
            }
            cp++;
        }

    }
}