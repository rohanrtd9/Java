package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AlphaBit3 {
	public static void main(String[] args)throws Exception 
	{	//basic concept of problem is we've string of length n and we've given a power k which weve to create by joining char
		//for given length. a=1 b= 2 c= 4 d=8 and so on
		// E.g - like we've to build string with power(k) 3 of length (n)2 it'll be ca or ac
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				StringTokenizer st= new StringTokenizer(br.readLine());
				//this array stores diff between consecutive power of 2 like 2^1-2^0 = 1 and so on
				int powDiff[]= { 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431};
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					//this is the length of the string
					int n=Integer.parseInt(st.nextToken());
					//this is the power which out string needs to have
					int k=Integer.parseInt(st.nextToken());
					
					// ie length of string is more than power then we'll not be able to make string
					//so we just give -1 output
					if(n>k)
						out.println(-1);
					else
					{
						//here we decrement k with n ... ie like weve to make string with power of 3 of length 2
						//then it should minimum have weight of 2 ie n 
						//so k that we need in excess or our play area is n-l
						//eg n=2 k=5 then we'll have  3 to play with and start with aa as our string
						k-=n;
						
						//next we create an array and fill it with a's
						char[] c= new char[n];
						Arrays.fill(c, 'a');
						
						//next we loop over the array and see if we've not exhausted out
						//out k and not reached the end and also make changes to array c inside loop
						//with maximum permittable value of powDiff
						
						//this little ptr points to end of powerDiff Array
						int jptr=powDiff.length-1;
						for (int i = n-1; i >=0 && k>0; i--) {
							if	( k>=powDiff[jptr])
							{
								c[i]=(char)(97+jptr+1);
								k-=powDiff[jptr];
							}
							else 
							{
								while(powDiff[--jptr]>k);
								c[i]=(char)(97+jptr+1);
								k-=powDiff[jptr];
							}
						}
						if (k==0)
							out.println(new String(c));
						else
							out.println(-1);
					}
					out.flush();
				}
	}
}
