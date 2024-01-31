class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Perform BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) {
                return true;
            }
            
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                
                // Check if the edge connects to the current node and the other end is unvisited
                if (u == current && v != -1) {
                    queue.offer(v);
                    edges[i][0] = -1; // Mark visited edge
                } else if (v == current && u != -1) {
                    queue.offer(u);
                    edges[i][1] = -1; // Mark visited edge
                }
            }
        }
        
        return false;
    }
}