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
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        if(head==null) return null;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        k=k%size;
        ListNode fast=head;
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }
        ListNode slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        } 
        fast.next=head;
        head=slow.next;
        slow.next=null;
        return head;
    }
}