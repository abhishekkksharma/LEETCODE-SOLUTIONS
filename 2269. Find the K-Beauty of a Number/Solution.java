class Solution {
    public int divisorSubstrings(int num, int k) {
        String temp = Integer.toString(num);
        int count=0;
        for(int i=0;i<=temp.length()-k;i++){
            int n=Integer.parseInt(temp.substring(i,i+k));
            if(n != 0 && num % n == 0) count++;
        }
        return count;
    }
}