class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> q1 = new ArrayList<>();
        ArrayList<Integer> q2 = new ArrayList<>();
        helper(root1,q1);
        helper(root2,q2);
        return q1.equals(q2);
    }
    private void helper(TreeNode root, ArrayList<Integer> q){
        if(root==null) return;
        if(root.left==null && root.right==null){
            q.add(root.val);
        }
        helper(root.left,q);
        helper(root.right,q);
    }
}