class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        int spaces=0;
        for(char ch : moves.toCharArray()){
            if(ch=='L') left++;
            else if(ch=='R') right++;
            else spaces++;
        }
        int ans=Math.abs(left-right)+spaces;
        return ans;
    }
}