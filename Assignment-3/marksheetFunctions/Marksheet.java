package marksheetFunctions;


/**
 * this class will have different methods regarding operations on grade
 * @author Dell
 * arithmetic exceptions are handled
 */
public class Marksheet {

	/**
	 * this method will calculate the average grades of the students
	 * @param numStudents take no. of students
	 * @param grades take an array of grades of students
	 * @return displays the average grade of students
	 * @throws ArithmeticException
	 */
	public double averageGrade (int numStudents, int [] grades) throws ArithmeticException
	{
		int totalGrade = 0;
		for (int i = 0; i < numStudents; i++)
		{
			totalGrade += grades[i];  
		}
		return (totalGrade/numStudents);
	}
	
	/**
	 * this method will return the maximum grade among students
	 * @param numStudents take no. of students
	 * @param grades take an array of grades of students
	 * @return displays the maximum grade among students
	 * @throws ArithmeticException
	 */
	public int maxGrade (int numStudents, int [] grades) throws ArithmeticException
	{
		int maxiGrade = grades[0];
		
		for (int i = 0; i < numStudents; i++)
		{
			if (grades[i] > maxiGrade)
			{
				maxiGrade = grades[i];
			}
		}
		return maxiGrade;
	} 
	
	/**
	 * this method will return the minimum grade among students
	 * @param numStudents take no. of students
	 * @param grades take an array of grades of students
	 * @return displays the minimum grade among students
	 * @throws ArithmeticException
	 */
	public int minGrade (int numStudents, int [] grades) throws ArithmeticException
	{
        int miniGrade = grades[0];
		
		for (int i = 0; i < numStudents; i++)
		{
			if (grades[i] < miniGrade)
			{
				miniGrade = grades[i];
			}
		}
		return miniGrade;
	}
	
	/**
	 * this method will calculate the percentage of students who passed the exam
	 * @param numStudents take no. of students
	 * @param grades take an array of grades of students
	 * @return displays the percentage of students who passed the exam
	 * @throws ArithmeticException
	 */
	public double studentPassed (int numStudents, int [] grades) throws ArithmeticException
	{
		int passedStudents = 0;
		for (int i = 0; i < numStudents; i++)
		{
			if (grades[i] >= 40)
			{
				passedStudents++;
			}
		}
		return roundOf(((passedStudents*100)/numStudents));
	}
	
	
	public double roundOf (double value)
	{
		return Double.parseDouble(String.format("%.2f", value));
	}
}
