class Solution {
    class Data{
        int dist;
        int row;
        int col;
        Data(int d,int r,int c){
            this.dist=d;
            this.row=r;
            this.col=c;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;

        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);

        Queue<Data> q=new LinkedList<>();
        q.add(new Data(1,0,0)); //src
        dist[0][0]=1;

        int[][] dir={
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1},
        };
        while(!q.isEmpty()){
            Data curr=q.poll();
            int oldDist=curr.dist;
            int row=curr.row;
            int col=curr.col;
            for(int i=0;i<8;i++){
                int newRow=row+dir[i][0];
                int newCol=col+dir[i][1];
                if(newRow>=0 && newRow<n 
                && newCol>=0 && newCol<m && grid[newRow][newCol]!=1 
                && oldDist+1<dist[newRow][newCol]){
                    dist[newRow][newCol]=oldDist+1;
                    q.add(new Data(oldDist+1,newRow,newCol));
                }
            }
        }
        if(dist[n-1][m-1]==Integer.MAX_VALUE) return -1;
        return dist[n-1][m-1];
    }
}