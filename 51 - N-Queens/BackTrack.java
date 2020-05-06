class Solution {
    private List<List<String>> solutions = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        getQueens(board, n, 0);
        return solutions;
    }
    
    private void getQueens(boolean[][] board, int n, int row) {
        if (row >= n) { // n queens have been put
            List<String> solution = toList(board, n);
            solutions.add(toList(board, n));
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) { // this position is currently valid
                board[row][col] = true;
                getQueens(board, n, row + 1);
                board[row][col] = false;
            }
        }
    }
    
    private boolean isValid(boolean[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < n; i++) 
            if (board[i][col]) 
                return false;
        // Check upper-left diagonal
        int i = row, j = col;
        while (i >= 0 && j >= 0) 
            if (board[i--][j--]) 
                return false;
        // Check upper-right diagonal
        i = row; j = col;
        while (i >= 0 && j < n)
            if (board[i--][j++])
                return false;
        // Check lower-left diagonal
        i = row; j = col;
        while (i < n && j >= 0) 
            if (board[i++][j--])
                return false;
        // Check lower-right diagonal
        i = row; j = col;
        while (i < n && j < n)
            if (board[i++][j++])
                return false;
        return true;
    }
    
    private List<String> toList(boolean[][] board, int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }
            list.add(row.toString());
        }
        return list;
    }
}