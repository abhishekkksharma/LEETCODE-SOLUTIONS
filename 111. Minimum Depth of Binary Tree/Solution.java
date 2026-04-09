class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        // if(root.left==null) return 1+minDepth(root.right);
        // if(root.right==null) return 1+minDepth(root.left);
        // return 1+Math.min(minDepth(root.left),minDepth(root.right));
        Queue<TreeNode> q = new LinkedList<>();
        int depth=1;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize=q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode curr = q.poll();
                if(curr.left==null && curr.right==null) return depth;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }
}