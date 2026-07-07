class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int r=image.length;
        int c=image[0].length;
        dfs(image,image[sr][sc],color,sr,sc);
        return image;
    }
    private void dfs(int[][] mat,int initial, int newColor,int i,int j){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]!=initial || mat[i][j]==newColor){
            return;
        }
        mat[i][j]=newColor;
        //check all 4 diractions
        dfs(mat,initial,newColor,i+1,j);
        dfs(mat,initial,newColor,i-1,j);
        dfs(mat,initial,newColor,i,j+1);
        dfs(mat,initial,newColor,i,j-1);
    }
}