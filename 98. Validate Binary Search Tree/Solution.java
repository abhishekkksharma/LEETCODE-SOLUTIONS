class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}