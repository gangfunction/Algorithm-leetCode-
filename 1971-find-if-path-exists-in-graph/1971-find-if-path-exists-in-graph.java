class Solution {
    private int[] parent;

    private int find(int x) {
        if (parent[x] == -1) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int rootU = find(u);
            int rootV = find(v);
            if (rootU != rootV) {
                parent[rootU] = rootV;
            }
        }

        return find(source) == find(destination);
    }
}