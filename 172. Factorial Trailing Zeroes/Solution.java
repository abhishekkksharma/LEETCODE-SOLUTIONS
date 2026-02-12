class Solution {
    public int trailingZeroes(int n) {
        if(n<=4) return 0;
        int count=0;
        for(long i=5;n/i>0;i*=5){
            count+=n/i;
        }
        return count;
    }

    /*
        600/5=120;
        600/25=24;
        600/125=..,
        the sum of all results would be the count of all trailing zeroes
    */
}