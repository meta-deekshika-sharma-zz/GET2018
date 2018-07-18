package fcfsSheduling;

import java.util.Scanner;

public class FCFSShedulingMain {
 
   public static void main (String arg [])
   {
	   
	   /**
	    * This is simply a menu driven program which will show the choices choosen by user
	    * Exception handling is used to remove exceptions 
	    */
	   
	   try {
		   FCFSSheduling fcfs = new FCFSSheduling();
	   while (true)
	   {
	      System.out.println("-------------MENU------------");
	      System.out.println("1. Calculate completion time of process ");
	      System.out.println("2. Calculate turn around time of process ");
	      System.out.println("3. Calculate waiting time of process ");
	      System.out.println("4. Calculate average waiting time of process ");
	      System.out.println("5. Maximum waiting time for a process in queue ");
	      
	      System.out.println("Enter your choice :");
	      Scanner sc = new Scanner(System.in);
	      int ch = sc.nextInt();
	      
	      switch (ch)
	      {
	      case 1: System.out.println("Enter the process id :");
	      int cid = sc.nextInt();
	      System.out.println("Completion time of Process : [" + cid + "]" + fcfs.completionTime(cid));
	      break;

	      case 2: System.out.println("Enter the process id :");
	      int tid = sc.nextInt();
	      System.out.println("Turn Around time of Process : [" + tid + "]" + fcfs.turnAroundTime(tid));
	      break;

	      case 3: System.out.println("Enter the process id :");
	      int wid = sc.nextInt();
	      System.out.println("Waiting time of Process :  [" + wid + "]" + fcfs.waitingTime(wid));
	      break;
	      

	      case 4: 
	       System.out.println("Average waiting time of System : " + fcfs.averageWaitingTime());
	      break;
	      
	      case 5: 
		       System.out.println("Maximum waiting time of process in queue : " + fcfs.maxWaitingTime());
		      break;
	      
	      default: new NumberFormatException();
	      }
	   }
	   }
	   catch (Exception e)
	   {
		   System.out.println("No result !!!. Please select valid input");
		   //System.exit(0);
	   }
	  }
	
}