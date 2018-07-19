package marksheetFunctions;

import java.util.Scanner;

/**
 * this class is used to display main method which contain a menu
 * @author Dell
 * exceptions are handled through exception handling
 */

public class MarksheetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marksheet marksheet = new Marksheet();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no. of students");
		try {
		int numStudents = sc.nextInt(); //input no. of students 
		if ((numStudents % 1 )!= 0)
		{
			throw new NumberFormatException();
		}
		
		int grades [] = new int[numStudents];
		for (int i = 0; i < numStudents; i++)
		{
			System.out.println("Enter the grade of student :" + (i+1)); //input grades of each student
			grades[i] = sc.nextInt();
			
			/**
			 * it will check whether grade will lied in between 0 to 100 
			 */
			if(grades [i] > 100 || grades [i] < 0) 
			{
				System.out.println("Grades must be in between 0 to 100");
				return;
			}
		}
		
		/**
		 * this while loop will true in each condition and used to provide menu for the users
		 * user will select option and perform the operations
		 * exception are handled through try-catch block
		 */

		while (true)
		{
	     	System.out.println("MENU");
			System.out.println("1. Average grades of students");
			System.out.println("2. Maximum grades of students");
			System.out.println("3. Minimum grades of students");
			System.out.println("4. Passed percentage of students");
			System.out.println("Enter your choice:");
			
			int choice = sc.nextInt();
			if (!(choice > 0))
			{
				throw new NumberFormatException();
			}
			
			switch (choice)
			{
			   case 1: 
				   System.out.println("Average grades of studenta : " + marksheet.averageGrade(numStudents, grades));
			       break;
			   case 2:
			       System.out.println("Maximum grades of students : " + marksheet.maxGrade(numStudents, grades));
		           break;
			   case 3:
		           System.out.println("Minimum grades of students : " + marksheet.minGrade(numStudents, grades));
	               break;
			   case 4:
	               System.out.println("Passed percentage students : " + marksheet.studentPassed(numStudents, grades) + "%");
                   break;
			   default : throw new NumberFormatException();
			}
					
		}
	  } catch (Exception e)
	  {
		 System.out.println("Please input the valid value.!!");
	  }

	}

}
