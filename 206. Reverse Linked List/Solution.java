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
    public ListNode reverseList(ListNode head) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     arr.add(temp.val);
        //     temp=temp.next;
        // }
        // ListNode dummy = new ListNode(0);
        // ListNode x=dummy;
        // for(int i=arr.size()-1;i>=0;i--){
        //     ListNode curr = new ListNode(arr.get(i));
        //     x.next=curr;
        //     x=x.next;
        // }
        // return dummy.next;
        if(head==null || head.next==null) return head;
        ListNode prev=null;
        ListNode pres=head;
        ListNode next = pres.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
                next=next.next;
            }
        }
        head=prev;
        return head;
    }
}