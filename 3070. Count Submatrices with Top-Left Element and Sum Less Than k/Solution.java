class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0);
                else if(i==0) grid[i][j]+=grid[i][j-1];
                else if(j==0) grid[i][j]+=grid[i-1][j];
                else{
                    grid[i][j]+=grid[i][j-1]+grid[i-1][j] - grid[i-1][j-1];
                }
                if(grid[i][j]<=k) count++;
            }
        }

        return count;
    }
}