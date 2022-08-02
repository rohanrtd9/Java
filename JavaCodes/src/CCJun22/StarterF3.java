package CCJun22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StarterF3 {
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
			//higher value will be this
			int a=Integer.parseInt(st.nextToken());
			//this will be lower value
			int b=Integer.parseInt(st.nextToken());
			
			if(b>a)
			{
				int t=b;
				b=a;
				a=t;
			}
			
			int c=(int)Math.pow(2, n)-1;
			
			int ptr=(int)Math.pow(2, n)>>1;
			int turn=b;
			while( ( a & ptr )==0 && a>0)
				ptr=ptr>>1;
			while(ptr>0)
			{
				if( (a & ptr)== (b & ptr ) )
				{
					//if both are one then we set the bit off
					if ( (a & ptr)== ptr)
						c-=ptr;
				}
				else
				{
					//we set c alternating the bits as per need
					if ( ( turn & ptr )==ptr )
						c-=ptr;
					
					
					//then change turn
					if (turn==b)
						turn =a;
					
				}
				ptr=ptr>>1;
			}
			out.println(c);
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