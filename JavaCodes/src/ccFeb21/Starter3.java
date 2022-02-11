package ccFeb21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class Starter3 {
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
			char[] c =br.readLine().toCharArray();
			
			//in case of odd length we don't check any more
			if((n&1)==1)
			{
				out.println("NO");
				continue;
			}
			
			//this contains frequency of each character
			//since there are only 26 we can make a fix size array
			int freq[]= new int[26];
			//26*N= N
			for (int i = 0; i < c.length; i++) 
				freq[(int)c[i]-97]++;
			
			char result_string[]=new char[n];
			int ptr=0;
			
			//this flag is to terminate in case 
			//we find any value more than n/2
			boolean term_flag=false;
			for (int i = 0; i < freq.length; i++) {
				if(freq[i]>0)
				{
					//a*****b***c******d****
					//something like this we mark the result_string-temporary work String
					result_string[ptr]=(char)(i+97);
					ptr+=freq[i];
				}
				if(freq[i]>n/2)
				    term_flag=true;
				
			}
			if(term_flag==true)
			{
			    out.println("NO");
			    continue;
			}
			//next me mark the remainder with previous values
			//ie replace * with value before *
			for (int i = 1; i < result_string.length; i++) 
			    if(result_string[i]=='\u0000')
					result_string[i]=result_string[i-1];
			
			//now we flip the second half of the string
			
			int i=n/2,j=n-1;
			while(i<j)
			{
				char t=result_string[i];
				result_string[i++]=result_string[j];
				result_string[j--]=t;
				
			}
			
			out.println("YES");
			out.println(new String (result_string));
		}
		out.flush();
	}
}
