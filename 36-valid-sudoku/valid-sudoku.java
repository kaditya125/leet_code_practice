import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    
                    if (!set.add("row" + i + current) || !set.add("col" + j + current)) {
                        return false;
                    }
                    if (!set.add("box" + (i / 3) + "-" + (j / 3) + current)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
