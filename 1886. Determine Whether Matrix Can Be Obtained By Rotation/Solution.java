class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        if(check(mat,target)) return true;
        if(check(rotate(mat),target)) return true;
        if(check(rotate(rotate(mat)),target)) return true;
        if(check(rotate(rotate(rotate(mat))),target)) return true;
        return false;
    }
    private int[][] rotate(int[][] mat){
        int n = mat.length;
        int[][] res = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[j][n-1-i]=mat[i][j];
            }
        }
        return res;
    }
    private boolean check(int[][] mat,int[][] target){
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
}