class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean direction=true;
        while(!q.isEmpty()){
            int levelSize=q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr = q.remove();
                temp.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }    
            if(direction){
                result.add(temp);
                direction=false;
            }else{
                Collections.reverse(temp);
                result.add(temp);
                direction=true;
            }
        }
        return result;
    }
}