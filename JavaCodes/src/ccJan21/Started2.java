package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
//accepted
public class Started2 {
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
			int a[]=new int[n];
			
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i < a.length; i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			
			//this contains and of elements upto index
			int orArray[]=new int[n];
			orArray[n-1]=a[n-1];
			for (int i = a.length-2; i> 0; i--) {
				orArray[i]=a[i]|orArray[i+1];
			}
			int res=0;
			if(n==1)
			{
				res=a[0];
			}
			
			else
			{
				for (int i = 0; i < n-2; i++) {
					res|=a[i] & orArray[i+1];
				}
				res|=a[n-1]&a[n-2];
			}
			out.println(res);
		}
		out.flush();
	}
}