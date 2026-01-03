class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        transpose(matrix);
        for(int i=0;i<n;i++){
            int start=0;
            int last=n-1;
            while(start<last){
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][last];
                matrix[i][last]=temp;
                start++;
                last--;
            }
        }
    }
    private void transpose(int[][] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
}