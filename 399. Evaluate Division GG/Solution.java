import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static class Node {
        int parent;
        double value;

        Node(int parent) {
            this.parent = parent;
            this.value = 1d;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Integer> map = new HashMap<>();

        for (List<String> equation : equations) {
            for (String key : equation) {
                if (!map.containsKey(key))
                    map.put(key, map.size());
            }
        }

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < map.size(); i++)
            nodeList.add(new Node(i));

        // union
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            Integer nodeKey1 = map.get(equation.get(0));
            Integer nodeKey2 = map.get(equation.get(1));

            int groupHead1 = find(nodeList, nodeKey1);
            int groupHead2 = find(nodeList, nodeKey2);

            nodeList.get(groupHead2).parent = groupHead1;
            nodeList.get(groupHead2).value = values[i] * nodeList.get(nodeKey1).value / nodeList.get(nodeKey2).value;
        }

        // query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Integer k1 = map.get(query.get(0));
            Integer k2 = map.get(query.get(1));

            if (k1 == null || k2 == null) {
                results[i] = -1d;
                continue;
            }

            int groupHead1 = find(nodeList, k1);
            int groupHead2 = find(nodeList, k2);
            if (groupHead1 != groupHead2) {
                results[i] = -1d;
                continue;
            }

            results[i] = nodeList.get(k2).value / nodeList.get(k1).value;
        }
        return results;
    }

    private int find(List<Node> nodeList, int key) {
        int parent = key;
        while (nodeList.get(parent).parent != parent) {
            parent = nodeList.get(parent).parent;
            nodeList.get(key).value *= nodeList.get(parent).value;
        }
        nodeList.get(key).parent = parent;
        return parent;
    }
}