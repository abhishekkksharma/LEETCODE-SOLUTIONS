class Solution {
    public int arraySign(int[] nums) {
        int negtives=0;
        for(int num:nums){
            if(num==0) return 0;
            if(num<0) negtives++;
        }
        return negtives%2==0? 1:-1;
    }
}