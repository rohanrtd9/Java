package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lt02RomanRev {
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
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			//this is thee result
			char str[]=br.readLine().toCharArray();
			
			char res[]=new char[n];
			for (int i = k; i < res.length; i++) {
				res[i]=str[i];
			}
			//now we maintain two pointers
			int lp=0,rp=k-1;
			//and a ptr for result array
			int resP=k-1;
			int turn=0;
			while(lp<=rp)
			{
				if ( (turn++&1) == 0)
				{
					res[resP--]=str[lp++];
				}
				else
				{
					res[resP--]=str[rp--];
				}
			}

			out.println(new String(res));
		}
		out.flush();
	}
}