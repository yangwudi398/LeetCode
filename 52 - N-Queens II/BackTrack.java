class Solution {
    public int totalNQueens(int n) {
        return getNumQueens(new boolean[n][n], n, 0);
    }
    
    private int getNumQueens(boolean[][] board, int n, int row) {
        if (row >= n)
            return 1;
        
        int numValid = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(board, n, row, col)) {
                board[row][col] = true;
                numValid += getNumQueens(board, n, row + 1);
                board[row][col] = false;
            }
        }
        return numValid;
    }
    
    private boolean isValid(boolean[][] board, int n, int row, int col) {
        for (int i = 0; i < n; i++) 
            if (board[i][col]) 
                return false;
        
        int i = row, j = col;
        while (i >= 0 && j >= 0) 
            if (board[i--][j--])
                return false;
        
        i = row; j = col;
        while (i >= 0 && j < n)
            if (board[i--][j++])
                return false;
        
        i = row; j = col;
        while (i < n && j >= 0)
            if (board[i++][j--])
                return false;
        
        i = row; j = col;
        while (i < n && j < n)
            if (board[i++][j++])
                return false;
        
        return true;
    }
}