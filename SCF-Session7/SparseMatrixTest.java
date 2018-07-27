package sparseMatrix;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This class will contains the test cases on sparse matrix
 * @author Deekshika Sharma
 */
public class SparseMatrixTest {

	int[][] matrix = new int[][] {{1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
	int[][] matrix1 = new int[][] {{1,0,5,0}, {0,1,7,0}, {0,0,2,0}, {0,0,0,9}};
	
    int[][] sparseMatrix = new int[][] {{2,6,7,5,4}, {8,5,4,2}};
	
	SparseMatrixOperations sparse = new SparseMatrixOperations(matrix, 4, 4);
	SparseMatrixOperations sparse1 = new SparseMatrixOperations(matrix1, 4, 4);
	
	/**
	 * This test case will have the positive test cases
	 */
	@Test
	public void SparseTest() {
		
        assertNotNull(sparse1.transposeMatrix());
		assertTrue(sparse.isSymmetric());
		assertFalse(sparse1.isSymmetric());
	    assertNotNull(sparse.addMatrices(sparse, sparse1));
	    assertNotNull(sparse.multiplyMatrices(sparse, sparse1));
	}

	/**
	 * This test case will have the negative test cases
	 */
	@Test(expected = AssertionError.class)
	public void AssertionErrorTest() {
		SparseMatrixOperations sparse2 = new SparseMatrixOperations(sparseMatrix, 0, 0);
        assertNotNull(sparse2.transposeMatrix());
		assertFalse(sparse2.isSymmetric());
	    assertNotNull(sparse2.addMatrices(sparse, sparse2));
	    assertNotNull(sparse2.multiplyMatrices(sparse, sparse2));
	}
}
