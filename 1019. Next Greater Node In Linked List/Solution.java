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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if(head==null) return list.stream().mapToInt(Integer::intValue).toArray();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=list.size()-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=list.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                int t=list.get(i);
                list.set(i,0);
                st.push(t);
            }
            else{
                int t=list.get(i);
                list.set(i,st.peek());
                st.push(t);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}