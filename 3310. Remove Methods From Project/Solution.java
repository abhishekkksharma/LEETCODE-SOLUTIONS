class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < invocations.length; i++) {
            int a = invocations[i][0];
            int b = invocations[i][1];

            adj.get(a).add(b);
        }

        int[] visited = new int[n];
        dfs(adj, k, visited);
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                for (int node : adj.get(i)) {
                    if (visited[node] == 1) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        for (int j = 0; j < n; j++) {
                            ans.add(j);
                        }
                        return ans;
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj,
                     int node,
                     int[] visited) {

        visited[node] = 1;

        for (int nbr : adj.get(node)) {
            if (visited[nbr] == 0) {
                dfs(adj, nbr, visited);
            }
        }
    }
}