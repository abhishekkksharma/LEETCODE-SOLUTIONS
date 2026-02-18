class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev=-1;
        while(n>0){
            if(prev==-1){
                prev=(n&1);
                n=n>>1;
                continue;
            }
            if((n&1)==prev) return false;
            prev=(n&1);
            n=n>>1;
        }
        return true;
    }
}