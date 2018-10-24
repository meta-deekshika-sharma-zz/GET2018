package excelSheet;

import java.util.List;

/**
 * @author Deekshika Sharma This class can represent the student list
 */
public class Student {

	private final String name;
	private final int rank;
	private final List<String> listOfPreference;
	private String allotedProgram;

	// The constructor is called when new student is added into list
	public Student(int rank, String name, List<String> listOfPreference) {
		this.name = name;
		this.rank = rank;
		this.listOfPreference = listOfPreference;
	}

	// getter-setters are present for each value
	public String getName() {
		return name;
	}

	public List<String> getListOfPreference() {
		return listOfPreference;
	}

	public String getAllotedProgram() {
		return allotedProgram;
	}

	public void setAllotedProgram(String allotedProgram) {
		this.allotedProgram = allotedProgram;
	}

	public int getRank() {
		return rank;
	}

}
