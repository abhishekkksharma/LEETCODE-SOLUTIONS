class Solution {
    public ListNode oddEvenList(ListNode head) {
        int size=0;
        ListNode temp=head;
        if(head==null) return null;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        for(int i=0;i<size;i++){
            if(i%2==0){
                tail.next=new ListNode(temp.val);
                tail=tail.next;
            }
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<size;i++){
            if(i%2!=0){
                tail.next=new ListNode(temp.val);
                tail=tail.next;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}