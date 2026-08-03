class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try every cell as the starting position
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // We matched every character in the word
        if (index == word.length()) {
            return true;
        }

        // Invalid position or character does not match
        if (row < 0 || col < 0
                || row >= board.length
                || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark this cell as visited
        char originalCharacter = board[row][col];
        board[row][col] = '#';

        // Search in all four directions
        boolean found =
                dfs(board, word, row + 1, col, index + 1)
                || dfs(board, word, row - 1, col, index + 1)
                || dfs(board, word, row, col + 1, index + 1)
                || dfs(board, word, row, col - 1, index + 1);

        // Restore the cell while backtracking
        board[row][col] = originalCharacter;

        return found;
    }
}