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
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead=new ListNode(-1);
        ListNode tail=dummyhead;
        int carry=0;
        ListNode newL1= reverse(l1);
        ListNode newL2= reverse(l2);
        while(newL1!=null || newL2!=null){
            int val=carry;
            if(newL1!=null){
                val+=newL1.val;
                newL1=newL1.next;
            }
            if(newL2!=null){
                val+=newL2.val;
                newL2=newL2.next;
            }
            ListNode n = new ListNode(val%10);
            tail.next=n;
            carry=val/10;
            tail=tail.next;
        }
        if(newL1!=null){
            while(newL1!=null){
                int val=carry+newL1.val;
                ListNode n = new ListNode(val%10);
                tail.next=n;
                tail=tail.next;
                carry=val/10;
                newL1=newL1.next;
            }
        }
        if(newL2!=null){
            while(newL2!=null){
                int val=carry+newL2.val;
                ListNode n = new ListNode(val%10);
                tail.next=n;
                tail=tail.next;
                carry=val/10;
                newL2=newL2.next;
            }
        }
        if(carry!=0){
            tail.next=new ListNode(carry);
        }
        return reverse(dummyhead.next);
    }
}