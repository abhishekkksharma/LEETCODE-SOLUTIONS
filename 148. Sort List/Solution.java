/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeLists(left,right);
    }
    private ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null) prev.next=null;
        return slow;
    }
    private ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode dummyhead = new ListNode();
        ListNode tail=dummyhead;
        while(list1!=null && list2!=null){
            if(list1.val <  list2.val){
                tail.next=list1;
                list1=list1.next;
            }
            else{
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        if(list1!=null) tail.next=list1;
        else tail.next=list2;
        return dummyhead.next;
    }
}