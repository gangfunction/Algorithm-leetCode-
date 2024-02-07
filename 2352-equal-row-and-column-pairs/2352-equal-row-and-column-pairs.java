class Solution {
    public int equalPairs(int[][] grid) {
        int[][] transposed = transpose(grid);
        int count =0;

        for(int i =0; i< grid.length; i++){
            for(int j =0; j<grid.length; j++){
                if(Arrays.equals(grid[i],transposed[j])){
                    count++;
                }
            }
        }
        return count;
        
    }
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;        // Number of rows in the original matrix
        int n = matrix[0].length;     // Number of columns in the original matrix
        int[][] transposed = new int[n][m];  // New transposed matrix

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}