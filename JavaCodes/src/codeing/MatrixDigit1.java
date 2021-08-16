package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class MatrixDigit1 {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int n=Integer.parseInt(br.readLine());
			int a[][]= new int [n]  [n]  ;
			int b[][]= new int [n+1][n+1];
			for (int i = 0; i < a.length; i++) 
			{	
				String s[]=br.readLine().split(" ");
				for (int j = 0; j < b.length; j++) 
				{
					a[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insertArr(int n[][],int a[][],int i, int j,int val)
	
	{
		int A=val;
		if(A+n[i+1][j+1]<=9)
		{
			//try fitting in downmost right
			n[i+1][j+1]+=A;
			
		}
		else if ( A+n[i+1][j+1]+n[i+1][j]<=18)
		{//try fitting down left and setting that the cell to left is unbalanced
			int partA,partB;
			partB=9-n[i+1][j+1];
			partA=A-partB ;
			
			while (! this.BalanceCell(a, n, i-1, j))
			{
					partB--;
					partA++;	
			}
			
			n[i+1][j]+=partA;
			n[i+1][j+1]+=partB;
			
		}
		else if(A + n[i+j][j+1] + n[i+1][j] + n[i][j+1] <=27)
		{
			n[i+1][j+1]+=A/3;
			//here we check for down both and upper right
		}
		
	}
	private boolean BalanceCell(int a[][],int n[][],int i,int j)
	{
		return true;
	}
}
class Coord
{
	int i,j;}
