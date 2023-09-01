public class sudoku {
    public static boolean solveSudoku(int[][] board) {
        int[] emptyCell = findEmptyCell(board);
        if (emptyCell == null) {
            return true;  // All cells are filled
        }
        
        int row = emptyCell[0];
        int col = emptyCell[1];
        
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                
                if (solveSudoku(board)) {
                    return true;  // Move to the next empty cell
                }
                
                // If no valid solution is found, backtrack
                board[row][col] = 0;
            }
        }
        
        return false;  // No solution found
    }
    
    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;  // Check row and column
            }
            
            int boxRow = row / 3 * 3 + i / 3;
            int boxCol = col / 3 * 3 + i % 3;
            
            if (board[boxRow][boxCol] == num) {
                return false;  // Check 3x3 box
            }
        }
        
        return true;
    }
    
    public static int[] findEmptyCell(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;  // All cells are filled
    }
    
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] sudokuBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        if (solveSudoku(sudokuBoard)) {
            System.out.println("Sudoku solved:");
            printBoard(sudokuBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
