class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int topRow = 0, bottomRow = n - 1;
        int leftCol = 0, rightCol = n - 1;
        int num = 1;
        
        while (topRow <= bottomRow && leftCol <= rightCol) {
            for (int col = leftCol; col <= rightCol; col++) {
                matrix[topRow][col] = num++;
            }
            for (int row = topRow + 1; row <= bottomRow; row++) {
                matrix[row][rightCol] = num++;
            }
            if (topRow < bottomRow && leftCol < rightCol) {
                for (int col = rightCol - 1; col >= leftCol; col--) {
                    matrix[bottomRow][col] = num++;
                }
                for (int row = bottomRow - 1; row > topRow; row--) {
                    matrix[row][leftCol] = num++;
                }
            }
            
            topRow++; bottomRow--; leftCol++; rightCol--; 
        }
        
        return matrix;
    }
}