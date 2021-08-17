package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Pythogoreantriplets2 {
	public static void main(String[] args) {
		Pythogoreantriplets2 pt= new Pythogoreantriplets2();
		
	
	  BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
	  int t; 
	  try 
	  { t = Integer.parseInt(br.readLine()); 
	  	for(int a0 = 0; a0 < t; a0++) 
	  		{
	  		int n=Integer.parseInt(br.readLine()); 
	  		System.out.println(pt.squaresTillN(n));
	  		} 
	  } 
	  catch (Exception e) 
	  { // TODO
		  e.printStackTrace(); 
	  }
	  
	 
	}
	
	private int squaresTillN(int n)
	{
		//this function returns the numbers whose sum of squares is less than n
		int product=-1;
		for (int i = 1; i < Math.sqrt(n); i++) {
			for (int j=i+1; (i*i)+(j*j)<n; j++) {
				int prime=Math.sqrt((n-(i*j)))%1==0?(int)Math.sqrt((n-(i*j))):0;
				System.out.println(i+" "+j+" "+prime);
				
				
			}
		}
		
		return product;
	}
	
}
