class Solution {
    int max=0;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return 1+Math.max(max,Math.max(maxDepth(root.left),maxDepth(root.right)));
    }
}