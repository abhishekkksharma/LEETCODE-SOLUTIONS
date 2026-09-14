class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int max = 1;
        int lastIndex = 0;
        int n=nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);

        // DP + parent/hash array
        for (int i = 0; i < n; i++) {
            hash[i] = i; // initially, parent of itself

            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev]==0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            // Track the longest subsequence
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        // Reconstruct LIS
        ArrayList<Integer> list = new ArrayList<>();
        while (hash[lastIndex] != lastIndex) {
            list.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }

        list.add(nums[lastIndex]);
        // Currently reconstructed backwards
        Collections.reverse(list);
        return list;
    }
}