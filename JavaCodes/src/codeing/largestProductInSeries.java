package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class largestProductInSeries {

	public static void main(String[] args) {
		
		largestProductInSeries lps= new largestProductInSeries();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    int t;
		try {
			t = Integer.parseInt(br.readLine());
			for(int a0 = 0; a0 < t; a0++)
				{
	            	String s[]=br.readLine().split(" ");
	            	int k=Integer.parseInt(s[1]);
	            	String number=br.readLine();
	            	System.out.println(lps.maxProduct(number, k));
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private int maxProduct(String s,int k)
	{
		int product=0;
		char c[]=s.toCharArray();
		int startingIdx=0;
		while(startingIdx<=c.length-k)
			{
				int currentP=this.computeWindowProduct(startingIdx, startingIdx+k-1, c);
				product=currentP>product?currentP:product;
				startingIdx++;
				
			}
		return product;
	}
	private int computeWindowProduct(int s,int l, char c[])
	{
		int product=1;
		for (int i = s; i <=l; i++) {
			product*=((int) c[i]-(int) '0');
		}
		return product;
	}
}
