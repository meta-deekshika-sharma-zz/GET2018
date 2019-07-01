package knightTour;

public class KnightTour {
   
    private int N;
    public KnightTour(int N) {
        this.N = N;
    }
    
    /**
     * to check if rowIndex,columnIndex are valid indexes for N*N chess board
     * @param rowIndex
     * @param columnIndex
     * @param board
     * @return true if knight can be placed at board[rowIndex][olumnIndex], false otherwise
     */
    private boolean isSafeToPlaceKnightHere(int rowIndex, int columnIndex, int board[][]) {
        return (rowIndex >= 0 && rowIndex < N && columnIndex >= 0 &&
                columnIndex < N && board[rowIndex][columnIndex] == -1);
    }
 
    /**
     * This function solves the Knight Tour problem using Backtracking. This  function mainly uses solveKnightTour() to solve the problem.
     * @return false if no complete tour is possible otherwise return true and prints the tour
     */
    public int[][] solveKnightTourProblem() {
        int board[][] = new int[8][8];
 
        /**
         * Initialization of solution matrix
         */
        for (int rowIndex = 0; rowIndex < N; rowIndex++){
            for (int columnIndex = 0; columnIndex < N; columnIndex++){
                board[rowIndex][columnIndex] = -1;
            }
        }
 
       /**rowMove[] and columnMove[] define next move of Knight.
        * rowMove[] is for next value of x coordinate
        * columnMove[] is for next value of y coordinate
        */
        int rowMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int columnMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
        
        board[0][0] = 0; // initially starts from first block
       
        
        /**
        * Start from 0,0 and explore all tours using solveKTUtil()
        */
        if (!solveKnightTour(0, 0, 1, board, rowMove, columnMove)) {
            System.out.println("Solution does not exist");
            return null;
        } 
        return board;
    }
 
    /**
     * A recursive method to solve Knight Tour problem
     * @param rowIndex
     * @param columnIndex
     * @param moveI
     * @param board
     * @param rowMove
     * @param columnMove
     * @return true if knight tour possible, false otherwise
     */
    private boolean solveKnightTour(int rowIndex, int columnIndex, int moveI, int board[][], int rowMove[], int columnMove[]) {
        int move, next_x, next_y;
        if (moveI == N * N){
            return true;
        }
 
        /**
         *  Try all next moves from the current coordinate rowIndex, columnIndex 
         */
        for (move = 0; move < 8; move++) {
            next_x = rowIndex + rowMove[move];
            next_y = columnIndex + columnMove[move];
            if (isSafeToPlaceKnightHere(next_x, next_y, board)) {
                board[next_x][next_y] = moveI;
                if (solveKnightTour(next_x, next_y, moveI + 1, board, rowMove, columnMove)){
                    return true;
                }
                else{
                    board[next_x][next_y] = -1;// backtracking
                }
            }
        }
        return false;
    }
}