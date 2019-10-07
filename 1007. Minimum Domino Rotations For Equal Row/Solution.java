import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        int[] nums = {A[0], B[0]};

        int[][] occurences = {{1, 0}, {0, 1}};

        if (A[0] == B[0]) {
            nums[1] = -1;
            occurences[0][0] = 0;
        }

        for (int i = 1; i < A.length; i++) {
            for (int n = 0; n < 2; n++) {
                if (nums[n] == -1) {
                    continue;
                }
                if (nums[n] != A[i] && nums[n] != B[i]) {
                    nums[n] = -1;
                } else if (nums[n] == A[i] && nums[n] != B[i]) {
                    occurences[n][0]++;
                } else if (nums[n] != A[i]) {
                    occurences[n][1]++;
                }
            }
            if (nums[0] == -1 && nums[1] == -1)
                return -1;
        }

        if (nums[0] != -1)
            return occurences[0][0] < occurences[0][1] ? occurences[0][0] : occurences[0][1];

        return occurences[1][0] < occurences[1][1] ? occurences[1][0] : occurences[1][1];
    }

    public static void main(String[] args) {
        int[] A = {6, 1, 6, 4, 6, 6};
        int[] B = {5, 6, 2, 6, 3, 6};
        Solution s = new Solution();
        System.out.println(s.minDominoRotations(A, B));
    }
}