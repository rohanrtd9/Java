package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class largeSum {
	public static void main(String[] args) {
		largeSum ls= new largeSum();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			int n=Integer.parseInt(br.readLine());
			char c[][]= new char[n][];
			for (int i = 0; i < n; i++) {
				c[i]=br.readLine().toCharArray();
			}
			System.out.println(ls.sumChars(c));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String sumChars(char numbers[][])
	{
		//int j = 49; j >=0; j++
		int carry=0;
		String sum="";
		for (int j = 49; j >=0; j--) {
			int rowSum=carry;
			for (int i = 0; i < numbers.length; i++) {
				rowSum+=(int) numbers[i][j]-(int)'0';
			}
			carry=rowSum/10;
			sum=(rowSum%10)+sum;
			
		}
		sum=carry+sum;
		return sum.substring(0,10);
	}

}
