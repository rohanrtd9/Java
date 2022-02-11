package ccFeb21;


//accepted soltution starter b3 is optimized soltuion
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
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
			long k=Long.parseLong(st.nextToken());
			long a[]=new long[ n];

			//we set all index zero

			a[0]=1;
			int ps=0;
			for (int i = 1; i <n; i++) {

				ps+=i;

				//if we have element that is below the prefix sum
				if(ps+n<=k)
					a[i]=a[i-1]+1;
				else
				{
					a[i]=a[(int) ((ps+n)-k-1)];
					break;
				}
			}




			//// all the zeroes
			
			for (int i = 1; i < a.length; i++) {
				if(a[i]==0)
					a[i]=a[i-1];
			}

			for (int i = 0; i < a.length; i++) {
				out.print(a[i]+" ");
			}
			out.print("\n");
		}
		out.flush();
	}
}