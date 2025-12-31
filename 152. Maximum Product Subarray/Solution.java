class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int pref = 1, suff = 1;

        for (int i = 0; i < n; i++) {
            pref *= nums[i];
            suff *= nums[n - i - 1];
            maxProd = Math.max(maxProd, Math.max(pref, suff));

            if (pref == 0) pref = 1;
            if (suff == 0) suff = 1;
        }

        return maxProd;
    }
}