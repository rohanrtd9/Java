package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ResiprocalCycles26 
{
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				PrintWriter out = new PrintWriter(System.out);
				ResiprocalCycles26 rpc= new ResiprocalCycles26();
				
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				int arr[]= new int[10001];
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					
					out.write(rpc.detectCycle(n));
					out.flush();
				}
	}
	private void printResi(int n)
	{
		System.out.print("\n"+n+" ");
		int i=1;
		boolean cycleDetected=false;
		for (int j = 0; j < 60 && !(cycleDetected); j++) {
			while(i<n)
				i*=10;
			System.out.print(i/n);
			i=i%n;
			if(i==0)
				break;
		}	
	}	
	private int detectCycle(int n)
	{
		//this is the cycle length in the given number
		int cycle=0;
		//this is the variable used for calculating modulus
		int i=1;
		//boolean cycNotDet=true;
		int cycleLength=0;
		String cyc="";
		
		int hare=0,turtle=0;
		while (true)
		{
		
			//this counter determines the amount of string to be calculated it is always two times the hare
			//pointer*
			int c=0;
			while(c++<=(hare+hare-turtle))
			{
				while(i<n)
					i*=10;
				cyc=cyc+(i/n);
				i=i%n;
				if (i==0)
					return -1;
			}
			if (cyc.charAt(hare)==cyc.charAt(turtle))
					{
					cycleLength=0;
						//if both hare and turtle point to same char
					//then we save turtle value in temp
					//and increment both turtle and hare till they both are same
					//if turtle reaches the value of hare then we are in a cycle
					int tempTur=turtle;
					int tempHare=hare;
					while (cyc.charAt(++hare)==cyc.charAt(++turtle))
						{cycleLength++;
						if (cyc.charAt(hare)==cyc.charAt(tempHare))
							return cycleLength;
						}
					tempTur=turtle;
					tempHare=hare;
					}
			hare++;
			turtle=turtle+hare;
		}

	}
}
