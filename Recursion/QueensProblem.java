package recursion;

/**
 * This class will have the method to solve the N Queen Problem
 * @author Deekshika Sharma
 */
public class QueensProblem {

	/**
	 * This method is a recursive method which will call when condition is true
	 * @param board take N*N board as input where each value is initialize as 0
	 * @param startRow takes row where the solution has start
	 * @param dimension takes dimension of board
	 * @return true if queens are placed
	 */
	public boolean nQueen (int[][] board, int startRow, int dimension)
	{
		/**
		 * If row is greater then dimensions, so all queens are placed
		 * return true
		 */
		if (startRow >= dimension)
		{
			printSolution(board);
			return true;
		}
		for (int i = 0; i < dimension; i++)
		{
			/**
			 * Check whether to place the queen is safe or not
			 * If yes then place it otherwise backtrack
			 */
			if (isSafeToPlace(board, startRow, i))
			{
				board[startRow][i] = 1;
				if (nQueen(board, startRow + 1, dimension)) // check condition to place queen
					return true;
				
				board[startRow][i] = 0; // if queen is not place then backtrack
			}
			
		}
		
		return false;
	}
	
	/**
	 * This method have conditions to check diagonal, column and rows so that queen is placed safely
	 * @param board takes board as input
	 * @param row takes row from which conditions have to checked
	 * @param col takes column from which conditions have to checked
	 * @return true is place is safe to place queen
	 */
	public boolean isSafeToPlace (int[][] board, int row, int col)
	{
		for (int i = 0; i < row; i++) // check row for placing queen
		{
			if (board[i][col] == 1)
				return false;
		}
		
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) // check upper diagonal for placing queen 
		{
			if (board[i][j] == 1)
				return false;
		}
		
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) // check lower diagonal for placing queen
		{
			if (board[i][j] == 1)
				return false;
		}
		
		return true;

	}
	
	/**
	 * This method will print the resultant array at console
	 * @param board take resultant board as input
	 */
	public void printSolution (int[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board.length; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
}
