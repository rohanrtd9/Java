package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Long1StrongStrong {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			
			int a[]=new int[n];
			String s[]=br.readLine().split(" ");
			int oneCount=0;
			int gc=0;
			int result=0;
			for (int i = 0; i < a.length; i++) 
			{
				a[i]=Integer.parseInt(s[i]);
				if( a[i] == 1)
					oneCount++;
			}
			if(oneCount>1)
				result=0;
			else if (oneCount==1)
			{
				
				for (int i = 0; i < a.length; i++) 
					if( a[i] != 1)
						gc=gcd( a[i], gc );
				// 5 3 1
				if ( gc == 1)
					result=0;
				// 6 2 1
				else
					result=1;
			}
			else
			{
				if ( n==2 )
					result=2;
				else
				{
					gc = gcd ( a[0], a[1]);
					if( gc==1 )
					{
						int last=0;
						int ptr=2;
						while ( ptr < n && last != 1)
						{
							last= gcd ( last, a[ptr] );	
							ptr++;
						}
						if ( last==1 )
							result=0;
						else
						{
							int g1=gcd( last, a[0] );
							int g2=gcd( last, a[1] );
							
							//3 5 2 4 8
							if ( g1==1 && g2==1 )
								result=0;
							//3 5 15 30
							else if ( g1 == 1 || g2 == 1)
								result=1;
							else
								result=2;
						}
					}
					else
					{
						//so we know that numbers have a GCD and 
						//there are no 1s
						//gc is gcd of the numbers
						int ptr=2;
						int cgcd=0;
						int redZeroCount=0;
						int indexZeroCount=0;
						while(ptr<n && redZeroCount<2)
						{
							cgcd=gcd(gc,a[ptr]);
							//then we have found a number that makes the gcd as zero of the numbers
							if( cgcd==1 )
							{
								redZeroCount++;
								indexZeroCount=ptr;
							}
							else
							{
								gc=cgcd;
							}
							ptr++;
						}
						if(redZeroCount>1)
							result=0;
						else if (redZeroCount==0)
							result=n;
						else
						{
							redZeroCount=0;
							cgcd=a[indexZeroCount];
							ptr=0;
							
							
							while(ptr<n)
							{
								if ( ptr== indexZeroCount)
									{ptr++;continue;}
								gc=gcd(cgcd,a[ptr]);
								if( gc==1 )
								{
									redZeroCount++;
									
								}
								else
									cgcd=gc;
								ptr++;
							}
							if(redZeroCount==1)
								result=2;
							else
								result=1;
						}
						
					}
				}	
			}
			
			out.println(result);
		}
		out.flush();
	}
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
}