class Solution {
    class Pair {
        int node;
        int dist;
        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];
            adj.get(u).add(new Pair(d, v));
            adj.get(v).add(new Pair(d, u));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if (d > dist[node]) continue;

            for (Pair nbr : adj.get(node)) {
                long newDist = d + nbr.dist;

                if (newDist < dist[nbr.node]) {
                    dist[nbr.node] = newDist;
                    ways[nbr.node] = ways[node];
                    pq.offer(new long[]{newDist, nbr.node});
                } else if (newDist == dist[nbr.node]) {
                    ways[nbr.node] = (ways[nbr.node] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}