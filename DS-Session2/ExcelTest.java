package excelSheet;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma This test case is related to student counseling
 *         process
 */
public class ExcelTest {

	/**
	 * This test case is related to positive test case
	 */
	@Test
	public void testExcel() {
		assertNotNull(CounselingProcess.allotProgramToStudents(
				"C:\\Users\\User15\\Documents\\StudentList.xls",
				"C:\\Users\\User15\\Documents\\ProgramList.xls", 7, 5));
	}

	/**
	 * This test case is run when an exception is thrown
	 */
	@Test(expected = AssertionError.class)
	public void testError() {
		assertNotNull(CounselingProcess.allotProgramToStudents("",
				"C:\\Users\\User15\\Documents\\ProgramList.xls", 7, 5));
		assertNotNull(CounselingProcess.allotProgramToStudents(
				"C:\\Users\\User15\\Documents\\ProgramList.xls", "", 7, 0));
	}
}
