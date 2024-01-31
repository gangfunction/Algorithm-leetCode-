class Solution {
    private int[] parent;
    private int[] size;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            // Union with path compression
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            while (y != parent[y]) {
                parent[y] = parent[parent[y]];
                y = parent[y];
            }

            // Union by size
            if (x != y) {
                if (size[x] < size[y]) {
                    parent[x] = y;
                    size[y] += size[x];
                } else {
                    parent[y] = x;
                    size[x] += size[y];
                }
            }
        }

        // Final find with path compression
        while (source != parent[source]) source = parent[source];
        while (destination != parent[destination]) destination = parent[destination];

        return source == destination;
    }
}