import static java.lang.Math.pow;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int countDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.right;
            depth++;
        }
        return depth;
    }

    private boolean exists(TreeNode node, int depth, int position) {

        int lp = 0, rp = (int) pow(2, depth) - 1;

        for (int i = 0; i < depth; i++) {
            if (position > lp + (rp - lp) / 2) {
                node = node.right;
                lp = lp + (rp - lp) / 2 + 1;
            } else {
                node = node.left;
                rp = lp + (rp - lp) / 2;
            }
        }
        return node != null;
    }

    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        int depth = countDepth(root);

        int lp = 0;
        int rp = (int) pow(2, depth) - 1;

        while (lp + 1 < rp) {

            if (exists(root, depth, lp + (rp - lp) / 2 + 1)) {
                lp = lp + (rp - lp) / 2 + 1;
            } else {
                rp = lp + (rp - lp) / 2;
            }
        }

        int numExtraNodes = lp;

        if (exists(root, depth, lp))
            numExtraNodes++;

        if (exists(root, depth, rp))
            numExtraNodes++;

        return (int) pow(2, depth) - 1 + numExtraNodes;
    }
}