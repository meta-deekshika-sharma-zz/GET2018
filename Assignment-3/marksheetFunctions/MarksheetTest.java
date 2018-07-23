package marksheetFunctions;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class will contain the test cases for different operations on grades
 * @author Deekshika Sharma
 *
 */
public class MarksheetTest {

	Marksheet marksheet = new Marksheet();
	

	/**
	 * This test case calculates the average grades of students
	 */
	@Test
	public void averageGradeTest() {
		double grade1 = marksheet.averageGrade(3, new int[]{3,5,4});
	    assertEquals(4.0, grade1, 0.0);
	    double grade2 = marksheet.averageGrade(10, new int[]{30,77,23,55,77,44,88,42,72,99});
	    assertEquals(60.7, grade2, 0.0);
	}

	/**
	 * This test case finds the maximum among grades
	 */
	@Test
	public void maximumGradeTest() {
		int maxgrade1 = marksheet.maxGrade(3, new int[]{3,5,4});
	    assertEquals(5, maxgrade1);
	    int maxgrade2 = marksheet.maxGrade(10, new int[]{30,77,23,55,77,44,88,42,72,99});
	    assertEquals(99, maxgrade2);
	}
	
	/**
	 * This test case finds the minimum among grades
	 */
	@Test
	public void minimumGradeTest() {
	    assertEquals(3, marksheet.minGrade(3, new int[]{3,5,4}));
	    assertEquals(23, marksheet.minGrade(10, new int[]{30,77,23,55,77,44,88,42,72,99}));
	}
	
	/**
	 * This test case calculates the percentage of passed students
	 */
	@Test
	public void PassedGradeTest() {
	    assertEquals(0.0, marksheet.studentPassed(3, new int[]{3,5,4}), 0.0);
	    assertEquals(80.0, marksheet.studentPassed(10, new int[]{30,77,23,55,77,44,88,42,72,99}), 0.0);
	}
}
