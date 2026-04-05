class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        int count=0;
        if(root==null) return -1;
        helper(root,k,q);
        TreeNode ans = null;
        while(!q.isEmpty() && k>0){
            ans=q.poll();
            k--;
        }
        return ans!=null ? ans.val:-1;
    }
    private void helper(TreeNode root, int k,Queue<TreeNode> q){
        if(root==null) return;
        helper(root.left,k,q);
        q.add(root);
        helper(root.right,k,q);
    }
}