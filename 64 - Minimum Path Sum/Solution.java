class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int[][] minSums = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                minSums[i][j] = -1;
        
        navigate(grid, minSums, 0, 0, 0);
        
        return minSums[m-1][n-1];
    }
    
    private void navigate(int[][] grid, int[][] minSums, int currSum, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i >= m || j >= n)
            return;
        
        currSum += grid[i][j];
            
        if (minSums[i][j] == -1 || currSum < minSums[i][j]) {
            minSums[i][j] = currSum;
            navigate(grid, minSums, currSum, i + 1, j);
            navigate(grid, minSums, currSum, i, j + 1);
        }
    }
}