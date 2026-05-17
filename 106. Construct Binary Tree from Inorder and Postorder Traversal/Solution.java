/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        int index=0;
        for(int i=0;i<postorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }

        root.left=buildTree(Arrays.copyOfRange(inorder,0,index),
        Arrays.copyOfRange(postorder,0,index));

        root.right=buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),
        Arrays.copyOfRange(postorder,index,postorder.length-1));
        
        return root;
    }
}