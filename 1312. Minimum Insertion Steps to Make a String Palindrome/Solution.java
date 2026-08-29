class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder rev=new StringBuilder();
        rev.append(s).reverse();
        return n-palindrome_lcs(s,rev.toString(),n);
    }
    private int palindrome_lcs(String a,String b,int n){
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                // same char
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                // not same 
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}