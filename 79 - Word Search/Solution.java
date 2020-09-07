class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;       
        
        if (board.length == 0)
            return false;
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        
        for (int i = 0; i < m; i++ ) 
            for (int j = 0; j < n; j++) 
                if (isMatch(board, word, 0, used, i, j))
                    return true;
        return false;
    }
    
    private boolean isMatch(char[][] board, String word, int curr, boolean[][] used, int i, int j) {
        if (curr >= word.length())
            return true;
        
        if (!isValid(board, i, j))
            return false;
        
        if (used[i][j]) 
            return false;
                
        if (word.charAt(curr) == board[i][j]) {
            used[i][j] = true;
            
            boolean matched = isMatch(board, word, curr + 1, used, i - 1, j) || 
                isMatch(board, word, curr + 1, used, i + 1, j) ||
                isMatch(board, word, curr + 1, used, i, j - 1) ||
                isMatch(board, word, curr + 1, used, i, j + 1);
            
            used[i][j] = false;
            return matched;
        }
        
        return false;
    }
    
    private boolean isValid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        
        if (i >= 0 && i < m && j >= 0 && j < n)
            return true;
        return false;
    }
}