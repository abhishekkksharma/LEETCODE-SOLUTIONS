class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] arr={0,0};
        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1) count++;
            }
            if(count>arr[1]){
                arr[0] = i;
                arr[1] = count;
            }
        }
        return arr;
    }
}