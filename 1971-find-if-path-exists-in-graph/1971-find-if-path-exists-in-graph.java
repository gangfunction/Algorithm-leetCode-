import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        
        // Perform BFS using HashSet to store visited nodes
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(source);
        visited.add(source);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }
            
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return false;
    }
}