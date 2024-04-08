import java.util.HashSet;

public class LC_36_valid_sudoku {
    static class Solution {
        public boolean checkRow(int r, char[][] board) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j=0; j<9; j++) {
                if (board[r][j]!='.') {
                    if (set.contains(board[r][j])) {
                        return false;
                    } else {
                        set.add(board[r][j]);
                    }
                }
            }
            return true;
        }

        public boolean checkCol(int c, char[][] board) {
            HashSet<Character> set = new HashSet<Character>();
            for (int i=0; i<9; i++) {
                if (board[i][c]!='.') {
                    if (set.contains(board[i][c])) {
                        return false;
                    } else {
                        set.add(board[i][c]);
                    }
                }
            }
            return true;
        }

        public boolean checkSubBox(int r, int c, char[][] board) {
            int dR[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
            int dC[] = {-1, 0, 1, -1,0, 1, -1, 0, 1};
            HashSet<Character> set = new HashSet<Character>();
            for (int k=0; k<9; k++) {
                int nextR = r + dR[k];
                int nextC = c + dC[k];

                if (board[nextR][nextC]!='.') {
                    if (set.contains(board[nextR][nextC])) {
                        return false;
                    } else {
                        set.add(board[nextR][nextC]);
                    }
                }
            }
            return true;
        }

        public boolean isValidSudoku(char[][] board) {
            for (int r=0; r<9; r++) {
                if (!checkRow(r,board)) {
                    return false;
                }
            }

            for (int c=0; c<9; c++) {
                if (!checkCol(c,board)) {
                    return false;
                }
            }

            int startR[] = {1,1,1,4,4,4,7,7,7};
            int startC[] = {1,4,7,1,4,7,1,4,7};
            for (int i=0; i<9; i++) {
                if (!checkSubBox(startR[i],startC[i],board)) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        LC_36_valid_sudoku.Solution sol = new LC_36_valid_sudoku.Solution();
        System.out.println(sol.isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}}));
    }
}
