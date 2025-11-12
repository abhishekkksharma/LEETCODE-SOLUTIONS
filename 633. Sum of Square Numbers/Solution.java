class Solution {
    public boolean judgeSquareSum(int c) {
        long lower = 0;
        long upper = (long)Math.sqrt(c);
        while(lower<=upper){
            long sum = lower*lower+upper*upper;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                lower++;
            } else {
                upper--;
            }
        }
        return false;
    }
}