class Solution {
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode node){
        if(node==null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        diameter = Math.max(diameter, leftH+rightH);
        return Math.max(leftH,rightH)+1;
    }
}