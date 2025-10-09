class Solution {
    public int missingNumber(int[] nums) {
        int xor=0;
        int wholeXor=0;
        int n=nums.length;
        for(int num : nums){
            xor^=num;
        }
        for(int i=1;i<=n;i++){
            wholeXor^=i;
        }
        return xor^wholeXor;
    }
}