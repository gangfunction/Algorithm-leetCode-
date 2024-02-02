class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from); // Assuming the graph is undirected
        }

        boolean[] visited = new boolean[n];
        int connectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adjacencyList, i, visited);
                connectedComponents++;
            }
        }

        return connectedComponents;
    }

    private void dfs(List<List<Integer>> adjacencyList, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, neighbor, visited);
            }
        }
    }
}
