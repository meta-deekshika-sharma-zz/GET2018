package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Deekshika Sharma This class will represent the directory structure
 */
public class Directory {

	private final String name;
	private final Date dateOfCreation;
	private List<Directory> listOfSubDirectory;

	// Constructor is called when new object is created
	public Directory(String name, Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
		this.name = name;
		this.listOfSubDirectory = new ArrayList<Directory>();
	}

	// Getters are present for further implementation
	public List<Directory> getListOfSubDirectory() {
		return listOfSubDirectory;
	}

	public void setListOfSubDirectory(List<Directory> listOfSubDirectory) {
		this.listOfSubDirectory = listOfSubDirectory;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

}
