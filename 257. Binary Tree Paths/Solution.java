class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root,"",list);
        return list;
    }
    private void helper(TreeNode root, String path,List<String> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            path+=root.val;
            list.add(path);
        }
        else path+=root.val+"->";
        helper(root.left,path,list);
        helper(root.right,path,list);
    }
}