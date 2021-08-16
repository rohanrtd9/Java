package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Euler24LexPerm {
	public static void main(String[] args) throws Exception
	{
	Euler24LexPerm elp= new Euler24LexPerm();
	//importing io functions
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= new StringTokenizer(br.readLine());			
	//this is number of test cases
	int tc=Integer.parseInt(st.nextToken());
	String s="abcdefghijklm";
	while(tc-->0)
		{
		StringBuilder sb= new StringBuilder(s);
		st= new StringTokenizer(br.readLine());	
		//this is number of test cases
		long n=Long.parseLong(st.nextToken());
		n--;
		long fact13=6227020800l;
		elp.permutationMaker(n, 13, sb, fact13);
		System.out.println(sb.toString());
		}
	}
	
	private void permutationMaker( long n, int cnt,StringBuilder sb,long fact13)
	{
		if (n==0)
			return;
		else
		{
			if(n<fact13)
				this.permutationMaker( n, cnt-1, sb, fact13/cnt);
			else
			{
				int i;
				for (i = cnt; fact13*i>n; i--);
				this.swap(sb, sb.length()-cnt-1, sb.length()-cnt+i-1);
				n-=fact13*i;
				this.permutationMaker( n, cnt-1, sb, fact13/cnt);
			}		
			//sb.
		}
	}
	private void swap(StringBuilder sb, int m, int n)
	{
		char ss=sb.charAt(n);
		sb.deleteCharAt(n);
		sb.insert(m, ss);
	}
}
