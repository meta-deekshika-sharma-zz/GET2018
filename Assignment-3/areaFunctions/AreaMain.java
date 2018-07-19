package areaFunctions;

import java.util.Scanner;

/**
 * this main class will contain the menu for users
 * it handle the exceptions if occur in program
 */

public class AreaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Area area = new Area ();
		Scanner sc = new Scanner(System.in);
		
		/**
		 * this while loop will true in each condition and used to provide menu for the users
		 * user will select option and perform the operations
		 */
		try {
		while (true)
		{
	     	System.out.println("MENU");
			System.out.println("1. Area of Triangle");
			System.out.println("2. Area of Rectangle");
			System.out.println("3. Area of Squre");
			System.out.println("4. Area of Circle");
			System.out.println("Enter your choice:");
			
			int choice = sc.nextInt();
			/**
			 * this switch case displays are options based on menus
			 * each time it will take input as heights, width, radius and displays the output 
			 */
			
			switch (choice)
			{
			   case 1: 
				   System.out.println("Enter the height of the Triangle :");
				   double heightTriangle = sc.nextDouble();
				   System.out.println("Enter the width of the Triangle :");
				   double widthTriangle = sc.nextDouble();
				   System.out.println("Area of Triangle : " + area.triangleArea(heightTriangle, widthTriangle));
			       break;
			   case 2:
				   System.out.println("Enter the height of the Rectangle :");
			       double heightRectangle = sc.nextDouble();
			       System.out.println("Enter the width of the Rectangle :");
			       double widthRectangle = sc.nextDouble();
			       System.out.println("Area of Rectangle : " + area.rectangleArea(heightRectangle, widthRectangle));
		           break;
			   case 3:
		           System.out.println("Enter the width of the Square :");
		           double widthSquare = sc.nextDouble();
		           System.out.println("Area of Squre : " + area.squareArea(widthSquare));
	               break;
			   case 4:
				   System.out.println("Enter the radius of the Circle :");
	               double radiusCircle = sc.nextDouble();
	               System.out.println("Area of Circle : " + area.circleArea(radiusCircle));
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
