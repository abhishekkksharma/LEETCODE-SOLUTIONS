/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *//
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int start=0;
        int last=list.size()-1;
        int max=Integer.MIN_VALUE;
        while(start<=last){
            max=Math.max(max, list.get(start) + list.get(last) );
            start++;
            last--;
        }
        return max;
    }

}