class Solution {
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     if(root==null) return false;
    //     q.add(root);
    //     int level=0;
    //     while(!q.isEmpty()){
    //         int levelSize=q.size();
    //         Set<Integer> set = new HashSet<>();
    //         for(int i=0;i<levelSize;i++){
    //             TreeNode curr = q.poll();
    //             set.add(curr.val);
    //             if(curr.left!=null) q.add(curr.left);
    //             if(curr.right!=null) q.add(curr.right);
    //         }
    //         if(set.contains(x) && set.contains(y) && !isSiblings(root,x,y)) return true;
    //         level++;
    //     }
    //     return false;
    // }
    // private boolean isSiblings(TreeNode root,int x,int y){
    //     if(root==null) return false;
    //     if(root.left==null || root.right==null) return false;
    //     if( (root.left.val==x && root.right.val==y) ||  (root.left.val==y && root.right.val==x)){
    //         return true;
    //     }
    //     boolean left = isSiblings(root.left,x,y);
    //     boolean right = isSiblings(root.right,x,y);
    //     return left || right;
    // }

    // optimal approach 
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int levelSize=q.size();
            boolean foundx=false;
            boolean foundy=false;
            for(int i=0;i<levelSize;i++){
                TreeNode curr = q.remove();
                if(curr.left!=null && curr.right!=null){
                    //find if siblings
                    if( (curr.left.val==x && curr.right.val==y) ||  
                    (curr.left.val==y && curr.right.val==x)) return false;
                }
                if(curr.val==x) foundx=true;
                if(curr.val==y) foundy=true;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(foundx && foundy) return true;
            if(foundx || foundy) return false;
        }
        return false;
    }
}