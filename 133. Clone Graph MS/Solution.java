import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {

        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        Map<Integer, Node> newNodeMap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        while (!queue.isEmpty()) {

            Node tmp = queue.poll();

            if (newNodeMap.containsKey(tmp.val))
                continue;

            List<Integer> neighborValueList = new ArrayList<>();

            for (Node neighbor : tmp.neighbors) {
                queue.offer(neighbor);
                neighborValueList.add(neighbor.val);
            }

            neighborMap.put(tmp.val, neighborValueList);
            newNodeMap.put(tmp.val, new Node(tmp.val, new ArrayList<>()));
        }

        for (int newNodeVal : newNodeMap.keySet()) {

            Node newNode = newNodeMap.get(newNodeVal);

            for (int neighborVal : neighborMap.get(newNodeVal)) {
                newNode.neighbors.add(newNodeMap.get(neighborVal));
            }

        }

        return newNodeMap.get(node.val);
    }
}