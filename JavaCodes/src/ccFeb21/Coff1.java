package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//accepted
public class Coff1 {
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
			//this is n
			int n=Integer.parseInt(st.nextToken());
			//this is k
			int k=Integer.parseInt(st.nextToken());
			int a[]=new int[k];
			String s[]=br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) 
				a[i]=Integer.parseInt(s[i]);
			
			int lp=0;
			for (int ai : a) {
				int t=ai;
				for (int j = lp; j < ai; j++) 
					
					out.print(t-- +" ");
				lp=ai;
			}	
			out.print("\n");
		}
		out.flush();
	}
	
}
