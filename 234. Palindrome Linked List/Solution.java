class Solution {
    public boolean isPalindrome(ListNode head) {
        // ListNode current = head;
        // ArrayList<Integer> nums = new ArrayList<>();
        // while (current != null) {
        //     nums.add(current.val);
        //     current = current.next;
        // }
        // return palindromeCheck(nums);
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode prev=null , pres=slow;
        ListNode next=pres.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null) next=next.next;
        }
        ListNode first =head, second = prev;
        while(second!=null){
            if(first.val!=second.val) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
}
