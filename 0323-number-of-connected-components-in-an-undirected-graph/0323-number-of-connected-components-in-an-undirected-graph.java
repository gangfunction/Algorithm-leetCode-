class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        // Initialize each node as a separate component
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        int connectedComponents = n; // Initialize to n components

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            int root1 = find(parent, from);
            int root2 = find(parent, to);
            
            if (root1 != root2) {
                // Union by rank
                if (rank[root1] < rank[root2]) {
                    parent[root1] = root2;
                } else if (rank[root1] > rank[root2]) {
                    parent[root2] = root1;
                } else {
                    parent[root1] = root2;
                    rank[root2]++;
                }
                
                connectedComponents--; // Reduce the number of components
            }
        }

        return connectedComponents;
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        // Path compression
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
