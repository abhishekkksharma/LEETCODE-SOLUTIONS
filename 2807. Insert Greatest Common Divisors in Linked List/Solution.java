class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        while (second != null) {
            int gcdVal = gcd(first.val, second.val);
            ListNode gcdNode = new ListNode(gcdVal);
            gcdNode.next = second;
            first.next = gcdNode;

            first = second;
            second = second.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
