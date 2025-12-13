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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode dummytail=dummyhead;
        int carry=0;
        while(l1!=null || l2!=null){
            int value = carry;
            if(l1!=null) value+=l1.val;
            if(l2!=null) value+=l2.val;
            ListNode newNode = new ListNode(value%10);
            carry=value/10;
            dummytail.next=newNode;
            dummytail=dummytail.next;  
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;        
        }
        if(carry!=0){
            dummytail.next = new ListNode(carry);
        } 
        return dummyhead.next;
    }
}