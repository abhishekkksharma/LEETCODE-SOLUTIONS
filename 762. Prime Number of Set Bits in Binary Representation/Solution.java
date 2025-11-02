class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        while(left<=right){
            if(isPrime(countBits(left))) count++;
            left++;
        }
        return count;
    }
    private boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;
        if(num%2==0) return false;
        for(int i=3;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    private int countBits(int num){
        int count=0;
        while(num>0){
            if((num&1)==1) count++;
            num>>=1;
        }
        return count;
    }
}