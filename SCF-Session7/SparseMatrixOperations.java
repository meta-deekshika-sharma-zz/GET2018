package sparseMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains various operations on sparse matrix
 * @author Deekshika Sharma
 */
public class SparseMatrixOperations {
	
	List<SparseMatrix> sparseMatrixRepresentations = new ArrayList<SparseMatrix>();
	int rows, columns;
	int[][] sparseMatrix;
	
	/**
	 * A parameterized constructor which converts the array elements into list
	 * @param sparseMatrix
	 * @param row
	 * @param column
	 * Time Complexity O(row * column)
	 */
	public SparseMatrixOperations (int[][] sparseMatrix, int row, int column)
	{
		if (sparseMatrix.length == 0)
			throw new AssertionError();
		this.rows = row;
		this.columns = column;
		this.sparseMatrix = sparseMatrix;
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				if (sparseMatrix[i][j] != 0)
				{
					sparseMatrixRepresentations.add(new SparseMatrix(sparseMatrix[i][j], i, j));
				}
			}
		}
	}
	
	
	/**
	 * This method will externally convert 2D sparse matrix into list
	 * @param sparseMatrix
	 * @param row
	 * @param column
	 * @return the list of matrix which contain non zero elements
	 * Time complexity O(row * column)
	 */
	public List<SparseMatrix> getSparseMatrix (int[][] sparseMatrix, int row, int column)
	{
		this.rows = row;
		this.columns = column;
		List<SparseMatrix> newSparseMatrix = new ArrayList<SparseMatrix>();
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				if (sparseMatrix[i][j] != 0)
				{
					newSparseMatrix.add(new SparseMatrix(sparseMatrix[i][j], i, j));
				}
			}
		}
		showResult(newSparseMatrix);
		return newSparseMatrix;
	}
	
	/**
	 * This will transpose the sparse matrix
	 * @return the list of elements of transpose matrix
	 * Time complexity O(n)
	 */
	public List<SparseMatrix> transposeMatrix () 
	{
		List<SparseMatrix> transposeSparseMatrix = new ArrayList<SparseMatrix>();
		for (SparseMatrix sparse : sparseMatrixRepresentations)
		{
			transposeSparseMatrix.add(new SparseMatrix(sparse.getKeyValue(), sparse.getColumnNumber(), sparse.getRowNumber()));
		}
		return transposeSparseMatrix;
	}
	
	/**
	 * This will return true is matrix is symmetric
	 * @return true if the sparse matrix is symmetric
	 * Time complexity O(n)
	 */
	public boolean isSymmetric ()
	{
		List<SparseMatrix> transposeMatrix = transposeMatrix();
		for (SparseMatrix sparse : sparseMatrixRepresentations)
		{
			for (int i = 0; i < transposeMatrix.size(); i++)
			{
				if (transposeMatrix.get(i).getKeyValue() != sparse.getKeyValue())
					return false;
			}
		}
		return true;
	}
	
	/**
	 * This method will add the two sparse matrices
	 * @param matrix1
	 * @param matrix2
	 * @return the list which have only non zero elements
	 * Time complexity O(matrix1.row * matrix1.column)
	 */
	public List<SparseMatrix> addMatrices (SparseMatrixOperations matrix1, SparseMatrixOperations matrix2)
	{
		if(matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns)
            throw new AssertionError("Dimensions not same! Cannot add!");
        
        int[][] addition = new int[matrix1.rows][matrix1.columns];
        
        for (int i = 0; i < matrix1.rows; i++)
        {
        	for (int j = 0; j < matrix1.columns; j++)
        	{
        		addition[i][j] = matrix1.sparseMatrix[i][j] + matrix2.sparseMatrix[i][j];
        	}
        }
        
        return getSparseMatrix(addition, matrix1.rows, matrix1.columns);
	}
	
	
	/**
	 * This method will multiply the two sparse matrices
	 * @param matrix1
	 * @param matrix2
	 * @return the list which have non zero elements
	 * Time complexity O(matrix1.row * matrix2.column * matrix1.columns)
	 */
	public List<SparseMatrix> multiplyMatrices (SparseMatrixOperations matrix1, SparseMatrixOperations matrix2)
	{
		if(matrix1.columns != matrix2.rows)
            throw new AssertionError("Dimensions not compatible for multiplication! Cannot multiply!");
        
        int[][] multiplication = new int[matrix1.rows][matrix2.columns];
        
        for(int i = 0; i < matrix1.rows; i++)
        {
            for(int j = 0; j < matrix2.columns; j++)
            {
                for(int k = 0; k < matrix1.columns; k++)
                {
                    multiplication[i][j] += matrix1.sparseMatrix[i][k] * matrix2.sparseMatrix[k][j];
                }
            }
        }
        return getSparseMatrix(multiplication, matrix1.rows, matrix2.columns);
	}
	
	
	/**
	 * This method will show the elements of list which have non zero elements1
	 * @param sparseMatrix
	 * Time complexity O(n)
	 */
	public void showResult (List<SparseMatrix> sparseMatrix)
	{
		for (SparseMatrix sparse : sparseMatrix)
		{
			System.out.println(sparse.getKeyValue());
		}
	}
	
}
