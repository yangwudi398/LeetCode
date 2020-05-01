class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set = new HashSet<>(9);
        
        // Check rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    if (set.contains(num)) return false;
                    else set.add(num);
                }
            }
            set.clear();
        }
        
        // Check columns
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    if (set.contains(num)) return false;
                    else set.add(num);
                }
            }
            set.clear();
        }
        
        // Check subboards
        for (int row = 0; row <= 6; row += 3) {
            for (int col = 0; col <= 6; col += 3) {
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.') {
                            int num = Character.getNumericValue(board[i][j]);
                            if (set.contains(num)) return false;
                            else set.add(num);
                        }
                    }
                }
                set.clear();
            }
        }
        
        return true;
    }
}