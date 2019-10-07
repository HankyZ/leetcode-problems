// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8

        if (A[0] == B[0])
            return findNumRotations(A, B, A[0]);

        int rotations1 = findNumRotations(A, B, A[0]);
        int rotations2 = findNumRotations(A, B, B[0]);

        if (rotations1 == -1)
            return rotations2;

        if (rotations2 == -1)
            return rotations1;

        return rotations1 < rotations2 ? rotations1 : rotations2;
    }

    private int findNumRotations(int[] A, int[] B, int target) {
        int rotationsA = 0;
        int rotationsB = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] == target && B[i] == target)
                continue;

            if (A[i] != target && B[i] != target)
                return -1;

            if (A[i] == target)
                rotationsA++;

            else
                rotationsB++;
        }
        return rotationsA < rotationsB ? rotationsA : rotationsB;
    }
}
