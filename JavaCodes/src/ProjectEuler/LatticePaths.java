package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LatticePaths {
	public static void main(String[] args) throws Exception 
	{
		//importing io libraries
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is dimension of array
		int tc=Integer.parseInt(st.nextToken());
		//input array
		int n[][]= new int[tc][tc];
		//loop for parsing ints into array
		for (int i = 0; i < n.length; i++) 
		{
			st= new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n.length; j++) 
			{
				n[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
	}

}
