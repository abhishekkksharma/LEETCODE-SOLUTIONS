class Solution {
    class Data {
        int diff, row, col;
        Data(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Data> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        pq.offer(new Data(0, 0, 0));

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {
            Data curr = pq.poll();
            int diff = curr.diff;
            int row = curr.row;
            int col = curr.col;
            if (diff > dist[row][col]) continue;
            for (int[] d : dir) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;
                int newDiff = Math.max(
                    diff,
                    Math.abs(heights[row][col] - heights[newRow][newCol])
                );

                if (newDiff < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newDiff;
                    pq.offer(new Data(newDiff, newRow, newCol));
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}