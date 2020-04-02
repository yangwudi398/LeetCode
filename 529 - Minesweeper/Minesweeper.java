class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        revealBoard(board, click[0], click[1]);
        return board;
    }
    
    public void revealBoard(char[][] board, int i, int j) {
        if (board[i][j] == 'M')
            board[i][j] = 'X';
        else {
            int nrow = board.length;
            int ncol = board[0].length;
            int count = 0;
            for (int x = i - 1; x <= i + 1; x++)
                for (int y = j - 1; y <= j + 1; y++) 
                    if (x >= 0 && x < nrow && y >= 0 && y < ncol)
                        if (board[x][y] == 'M')
                            count++;
            if (count == 0) {
                board[i][j] = 'B';
                for (int x = i - 1; x <= i + 1; x++)
                    for (int y = j - 1; y <= j + 1; y++)
                        if (x >= 0 && x < nrow && y >= 0 && y < ncol)
                            if (board[x][y] == 'E')
                                revealBoard(board, x, y);
            } else {
                board[i][j] = (char)('0' + count);
            }
        }
    }
}