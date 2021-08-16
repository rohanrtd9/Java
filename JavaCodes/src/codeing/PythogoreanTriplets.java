package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythogoreanTriplets {
public static void main(String[] args) {
		PythogoreanTriplets pt= new PythogoreanTriplets();
	  BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
	  int  t; 
	  try 
	  { t = Integer.parseInt(br.readLine()); 
	  	for(int a0 = 0; a0 < t; a0++) 
	  		{
	  		int n=Integer.parseInt(br.readLine()); 
	  		System.out.println(pt.getPythoTriplets(n));
	  		} 
	  } 
	  catch (Exception e) 
	  { // TODO
		  e.printStackTrace(); 
	  }
	 
	}
private int getPythoTriplets(int n)
	{
		int triplet=-1;
		for (int i =3; i < n-2; i++) {
			int nbrs[][]=this.breakNumberDown(i);
			for (int j = 0; j < nbrs.length; j++) {
				int a=nbrs[j][0];
				int b=nbrs[j][1];
				if (this.isPythoTriplets(a, b, n-i))
				{
					if (a*b*(n-i)>triplet)
						System.out.println(a+" "+b+" "+(n-i));
						triplet=a*b*(n-i);
				}
			}
		}
		return triplet;
	}
private int[][] breakNumberDown(int n)
{
	//7 can be broken down like 1 6, 2 5, 3 4
	//6 can be broken down like 1 5, 2 4
	//5 can be broken down like 2 3, 1 4
	// 4 can be broken down like 1 3
	int nmbrs[][] = new int [(n-1)/2][2];
	int a=1;
	int b=n-a;
	for (int i = 0; a<b; i++,a++,b--) {
		nmbrs[i][0]=a;
		nmbrs[i][1]=b;
	}
	return nmbrs;
	}
private boolean isPythoTriplets(int a, int b,int c)
{
	return a*a+b*b==c*c;}
}
