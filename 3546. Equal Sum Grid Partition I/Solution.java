class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] hSum = new long[m];
        long[] vSum = new long[n];

        // row prefix sums
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
            hSum[i] = sum;
            if (i > 0) hSum[i] += hSum[i - 1];
        }

        // column prefix sums (FIXED)
        for (int j = 0; j < n; j++) {
            long sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
            }
            vSum[j] = sum;
            if (j > 0) vSum[j] += vSum[j - 1];
        }

        // check horizontal cut
        long total = hSum[m - 1];
        for (int i = 0; i < m - 1; i++) {
            if (hSum[i] == total - hSum[i]) return true;
        }

        // check vertical cut
        long vTotal = vSum[n - 1];
        for (int j = 0; j < n - 1; j++) {
            if (vSum[j] == vTotal - vSum[j]) return true;
        }

        return false;
    }
}