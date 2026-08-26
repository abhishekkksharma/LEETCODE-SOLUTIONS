class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i1=text1.length()-1;
        int i2=text2.length()-1;
        int[][] dp=new int[i1+1][i2+1];
        for(int i=0;i<=i1;i++) Arrays.fill(dp[i],-1);
        return helper(text1,text2,i1,i2,dp);
    }
    private int helper(String s1,String s2,int i1,int i2,int[][] dp){
        if(i1<0 || i2<0) return 0;
        int ans=0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2)){
            ans = 1+helper(s1,s2,i1-1,i2-1,dp);
        }else{
            ans = 0 + Math.max(helper(s1,s2,i1-1,i2,dp),helper(s1,s2,i1,i2-1,dp));
        }
        return dp[i1][i2]=ans;
    }
}