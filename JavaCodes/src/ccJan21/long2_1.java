package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class long2_1 {
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
			
			int box[][]=new int[3][3];
			st= new StringTokenizer(br.readLine());
			
			box[0][0]=Integer.parseInt(st.nextToken());
			box[0][1]=Integer.parseInt(st.nextToken());
			box[0][2]=Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			
			box[1][0]=Integer.parseInt(st.nextToken());
			box[1][1]=Integer.parseInt(st.nextToken());
			box[1][2]=Integer.parseInt(st.nextToken());
			
			st= new StringTokenizer(br.readLine());
			
			box[2][0]=Integer.parseInt(st.nextToken());
			box[2][1]=Integer.parseInt(st.nextToken());
			box[2][2]=Integer.parseInt(st.nextToken());
			
			out.println(((n-box[0][0])+(n-box[1][1])+(n-box[2][2]))/2);
		}
		out.flush();
	}
}
