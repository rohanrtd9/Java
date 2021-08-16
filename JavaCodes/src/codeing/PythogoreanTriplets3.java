package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PythogoreanTriplets3 {
	public static void main(String[] args) {
		PythogoreanTriplets3 pt= new PythogoreanTriplets3();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc = Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				int n= Integer.parseInt(br.readLine());
				System.out.println(pt.getPythoProduct(n));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private int getPythoProduct(int n)
	{
		//this function returns the pythogorean triplet product
		int product=-1;
		for (int b = 1; b < n/2; b++) {
			double a=((n*n)-(2*n*b))/(2.0*(n-b));
			if(a%1==0.0)
			{
				int c=(int)Math.sqrt((a*a)+(b*b));
				product=(int) ((a*b*c>product)?a*b*c:product);
			}
				
		}
		return product;
	}
}
