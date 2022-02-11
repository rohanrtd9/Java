package ccJan21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class exun5 {
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
			int m=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			
			//since there can be only winnners upto x
			
			//int[] numbers=new int[x+2];
			
			int [] winners=new int[x];
			int count=0;
			winners[count++]=1;

			for (int i = 1; i < x; i++) {

				int idx=(m-1)%(i+1);
				
				if (winners[i-1]-1<idx)
					winners[i]=winners[i-1];
				else
					winners[i]=winners[i-1]+1;
			}
		out.println(Arrays.toString(winners).replace("[", "").replace("]", "").replace(",", ""));
		out.flush();
	}
	}
}