package excelSheet;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import queue.QueueLinkedList;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @author Deekshika Sharma This class will represent list of programs for a
 *         student counseling process
 */
public class CounselingProcess {

	public static String allotProgramToStudents(String studentList,
			String listOfProgram, int noOfStudents, int noOfPrograms) {
		
		if(studentList.length() == 0 || listOfProgram.length() == 0 || noOfStudents == 0 || noOfPrograms == 0)
			throw new AssertionError("Data is invalid!!");
		
		try {

			Workbook listOfPrograms = Workbook.getWorkbook(new java.io.File(
					listOfProgram)); // workbook of program is get
			Workbook listOfStudents = Workbook.getWorkbook(new java.io.File(
					studentList)); // workbook of student is get

			Map<String, Integer> programMap = new HashMap<>(); // create map for
																// program list

			Sheet programSheet = listOfPrograms.getSheet(0);
			Sheet studentSheet = listOfStudents.getSheet(0);

			for (int i = 1; i <= noOfPrograms; i++) {
				programMap.put(programSheet.getCell("A" + i).getContents(),
						Integer.parseInt(programSheet.getCell("B" + i)
								.getContents()));
			}

			QueueLinkedList<Student> studentQueue = new QueueLinkedList<Student>(); // create
																					// queue
																					// for
																					// student
																					// queue

			for (int i = 1; i <= noOfStudents; i++) {
				List<String> listOfPreference = new ArrayList<>();

				for (char j = 'C'; j <= 'G'; j++) {
					String colName = "" + j;
					listOfPreference.add(studentSheet.getCell(colName + i)
							.getContents()); // add list of preferences
				}
				Student student = new Student(Integer.parseInt(studentSheet
						.getCell("A" + i).getContents()), studentSheet.getCell(
						"B" + i).getContents(), listOfPreference);
				studentQueue.enQueue(student);
			}

			WritableWorkbook studentWorkbook = Workbook
					.createWorkbook(new File("studentWorkbook.xls")); // create
																		// a new
																		// sheet
																		// for
																		// to
																		// store
																		// result
			WritableSheet studentWorkbookSheet = studentWorkbook.createSheet(
					"sheet1", 0);

			for (int i = 1; i <= noOfStudents; i++) {
				Student student = studentQueue.deQueue();

				for (String preference : student.getListOfPreference()) {
					int capacityOfProgram = programMap.get(preference);
					if (capacityOfProgram != 0) {
						student.setAllotedProgram(preference);
						programMap.put(preference, capacityOfProgram - 1);
						break;
					}
				}
				// add labels to sheet
				String rank = "" + student.getRank();
				Label l1 = new Label(0, i, rank);
				studentWorkbookSheet.addCell(l1);

				Label l2 = new Label(1, i, student.getName());
				studentWorkbookSheet.addCell(l2);

				Label l3 = new Label(2, i, student.getAllotedProgram());
				studentWorkbookSheet.addCell(l3);

			}

			studentWorkbook.write();// write the workbook
			studentWorkbook.close();// close the workbook

		}

		catch (Exception e) {
			System.out.println(e);
		}

		return "studentWorkbook.xls";
	}
}
