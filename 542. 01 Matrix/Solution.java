class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] visited=new int[n][m];
        int[][] dist=new int[n][m];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j]=1;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        int[][] direction = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];
            int d=curr[2];
            for(int x=0;x<4;x++){
                int nrow=i+direction[x][0];
                int ncol=j+direction[x][1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0){
                    dist[nrow][ncol]=d+1;
                    q.add(new int[]{nrow,ncol,d+1});
                    visited[nrow][ncol]=1;   
                }
            }
        }
        return dist;
    }
}