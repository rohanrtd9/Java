package ccJan21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class exun3 {

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
			LinkedList <Integer> nums= new LinkedList <>();
			
			nums.add(1);
			int currentWinner=1;
			int lastWinner=1;
			out.print(lastWinner+" ");
			for (int i = 1; i < x; i++) {
				
					if( (m-1)%x>x)
					{
						out.print(lastWinner+" ");
						continue;
					}
					nums.add(i+1);
					
					int idx=(m-1)%nums.size();
					int t=nums.remove( idx);
					
					currentWinner=nums.get(lastWinner-1);
					out.print(currentWinner+" ");
					nums.add(idx, t);
					lastWinner=currentWinner;
			
			
		}
		out.print("\n");
		out.flush();
	}
	}
}