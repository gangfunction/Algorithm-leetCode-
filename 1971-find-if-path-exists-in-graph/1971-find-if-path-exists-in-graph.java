class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];
        
        for(int[] edge: edges){
            int a = edge[0], b= edge[1];
            //a는 edge[0] edge[2] ...
            //b는 edge[1] edge[3] ...
            
            //edge[0] edge[1] edge[2] edge[3]
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            //edge[1] edge[0] edge[3] edge[2]
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
            
        }
        return dfs(graph,seen, source, destination);        
    }
    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination){
        if(currNode == destination){
            return true;
        }
        if(!seen[currNode]){
            seen[currNode] =true;
            for( int nextNode: graph.get(currNode)){
                if(dfs(graph,seen,nextNode,destination)){
                    return true;
                }
            }
        }
        return false;
        
    }

}