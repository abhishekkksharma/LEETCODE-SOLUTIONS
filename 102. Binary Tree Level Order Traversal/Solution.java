class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); 
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> currLevelList = new ArrayList<>(); 
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode currNode = q.poll();
                currLevelList.add(currNode.val);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            result.add(currLevelList);

        }

        return result;
    }
}