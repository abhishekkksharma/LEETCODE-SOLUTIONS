class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        bfs(grid,visited);
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && visited[i][j]==0) count++;
            }
        }
        return count;
    }
    private void bfs(int[][] grid,int[][] visited){
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && visited[i][0]==0){
                visited[i][0]=1;
                q.add(new int[]{i,0});
            }
            if(grid[i][m-1]==1 && visited[i][m-1]==0){
                visited[i][m-1]=1;
                q.add(new int[]{i,m-1});
            }
        }

        for(int i=0;i<m;i++){
            if(grid[0][i]==1 && visited[0][i]==0){
                visited[0][i]=1;
                q.add(new int[]{0,i});
            }
            if(grid[n-1][i]==1 && visited[n-1][i]==0){
                visited[n-1][i]=1;
                q.add(new int[]{n-1,i});
            }
        }
        int[][] dir={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int i=0;i<4;i++){
                int nrow=r+dir[i][0];
                int ncol=c+dir[i][1];
                if(nrow>=0 && nrow<n &&
                ncol>=0 && ncol<m && 
                grid[nrow][ncol]==1 &&
                visited[nrow][ncol]!=1
                ){
                    q.add(new int[]{nrow,ncol});
                    visited[nrow][ncol]=1;
                }
            }
        }
    }
}