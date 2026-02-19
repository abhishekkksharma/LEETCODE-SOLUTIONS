class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int p=9,q=9,r=n;
        while(n-->1){
            p*=q--;
        }
        return p+countNumbersWithUniqueDigits(r-1);
    }
}