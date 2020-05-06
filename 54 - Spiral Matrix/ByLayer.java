class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0) return spiral;
        
        int topRow = 0;
        int bottomRow = matrix.length - 1;
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;
        
        // If the matrix is at least 1-dimensional
        while (topRow <= bottomRow && leftCol <= rightCol) {
            for (int col = leftCol; col <= rightCol; col++) 
                spiral.add(matrix[topRow][col]);
            for (int row = topRow + 1; row <= bottomRow; row++) 
                spiral.add(matrix[row][rightCol]);
            // If inner matrix is still 2-dimentional
            if (topRow < bottomRow && leftCol < rightCol) {
                for (int col = rightCol - 1; col >= leftCol; col--) 
                    spiral.add(matrix[bottomRow][col]);
                for (int row = bottomRow - 1; row > topRow; row--) 
                    spiral.add(matrix[row][leftCol]);
            }
            
            topRow += 1;
            bottomRow -= 1;
            leftCol += 1;
            rightCol -= 1;
        }
        
        return spiral;   
    }
}