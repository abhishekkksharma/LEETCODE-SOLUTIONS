class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode leftMost=null;
        q.offer(root);
        while(!q.isEmpty()){
            leftMost=q.poll();
            if(leftMost.right!=null) q.offer(leftMost.right);
            if(leftMost.left!=null) q.offer(leftMost.left);
        }
        return leftMost.val;
    }
}