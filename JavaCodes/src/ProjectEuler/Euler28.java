package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Euler28 {
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
			int m=1000000007;
			long a=Long.parseLong(br.readLine());
			long n=(a+1)/2;
			n=n%m;
			long sumSqOdd= (n * (4*n*n -1)) / 3;
			
			long sumA=sumSqOdd-1;
			long temp=n*(n-1);
			sumA-=temp;
			
			long sumB=sumSqOdd-1;
			long nk=n-1;
			long sumC= (2*(nk)*(nk+1)*(2*nk+1))/3;
			long sumCC=sumC+nk;
			long sumD;
			sumD =sumC-(nk*nk);
			
			out.println(sumA+sumB+sumCC+sumD+1);
		}
		out.flush();
	}
}
