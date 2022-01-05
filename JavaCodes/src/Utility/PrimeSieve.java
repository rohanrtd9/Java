package Utility;

import java.util.Iterator;

public class PrimeSieve {
	public static void main(String[] args) {
		int arr[]=new int[100000000];
		PrimeSieve ps= new PrimeSieve();
		ps.returnPRines(arr);
		
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==0)
				System.out.println(i);
		}
		
	}
	private void returnPRines(int n[])
	{
		//this function will return primes after marking non primes with 1
		n[0]=1;
		n[1]=1;
		for (int i = 2; 2*i < n.length; i++) {
			n[i*2]=1;
			
		}
		for (int i = 3; 3*i < n.length; i+=2) {
			n[i*3]=1;
		
		}
		for (int i = 6; i < n.length; i+=6) 
		{
			if (n[i-1]==0)
			{for (int j = 2; (i-1)*j< n.length ; j++) {
				n[(i-1)*j]=1;}
			
			}
			if (n[i+1]==0)
			{for (int j = 2; (i+1)*j< n.length ; j++) 
				{
				n[(i+1)*j]=1;
				}
			
			}
			
		}
	}

}
