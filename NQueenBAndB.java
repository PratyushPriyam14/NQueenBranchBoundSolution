import java.util.*;
import java.io.*;
public class NQueenBAndB {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] nordiag = new boolean[2 * n - 1];
        boolean[] revdiag = new boolean[2 * n - 1];
        solve(board, 0, cols, nordiag, revdiag, "");
    }

    public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] nordiag, boolean[] revdiag, String asf) {
        if (row == board.length) {
            System.out.println(asf + ".");
            return ;
        }
        for (int col = 0; col < board[0].length; col++) {
            if (cols[col] == false && nordiag[row + col] == false && revdiag[row - col + board.length - 1] == false) {
                board[row][col] = true;  //putting queen
                cols[col] = true;        // make the col block where the queen has been putted by makeing true in colarray index where queen is placed
                nordiag[row + col] = true;  //the values of row+col in the board are get blocked by normal diagonal theory
                revdiag[row - col + board.length - 1] = true;  //same for reverse diagonal
                //call function
                solve(board, row + 1, cols, nordiag, revdiag, asf + row + "-" + col + ",");
                //backtracking
                board[row][col] = false;
                cols[col] = false;
                nordiag[row + col] = false;
                revdiag[row - col + board.length - 1] = false;
            }
        }
    }
}
