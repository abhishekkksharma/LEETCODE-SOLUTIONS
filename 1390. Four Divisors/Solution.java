class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int num:nums){
            int count=0;
            int tempsum=0;
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    tempsum+=i;
                    count++;
                }
                if(count>4) break;
            }
            if(count==4) sum+=tempsum;
        }
        return sum;
    }
}