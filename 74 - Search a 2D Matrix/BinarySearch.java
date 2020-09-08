class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int x1 = 0; // lower bound
        int x2 = m - 1; // upper bound
        int y1 = 0; // left bound
        int y2 = n - 1; // right bound
        int midX = 0;
        int midY = 0;
        
        while (x1 <= x2) {
            midX = (x1 + x2) / 2;
            
            if (matrix[midX][n-1] < target) // narrow lower bound
                x1 = midX + 1;
            else if (matrix[midX][0] > target) // narrow upper bound
                x2 = midX - 1;
            else { // target in the range of current row
                while (y1 <= y2) { // normal binary search
                    midY = (y1 + y2) / 2;
                    
                    if (matrix[midX][midY] < target)
                        y1 = midY + 1;
                    else if (matrix[midX][midY] > target)
                        y2 = midY - 1;
                    else 
                        return true;
                }
                return false;
            }
        }
        return false;
    }
}