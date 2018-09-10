class Solution {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int rest = target - nums[i];

            // try to find rest in the rest of the array
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == rest)
                    return new int[]{i, j};
            }
        }
        return null;
    }
}