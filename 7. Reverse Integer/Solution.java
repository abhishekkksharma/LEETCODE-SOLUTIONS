class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x<0){
            neg = true;
            x = Math.abs(x);
        }
        long rev = 0;
        while(x>0){
            int rem = x%10;
            rev = rev*10 + rem;
            x/=10;
        }
        if(rev>2147483647) return 0;
        if(neg){
            return (int)(-rev);
        }
        return (int)rev;
    }
}