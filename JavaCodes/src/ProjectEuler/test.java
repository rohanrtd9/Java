package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) throws Exception {
	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		
		
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		test t= new test();
		int cycles[]=new int[10001];
		cycles[0]=-1;
		int currMax=0;
		int currN=0;
		int n=1;
		for (int i = 3; i < cycles.length; i++) 
		{
			System.out.println(n++);
			int cycCur=t.detectCycle(i);
			if(cycCur>currMax)
			{
				currMax=cycCur;
				currN=i;
			}
			cycles[i]=currN;
		}
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			out.print(cycles[k]);
		}
		out.flush();
	}
	private int detectCycle(int n)
	{
		
		//this is the variable used for calculating modulus
		int i=1;
		//boolean cycNotDet=true;
		int cycleLength=0;
		String cyc="";
		
		int hare=0,turtle=0;
		int af=1;
		while (true)
		{	
			turtle++;
			hare=af+++turtle;
			//this counter determines the amount of string to be calculated it is always two times the hare
			//pointer*
			int c=0;
			//this is the add factor ie how much turtle will move forward
			
			while(c++<=(hare+(hare-turtle)))
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
			
			
		}

	}
}
