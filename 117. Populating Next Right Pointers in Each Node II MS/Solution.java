import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {
    public Node connect(Node root) {

        if (root == null)
            return null;

        Queue<Node> nextQueue = new LinkedList<>();

        Node firstInLine = root;
        Node next = firstInLine;
        while (true) {

            while (next != null) {
                if (next.left != null) {
                    nextQueue.offer(next.left);
                }
                if (next.right != null) {
                    nextQueue.offer(next.right);
                }
                next = next.next;
            }

            if (nextQueue.isEmpty())
                break;

            firstInLine = nextQueue.poll();
            next = firstInLine;

            while (!nextQueue.isEmpty()) {
                next.next = nextQueue.poll();
                next = next.next;
            }

            next = firstInLine;
        }
        return root;
    }
}
