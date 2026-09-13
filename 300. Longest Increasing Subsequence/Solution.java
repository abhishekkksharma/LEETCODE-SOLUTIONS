class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int[][] dp=new int[n][n+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(nums,0,-1,dp);
        // return tabuOptimized(nums, n);
        return binarySol(nums, n);
    }

    private int helper(int[] nums, int i, int prevI, int[][] dp) {
        if (i == nums.length)
            return 0;
        if (dp[i][prevI + 1] != -1)
            return dp[i][prevI + 1];
        int ans = 0;
        // not take
        ans = 0 + helper(nums, i + 1, prevI, dp);
        // take
        if (prevI == -1 || nums[i] > nums[prevI]) {
            ans = Math.max(ans, 1 + helper(nums, i + 1, i, dp));
        }
        return dp[i][prevI + 1] = ans;
    }

    private int tabu(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int ans = 0;
                // not take
                ans = 0 + dp[i + 1][prev + 1];
                // take
                if (prev == -1 || nums[i] > nums[prev]) {
                    ans = Math.max(ans, 1 + dp[i + 1][i + 1]);
                }
                dp[i][prev + 1] = ans;
            }
        }
        return dp[0][0];
    }

    private int tabuOptimized(int[] nums, int n) {
        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    private int binarySol(int[] nums, int n) {
        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int idx = binarySearch(temp, nums[i]);
                temp.set(idx, nums[i]);
            }
        }
        return temp.size();
    }

    private int binarySearch(ArrayList<Integer> temp, int target) {
        int l = 0;
        int r = temp.size() - 1;
        int ans = temp.size();

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (temp.get(mid) >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}