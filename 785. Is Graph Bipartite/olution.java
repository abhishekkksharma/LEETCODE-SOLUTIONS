import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!bfs(adj, visited, i)) return false;
            }
        }
        return true;
    }

    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : adj.get(curr)) {
                int color = visited[curr]==0? 1:0;
                if (visited[neighbor] == -1) {
                    visited[neighbor] = color;
                    q.offer(neighbor);
                } else if (visited[neighbor] == visited[curr]) {
                    return false;
                }
            }
        }
        return true;
    }
}