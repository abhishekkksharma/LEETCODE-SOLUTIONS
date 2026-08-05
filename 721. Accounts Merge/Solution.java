import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        HashMap<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);

        // Step 1: Map emails to account index and union common emails
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);

                if (map.containsKey(mail)) {
                    ds.unionByRank(i, map.get(mail));
                } else {
                    map.put(mail, i);
                }
            }
        }

        // Step 2: Create array for merged emails
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        // Step 3: Put each email under its ultimate parent
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = it.getValue();

            int parent = ds.findUltimateParent(node);

            mergedMail[parent].add(mail);
        }

        // Step 4: Create final answer
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (mergedMail[i].isEmpty()) {
                continue;
            }

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();

            // Add account name
            temp.add(accounts.get(i).get(0));

            // Add emails
            temp.addAll(mergedMail[i]);

            ans.add(temp);
        }

        return ans;
    }

    class DisjointSet {
        private List<Integer> rank;
        private List<Integer> parent;

        public DisjointSet(int n) {
            rank = new ArrayList<>();
            parent = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent =
                findUltimateParent(parent.get(node));

            parent.set(node, ultimateParent);

            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int upl_u = findUltimateParent(u);
            int upl_v = findUltimateParent(v);

            if (upl_u == upl_v) {
                return;
            }

            if (rank.get(upl_u) < rank.get(upl_v)) {

                parent.set(upl_u, upl_v);

            } else if (rank.get(upl_v) < rank.get(upl_u)) {

                parent.set(upl_v, upl_u);

            } else {

                parent.set(upl_v, upl_u);

                rank.set(
                    upl_u,
                    rank.get(upl_u) + 1
                );
            }
        }
    }
}