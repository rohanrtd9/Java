package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Starter_4 {
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
			char[] s1=br.readLine().toCharArray();
			char[] s2=br.readLine().toCharArray();
			int val1[]=new int[n];
			int val2[]=new int[n];
			
			//we iterate from right to left and count zeroes
			int zc=0;
			for (int i = n-1; i >0; i--) 
				
				if(s1[i]=='0')
					zc++;
				else
					val1[i]=zc;
			
			//we iterate from right to left and count zeroes
			zc=0;
			for (int i = n-1; i >0; i--) 
				
				if(s2[i]=='0')
					zc++;
				else
					val2[i]=zc;
			
			for (int i = n-2; i >=0; i--) 
			{
				val1[i]+=val1[i+1];
				val2[i]+=val2[i+1];
			}
			
			int ptr1=0,ptr2=0;
			int ptrF=0;
			char res[]=new char[2*n];
			while(ptr1!=n && ptr2!=n)
			{
				if (s1[ptr1]=='0')
				{
					res[ptrF++]=s1[ptr1++];
				}
				else if (s2[ptr2]=='0')
				{
					res[ptrF++]=s2[ptr2++];
				}
				else
				{
					if (val1[ptr1]>val2[ptr2])
					
						res[ptrF++]=s1[ptr1++];
					else
						res[ptrF++]=s2[ptr2++];
				
				}
			}
			if(ptr1==n)
			{
				while(ptr2!=n)
				{
					res[ptrF++]=s2[ptr2++];
				}
			}
			if(ptr2==n)
			{
				while(ptr1!=n)
				{
					res[ptrF++]=s1[ptr1++];
				}
			}
				
			int vals[]=new int[2*n];
			zc=0;
			for (int i = (2*n)-1; i >= 0; i--) {
				if(res[i]=='0')
					zc++;
				else
					vals[i]=zc;
			}
			for (int i = (2*n)-2; i >= 0; i--) {
				
					vals[i]=vals[i]+vals[i+1];
			}
			out.println(vals[0]);
		}
		out.flush();
	}
}
