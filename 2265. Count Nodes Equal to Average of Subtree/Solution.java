class Solution {
    int cnt=0;
    public int averageOfSubtree(TreeNode root){
        dfs(root);
        return cnt;
    }

    private int[] dfs(TreeNode root){
        if(root==null) return new int[]{0,0};
        int sum=0;
        int size=0;
        int[] left = dfs(root.left); 
        int[] right = dfs(root.right);
        sum = left[0]+right[0]+root.val;
        size = left[1]+right[1]+1;
        if(root.val == sum/size) cnt++;
        return new int[]{sum,size};
    }
}