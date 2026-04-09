public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString().trim();
    }
    private void helper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null");
            sb.append(" ");
            return;
        }
        sb.append(Integer.toString(root.val));
        sb.append(" ");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    int index;
    public TreeNode deserialize(String data) {
        String[] values = data.split(" ");
        index=0;
        return helper2(values);
    }
    private TreeNode helper2(String[] values){
        if(index >= values.length || values[index].equals("null")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index++]));
        node.left = helper2(values);
        node.right = helper2(values);
        return node;
    }
}
