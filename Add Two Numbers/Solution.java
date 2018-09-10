import java.math.BigInteger;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = new BigInteger(readNum(l1));
        BigInteger num2 = new BigInteger(readNum(l2));
        BigInteger sum = num1.add(num2);

        return writeNum(sum.toString());
    }

    private String readNum(ListNode node) {
        if (node == null)
            return "";

        return readNum(node.next) + node.val;
    }

    private ListNode writeNum(String num) {

        if (num.length() == 0)
            return null;

        ListNode node = new ListNode(Character.getNumericValue(num.charAt(num.length() - 1)));

        if (num.length() > 1)
            node.next = writeNum(num.substring(0, num.length() - 1));
        return node;
    }
}