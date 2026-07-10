class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        //top row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && visited[0][i]==0){
                dfs(board,visited,0,i);
            }
            //check bottom row
            if(board[n-1][i]=='O' && visited[n-1][i]==0){
                dfs(board,visited,n-1,i);
            }
        }
        //check left col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && visited[i][0]==0){
                dfs(board,visited,i,0);
            }
            //check right col
            if(board[i][m-1]=='O' && visited[i][m-1]==0){
                dfs(board,visited,i,m-1);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(char[][] board,int[][] visited,int r,int c){
        visited[r][c]=1;
        int[][] dir={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        for(int i=0;i<4;i++){
            int x=r+dir[i][0];
            int y=c+dir[i][1];
            if(x>=0 && x<board.length &&
            y>=0 && y<board[0].length && 
            board[x][y]=='O' && visited[x][y]==0){
                dfs(board,visited,x,y);
            }
        }
    }
}