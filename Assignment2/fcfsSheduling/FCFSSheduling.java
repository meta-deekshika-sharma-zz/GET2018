package fcfsSheduling;

import java.util.Scanner;

public class FCFSSheduling {

	private int numProcess, p [], arrival [], burst [], completion [], tat [], wt [];
	
	/**
	 * This is a constructor which will take arrival time and burst time as input at the time of object creation
	 * @throws ArrayIndexOutOfBoundsException will throw exception
	 */
	
	public FCFSSheduling () throws ArrayIndexOutOfBoundsException
	{
		System.out.println("First come first serve schduling algorithm !!!");
		System.out.println("Enter no. of process : ");
		Scanner sc = new Scanner(System.in);
		numProcess = sc.nextInt();
		
		arrival = new int[numProcess];
		p = new int[numProcess];
		burst = new int[numProcess];
		completion = new int[numProcess];
		tat = new int[numProcess];
		wt = new int[numProcess];
		for (int i = 0; i < numProcess; i++)
		{
			System.out.println("Enter the arrival time of process :" + "p [" + i + "]");
			arrival [i] = sc.nextInt();
			System.out.println("Enter the burst time of process :" + "p [" + i + "]");
			burst [i] = sc.nextInt();
		}
	}
	
	/**
	 * This method will sort the processes based on their arrival time
	 * @throws ArrayIndexOutOfBoundsException handle the exception
	 */
	public void sortProcessByArrivalTime () throws ArrayIndexOutOfBoundsException
	{
		for (int i = 0; i < numProcess; i++)
		{
			for (int j = i+1; j <numProcess; j++)
			{
				if (arrival[i] > arrival[j])
				{
					int temp;
					temp = arrival[i];
					arrival[i] = arrival[j];
					arrival[j] = temp;
					temp = burst[i];
					burst[i] = burst[j];
					burst[j] = temp;
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
			}
		}
	}
	
	/**
	 * this method will calculate completion time of each process
	 * @param pid will take the id of process
	 * @return the completion time of process
	 * @throws ArrayIndexOutOfBoundsException handle the exception
	 */
	public int completionTime (int pid) throws ArrayIndexOutOfBoundsException
	{
		sortProcessByArrivalTime();
		int complete = 0;
		
		completion [0] = arrival [0] + burst [0];
		complete = completion [0];
		for (int i = 1; i <= pid; i++)
		{
			   completion [i] = completion [i-1] + burst [i];
			   complete = completion[i];
		}
		return complete;
	}
	
	/**
	 * this method will calculate the waiting time of the process based on their id
	 */
	public int waitingTime (int pid) throws ArrayIndexOutOfBoundsException
	{
		turnAroundTime(pid);
		int waitingTime = 0;
		for (int i = 0; i <= pid; i++)
		{
			wt [i] = tat [i] - burst [i];
			waitingTime = wt [i];
		}
		return waitingTime;
	}
	
	/**
	 * this method will calculate the waiting time of the process based on their id
	 * @param pid
	 * @return trun around time of each process 
	 * @throws ArrayIndexOutOfBoundsException handle the exception
	 */
	public int turnAroundTime (int pid) throws ArrayIndexOutOfBoundsException
	{
		completionTime(pid);
		int turnAroudTime = 0;
		for (int i = 0; i <= pid; i++)
		{
			tat [i] = completion [i] - arrival [i];
			turnAroudTime = tat [i];
		}
		return turnAroudTime;
	}
	
	/**
	 * this method will calculate the average waiting time in system
	 * @return average waiting time of process
	 * @throws ArrayIndexOutOfBoundsException handle the exception
	 */
	public double averageWaitingTime() throws ArrayIndexOutOfBoundsException
	{
		int add = 0;
		int temp = numProcess;
		for(int i = 0; i < numProcess; i++)
		{
			temp--;
		   add += waitingTime(temp);
		}
		return add/numProcess;
	}
	
	/**
	 * this method will calculate the maximum waiting time of a process in the queue
	 * @return the maximum waiting time of system
	 * @throws ArrayIndexOutOfBoundsException handle the exception
	 */
	public int maxWaitingTime () throws ArrayIndexOutOfBoundsException
	{
		int max = wt [0];
		averageWaitingTime();
		for (int i = 0; i < numProcess; i++)
		{
			for (int j = i+1; j < numProcess; j++)
			{
				if(wt [i] < wt [j])
				{
					max = wt [j];
				}
			}
		}
		return max;
	}
	
}
