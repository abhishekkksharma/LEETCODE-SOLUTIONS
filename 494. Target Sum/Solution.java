class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        // the sum can range from -6 to 6 thus we need to add the offset(total) 
        // to make indices positive 
        // -6 -> 0, -5 -> 1,... 6 -> 12 
        Integer[][] dp = new Integer[n][2 * total + 1];
        return solve(nums, 0, 0, target, dp, total);
    }

    private int solve(int[] nums, int idx, int sum, int target, Integer[][] dp, int offset) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (dp[idx][sum + offset] != null) {
            return dp[idx][sum + offset];
        }
        int plus = solve(nums, idx + 1, sum + nums[idx],target, dp, offset);
        int minus = solve(nums, idx + 1, sum - nums[idx], target, dp, offset);
        return dp[idx][sum + offset] = plus + minus;
    }
}