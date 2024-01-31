class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }
            
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                
                if (u == current && !visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                } else if (v == current && !visited[u]) {
                    queue.offer(u);
                    visited[u] = true;
                }
            }
        }
        
        return false;
    }
}