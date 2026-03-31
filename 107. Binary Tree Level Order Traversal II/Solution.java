class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int levelSize=q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode curr = q.remove();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            result.add(0,temp);
        }
        return result;
    }
}