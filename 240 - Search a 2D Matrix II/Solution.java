class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int i = matrix.length - 1;
        int j = 0;
        
        while (i >= 0 && j < matrix[0].length) {
            System.out.println(i + ", " + j);
            if (target == matrix[i][j])
                return true;
            else if (target < matrix[i][j])
                i--;
            else
                j++;
        }
        
        return false;
    }
}