class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        boolean toUpRight = true;
        int[] coord = new int[]{0, 0, 0};
        int m = matrix.length;
        if (m == 0)
            return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        
        while (true) {
            upRight(matrix, res, coord);
            if (coord[0] == m - 1 && coord[1] == n - 1)
                break;
            coord[1] += 1;
            
            downLeft(matrix, res, coord);
            if (coord[0] == m - 1 && coord[1] == n - 1)
                break;
            coord[0] += 1;
        }
        
        return res;
    }
    
    private void upRight(int[][] matrix, int[] res, int[] coord) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = coord[0];
        int j = coord[1];
        int num = coord[2];
        
        while (i >= 0) {
            if (i < m && j >= 0 && j < n) {
                res[num] = matrix[i][j];
                coord[0] = i;
                coord[1] = j;
                coord[2] = ++num;
            }
            
            if (i == m - 1 && j == n - 1)
                break;
            
            i--;
            j++;
        }
    }
    
    private void downLeft(int[][] matrix, int[] res, int[] coord) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = coord[0];
        int j = coord[1];
        int num = coord[2];
        
        while (j >= 0) {
            if (i >= 0 && i < m && j < n) {
                res[num] = matrix[i][j];
                coord[0] = i;
                coord[1] = j;
                coord[2] = ++num;
            }
            
            if (i == m - 1 && j == n -1)
                break;
            
            i++;
            j--;
        }
    }
}