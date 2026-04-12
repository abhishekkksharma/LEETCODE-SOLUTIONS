class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        long ans = dfs(root, min);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private long dfs(TreeNode node, int min) {
        if (node == null) return Long.MAX_VALUE;

        if (node.val > min) return node.val;

        long left = dfs(node.left, min);
        long right = dfs(node.right, min);

        return Math.min(left, right);
    }
}