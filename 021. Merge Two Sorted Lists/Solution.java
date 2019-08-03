/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode answer;

        if (l1 == null && l2 == null)
            return null;

        if (l1 == null) {
            answer = new ListNode(l2.val);
            l2 = l2.next;
        } else if (l2 == null) {
            answer = new ListNode(l1.val);
            l1 = l1.next;
        } else if (l1.val > l2.val) {
            answer = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            answer = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode current = answer;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            current = current.next;
        }

        return answer;
    }
}