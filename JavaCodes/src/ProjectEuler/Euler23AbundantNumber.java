package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Euler23AbundantNumber {
	public static void main(String[] args)throws Exception {
		ArrayList<Integer> abunNo=new ArrayList<Integer>();
		int arr[]= new int[100000+1];
		
		for (int i = 2; i*i<=100000; i++) {
			arr[i*i]+=i;
			for (int j = i+1; i*j<=100000 ; j++) {
				arr[i*j]+=j;
				arr[i*j]+=i;
			}
			
		}
		for (int i = 1; i < 100000; i++) {
			arr[i]+=1;
			if(arr[i]>i)
				abunNo.add(i);
		}
		
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());			
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());	
		
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());	
			Integer n=Integer.parseInt(st.nextToken());	
			boolean flag=false;
			for (int i = 0; i < abunNo.size(); i++)
			{
				int m=abunNo.get(i);
				if (m>n)
					break;
			    for (int j = i; j < abunNo.size(); j++)
			    {
			    	int p=abunNo.get(j);
			    	if(m+p>n)
			    		break;
			    	if(m+p==n)
			    	{
			    		flag=true;
			    		break;
			    	}
			    		
			        // do stuff
			    } 
			}
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
