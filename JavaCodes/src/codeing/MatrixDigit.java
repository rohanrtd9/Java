package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixDigit {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc=Integer.parseInt(br.readLine());
			if (tc==1)
			{
				int n=Integer.parseInt(br.readLine());
				int a[][]=new int[2][2];
				if(n>9)
				{
					a[0][0]=9;
					n-=9;
				}if(n>9)
				{
					a[0][1]=9;
					n-=9;
				}if(n>9)
				{
					a[1][0]=9;
					n-=9;
				}
				a[1][1]=n;
				
				//for printing the given array
				for (int i = 0; i < a.length; i++) {
					for (int j = 0; j < a.length; j++) {
						System.out.print(a[i][j]);
					}
					System.out.println();
				}
			}
			else 
			{
				int a[][]= new int[tc][tc];
				int n[][]= new int [tc+1][tc+1];
				
				for (int i = 0; i < a.length; i++) 
				{
					String s[]=br.readLine().split(" ");
					for (int j = 0; j < s.length; j++) 
					{
						a[i][j]=Integer.parseInt(s[j]);
					}
				}
				
				for (int i = 1; i < n.length-1; i++) 
				{
					int j=i,k=i;
					{
						//this is the pivot element
						n[j][k]=	( a[j][k]+a[j][k-1]+a[j-1][k-1]+a[j-1][k] )	/16;
						n[j-1][k]= ( ( a[j-1][k]+ a[j-1][k-1] )/4)-n[j][k];
						n[j][k-1]= ( ( a[j][k-1]+ a[j-1][k-1] )/4)-n[j][k];
					}	
					for (int j1 = j-2; j1 >0; j1-=2) 
					{
						n[j1][k]=	( a[j1][k]+a[j1][k-1]+a[j1-1][k-1]+a[j1-1][k] )	/16;
						n[j1-1][k]= ( ( a[j1-1][k]+ a[j1-1][k-1] )/4)-n[j1][k];
						n[j1][k-1]= ( ( a[j1][k-1]+ a[j1-1][k-1] )/4)-n[j1][k];
					}
					for (int k2 = k-2; k2 >0; k2-=2) 
					{
						//this is the pivot element
						n[j][k2]=	( a[j][k2]+a[j][k2-1]+a[j-1][k2-1]+a[j-1][k2] )	/16;
						n[j-1][k2]= ( ( a[j-1][k2]+ a[j-1][k2-1] )/4)-n[j][k2];
						n[j][k2-1]= ( ( a[j][k2-1]+ a[j-1][k2-1] )/4)-n[j][k2];
					}
					if((i+1)<n.length)
					{
						n[j+1][k]= ( ( a[j][k-1]+ a[j][k] )/4)-n[j][k];
						n[j][k+1]= ( ( a[j-1][k]+ a[j][k] )/4)-n[j][k];
						n[j+1][k-1]= a[j][k-1]-n[j+1][k]-n[j][k-1]-n[j][k];
						n[j-1][k+1]= a[j-1][k]-n[j-1][k]-n[j][k+1]-n[j][k];
						n[j+1][k+1]=a[j][k]-n[j][k]-n[j+1][k]-n[j][k+1];
						//yaha se karo
						for (int j1 = j-2; j1 >0; j1-=2) 
						{
							n[j1+1][k]= ( ( a[j1][k-1]+ a[j1][k] )/4)-n[j1][k];
							n[j1][k+1]= ( ( a[j1-1][k]+ a[j1][k] )/4)-n[j1][k];
							n[j1+1][k-1]= a[j1][k-1]-n[j1+1][k]-n[j1][k-1]-n[j1][k];
							n[j1-1][k+1]= a[j1-1][k]-n[j1-1][k]-n[j1][k+1]-n[j1][k];
						}
						for (int k2 = k-2; k2 >0; k2-=2) 
						{
							//this is the pivot element
							//update pivot
							n[j+1][k2]= ( ( a[j][k2-1]+ a[j][k2] )/4)-n[j][k2];
							n[j][k2+1]= ( ( a[j-1][k2]+ a[j][k2] )/4)-n[j][k2];
							n[j+1][k2-1]= a[j][k2-1]-n[j+1][k2]-n[j][k2-1]-n[j][k2];
							n[j-1][k2+1]= a[j-1][k2]-n[j-1][k2]-n[j][k2+1]-n[j][k2];
						}
						
					}
				}
				n[0][0]=a[0][0]-n[1][1]-n[0][1]-n[1][0];
				//for printing the given array
				for (int i = 0; i < n.length; i++) {
					for (int j = 0; j < n.length; j++) {
						System.out.print(n[i][j]);
					}
					System.out.println();
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
