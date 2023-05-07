package strivers.arrays.practice;

import java.util.Arrays;

public class SudokuSolver {

    final int cells = 9;

    public static void main(String[] args) {
        SudokuSolver sol = new SudokuSolver();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        char[][] board = new char[][]{
//                {'5','3','4','6','7','8','9','1','2'},
//                {'6','7','2','1','9','5','3','4','8'},
//                {'1','9','8','3','4','2','5','6','7'},
//                {'8','5','9','7','6','1','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };

        sol.solveSudoku(board);

        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int x, int y) {
        if (x % 3 == 2 && y % 3 == 0 && !isValid9x9(board, x - 2, y - 3)) return false;
        if (y == 9) {
            y = 0;
            x++;
        }
        if (x == 9) return true;
        if (board[x][y] != '.') return solve(board, x, y + 1);
        else {
            for (int i = 1; i <= cells; i++) {
                if (isValid(board, x, y, i)) {
                    board[x][y] = (char) (i + '0');
                    if (solve(board, x, y + 1)) return true;
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }

    private boolean isValid9x9(char[][] board, int row, int col) {
        boolean[] nums = new boolean[9];
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                nums[board[r][c] - '0' - 1] = true;
            }
        }
        for (int i = 0; i < cells; i++) if (!nums[i]) return false;
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, int num) {
        for (int i = 0; i < cells; i++) {
            if (board[i][y] - '0' == num) return false;
            if (board[x][i] - '0' == num) return false;
        }
        return true;
    }

}