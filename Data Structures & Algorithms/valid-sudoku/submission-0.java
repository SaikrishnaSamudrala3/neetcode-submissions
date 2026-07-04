class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> st = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if ( board[i][j] == '.') {
                    continue;
                }

                String row = board[i][j] + "ROW" + i;
                String col = board[i][j] + "COL" + j;
                String box = board[i][j] + "BOX" + (i / 3) + "-" + (j / 3);

                if (st.contains(row) || st.contains(col) || st.contains(box)) {
                    return false;
                }

                st.add(row);
                st.add(col);
                st.add(box);
            }
        }
        return true;
    }
}
