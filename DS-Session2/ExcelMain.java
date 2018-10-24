package excelSheet;


public class ExcelMain {

	public static void main(String[] args) {

		CounselingProcess counsellingProcess = new CounselingProcess();
		
		counsellingProcess.allotProgramToStudents("C:\\Users\\User15\\Documents\\StudentList.xls", "C:\\Users\\User15\\Documents\\ProgramList.xls", 7, 5);
		
	}
}
