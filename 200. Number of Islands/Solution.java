class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    total++;
                    dfs(grid,i,j);
                }
            }
        }
        return total;
    }
    private void dfs(char[][] grid,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!='1'){
            return;
        }
        grid[r][c]='0'; //marked visited 
        // check all 4 directions
        dfs(grid,r+1,c); // down
        dfs(grid,r-1,c); //up
        dfs(grid,r,c+1); //right
        dfs(grid,r,c-1); //left
    }
}