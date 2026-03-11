class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int num=0;
        int exp=0;
        while(n>0){
            if((n&1)==0){
                num+=Math.pow(2,exp);
            }else{
                num+=0;
            }
            exp++;
            n=n>>1;
        }
        return num;
    }
}