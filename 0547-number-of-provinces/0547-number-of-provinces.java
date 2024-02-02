class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int provinces = n;
        
        // 초기화: 각 도시의 부모를 자기 자신으로 설정
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int root1 = find(parent, i);
                    int root2 = find(parent, j);
                    
                    // 두 도시가 서로 다른 그룹에 속해 있으면 합친다
                    if (root1 != root2) {
                        parent[root1] = root2;
                        provinces--;
                    }
                }
            }
        }
        
        return provinces;
    }
    
    // Union-Find에서 루트를 찾는 메서드
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        // 경로 압축(Path Compression)을 통해 루트를 찾음
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}