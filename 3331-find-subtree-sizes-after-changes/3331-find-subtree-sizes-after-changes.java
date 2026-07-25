class Solution {

    List<Integer>[] tree;
    List<Integer>[] newTree;

    int[] parent;
    int[] newParent;
    int[] ans;

    Stack<Integer>[] last;

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        this.parent = parent;

        tree = new ArrayList[n];
        newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++)
            tree[parent[i]].add(i);

        newParent = new int[n];
        newParent[0] = -1;

        last = new Stack[26];

        for (int i = 0; i < 26; i++)
            last[i] = new Stack<>();

        dfs1(0, s);

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        ans = new int[n];

        dfs2(0);

        return ans;
    }

    private void dfs1(int node, String s) {

        int c = s.charAt(node) - 'a';

        if (node != 0) {

            if (!last[c].isEmpty())
                newParent[node] = last[c].peek();
            else
                newParent[node] = parent[node];
        }

        last[c].push(node);

        for (int child : tree[node])
            dfs1(child, s);

        last[c].pop();
    }

    private int dfs2(int node) {

        int size = 1;

        for (int child : newTree[node])
            size += dfs2(child);

        ans[node] = size;

        return size;
    }
}