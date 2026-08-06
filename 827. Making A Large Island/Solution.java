import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[][] dir = {
            {1, 0},
            {0, 1},
            {0, -1},
            {-1, 0}
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int idx = 0; idx < 4; idx++) {
                    int newR = i + dir[idx][0];
                    int newC = j + dir[idx][1];
                    if (newR >= 0 && newR < n &&
                        newC >= 0 && newC < n &&
                        grid[newR][newC] == 1) {
                        int nodeNo = i * n + j;
                        int adjNode = newR * n + newC;
                        ds.unionBySize(nodeNo, adjNode);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                HashSet<Integer> components = new HashSet<>();
                for (int idx = 0; idx < 4; idx++) {
                    int newR = i + dir[idx][0];
                    int newC = j + dir[idx][1];
                    if (newR >= 0 && newR < n &&
                        newC >= 0 && newC < n &&
                        grid[newR][newC] == 1) {
                        int parent = ds.findUltimateParent(newR * n + newC);
                        components.add(parent);
                    }
                }

                int totalSize = 1;

                for (int parent : components) {
                    totalSize += ds.size.get(parent);
                }

                max = Math.max(max, totalSize);
            }
        }

        // Step 3: Handles case where grid is already all 1s
        for (int node = 0; node < n * n; node++) {
            int parent = ds.findUltimateParent(node);
            max = Math.max(max, ds.size.get(parent));
        }

        return max;
    }


    class DisjointSet {
        List<Integer> parent;
        List<Integer> size;

        public DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent.get(node))
                return node;

            int ultimateParent =
                findUltimateParent(parent.get(node));

            parent.set(node, ultimateParent);

            return ultimateParent;
        }

        public void unionBySize(int u, int v) {
            int parentU = findUltimateParent(u);
            int parentV = findUltimateParent(v);

            if (parentU == parentV)
                return;

            if (size.get(parentU) < size.get(parentV)) {

                parent.set(parentU, parentV);

                size.set(
                    parentV,
                    size.get(parentV) + size.get(parentU)
                );

            } else {

                parent.set(parentV, parentU);

                size.set(
                    parentU,
                    size.get(parentU) + size.get(parentV)
                );
            }
        }
    }
}