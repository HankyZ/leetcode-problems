import java.util.HashSet;
import java.util.Set;

class Solution {

    private static class DSU {

        int[] parent;

        DSU(int size) {
            this.parent = new int[size];
            for (int i = 0; i < size; i++)
                this.parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }

    }

    public int removeStones(int[][] stones) {

        if (stones.length == 1)
            return 0;

        DSU dsu = new DSU(20000);

        for (int[] stone : stones) {
            dsu.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> seen = new HashSet<>();

        for (int[] stone : stones) {
            seen.add(dsu.find(stone[0]));
        }

        return stones.length - seen.size();
    }
}