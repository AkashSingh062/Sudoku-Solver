
public class Sudoku {
        

    public static void main(String[] args) {
        char[][] board2 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        int[][] board = new int[board2.length][];
        for (int i = 0; i < board.length; i++) {
            board[i] = new int[board2[i].length];
            for (int j = 0; j < board[i].length; j++) {
            // Assuming you want to convert char to int, handling '.' as 0
                board[i][j] = board2[i][j] == '.' ? 0 : board2[i][j] - '0';
            }
        }
        if(solveSudoku(board))
        for (int[] is : board) {
            for (int i : is) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    static boolean solveSudoku(int[][] board){
        int row = -1;
        int col = -1;
        boolean result = true;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                if(board[r][c] == 0){
                    row = r;
                    col = c;
                    result = false;
                    break;
                }
            }
            if(result == false){
                    break;
            }
        }
        if(result == true){
            return true;
        }
        for (int n = 1; n <= 9; n++) {
            if(isSafe(board, row, col, n)){
                board[row][col] = n;
                if(solveSudoku(board)){
                    return true;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    static boolean isSafe(int [][] board, int row, int col, int target){
        // @param  Test.check in the row and column
        for (int i = 0; i < board.length; i++){
            if(board[i][col] == target){
                return false;
            }
            if(board[row][i] == target){
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for( int i = rowStart; i < rowStart + sqrt; i++ ){
            for( int j = colStart; j < colStart + sqrt;j++ ){
                if(board[i][j] == target){
                    return false;
                }
            }
        }
        return true;
    }
}