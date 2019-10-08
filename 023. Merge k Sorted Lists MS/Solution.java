import java.util.Comparator;
import java.util.PriorityQueue;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        ListNode ans = new ListNode(0);
        ListNode tmp = ans;

        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;

            if (tmp.next != null)
                queue.offer(tmp.next);
        }

        return ans.next;
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);

        ListNode tmp1 = list1;
        ListNode tmp2 = list2;

        int[] listVal1 = {-2, -1, -1, -1};
        int[] listVal2 = {};

        for (int v : listVal1) {
            tmp1.next = new ListNode(v);
            tmp1 = tmp1.next;
        }

        for (int v : listVal2) {
            tmp2.next = new ListNode(v);
            tmp2 = tmp2.next;
        }

        ListNode[] lists = {list1.next, list2.next};


        Solution s = new Solution();
        s.mergeKLists(lists);

        int x = 0;
    }
}