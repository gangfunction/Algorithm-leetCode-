class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int[][] adjacencyMatrix = new int[n][n];
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyMatrix[from][to] = 1;
            adjacencyMatrix[to][from] = 1; // Assuming the graph is undirected
        }

        int connectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjacencyMatrix, i, visited);
                connectedComponents++;
            }
        }

        return connectedComponents;
    }

    private void dfs(int[][] adjacencyMatrix, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            if (adjacencyMatrix[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(adjacencyMatrix, neighbor, visited);
            }
        }
    }
}