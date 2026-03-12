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
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode newNode=reverse(head);
        
        int carry=0;
        ListNode dummyhead= new ListNode(-1);
        ListNode tail=dummyhead;
        ListNode temp=newNode;
        while(temp!=null){
            int val=carry + 2* temp.val;
            ListNode n = new ListNode(val%10);
            tail.next=n;
            carry=val/10;
            temp=temp.next;
            tail=tail.next;
        }
        if(carry!=0){
            tail.next=new ListNode(carry);
        }
        return reverse(dummyhead.next);
    }
}