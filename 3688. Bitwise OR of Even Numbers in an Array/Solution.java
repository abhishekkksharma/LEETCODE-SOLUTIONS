class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int orOperations=0;
        for(int num : nums){
            if(num%2==0) orOperations|=num;
        }
        return orOperations;
    }
}