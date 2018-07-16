package assignment1;

import java.util.Scanner;

public class StackLinkedListMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		StackLinkedList obj = new StackLinkedList();
		int ch,val;
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("MENU");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Top Value");
			System.out.println("4. Is the stack Empty?");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1: System.out.println("Enter value to be pushed:");
						val=sc.nextInt();
						obj.push(val);
						break;
						
				case 2: val=obj.pop();
						if(val!=-1)
							System.out.println("The popped value is: "+val);
						break;
						
				case 3: if(!obj.isEmpty())
						{	
							val=obj.topValue();
							System.out.println("The top value is: "+val);
						}
						else
							System.out.println("The stack is empty!");
						break;
						
				case 4: boolean isempty=obj.isEmpty();
						if(isempty==true)
							System.out.println("The stack is empty");
						else
							System.out.println("The stack is not empty");
						break;
						
				case 5: System.exit(0);
				
				default: System.out.println("Wrong choice!! Please select correct option");
			}
		
	}

}
}
