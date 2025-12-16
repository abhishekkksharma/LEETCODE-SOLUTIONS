class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length<=2) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num < min) min = num;
            if(num>max) max=num;
        }
        Stack<Integer> st = new Stack<>();
        st.push(min);
        st.push(max);
        for(int num : nums){
            if(!st.contains(num)) return num;
        }
        return -1;
    }
}