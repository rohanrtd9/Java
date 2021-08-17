package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccjan04b {
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
					int k=Integer.parseInt(st.nextToken());
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					int xx=x;
					int yy=y;
					//int eX=n,eY=n;
					k--;
					k=k%4;
					int cords[][]= new int[4][2];
					if (yy>xx)
					{
						int temp=x;
						x=y;
						y= temp;
					}
					y=y+(n-x);
					x=n;
					cords[0][0]= x;
					cords[0][1]=y;
					
						x=n-(n-y);
						y=n;
						cords[1][0]= x;
						cords[1][1]=y;
	
						y=n-x;
						x=0;
						cords[2][0]= x;
						cords[2][1]=y;

							
						x=y;
						y=0;
						cords[3][0]= x;
						cords[3][1]=y;
					if (xx==yy)
					{
						System.out.println(n+" "+n);
					}
					else if (xx>yy)
					{
						System.out.println(cords[k][0]+" "+cords[k][1]);
					}
					else
					{
						int res=k&2;
						k++;
						int res2=k&1;
						k=res2|res;
						System.out.println(cords[k][0]+" "+cords[k][1]);
					}
						
				}
	}

}
