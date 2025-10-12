class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        ArrayList<Integer> nums = new ArrayList<>();
        while (current != null) {
            nums.add(current.val);
            current = current.next;
        }
        return palindromeCheck(nums);
    }

    private boolean palindromeCheck(ArrayList<Integer> nums) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (!nums.get(left).equals(nums.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
