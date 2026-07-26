class Solution {

    class DSU {

        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {

            int pa = find(a);
            int pb = find(b);

            if (pa == pb)
                return;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        DSU dsu = new DSU(n);

        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < n; i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {

                String email = account.get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    dsu.union(i, emailToAccount.get(email));
                }
            }
        }

        Map<Integer, TreeSet<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int root = dsu.find(i);

            map.putIfAbsent(root, new TreeSet<>());

            for (int j = 1; j < accounts.get(i).size(); j++) {
                map.get(root).add(accounts.get(i).get(j));
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for (int root : map.keySet()) {

            List<String> list = new ArrayList<>();

            list.add(accounts.get(root).get(0));

            list.addAll(map.get(root));

            ans.add(list);
        }

        return ans;
    }
}