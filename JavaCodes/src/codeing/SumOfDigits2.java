package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SumOfDigits2 {
	public static void main(String[] args){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//this array contains the factorial of first ten digits

		SumOfDigits2 sf=new SumOfDigits2();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int q;
		try {
			q = Integer.parseInt(br.readLine());
			while(q-->0)
			{	StringTokenizer st= new StringTokenizer(br.readLine());
				int n=Integer.parseInt(st.nextToken());
				int m=Integer.parseInt(st.nextToken());
				System.out.println(sf.sumOfDigitCalc(n, map)%m);
		
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private int sumOfDigitCalc(int n,Map<Integer, Integer> map)
	{
		int sum=0;
		for (int i = 1; i <=n; i++) {
			//calculate gi here and replace
			int gi=this.giCalc(i);
			sum+=this.sod(gi);
		}
		return sum;
	}
	private int fn(int n)
	{	//this function is used to return the factorial of digits of n
		//this array contains the factorial of first ten digits
		int facts[]= {1,1,2,6,24,120,720,5040,40320,362880};
		int sum=0;
	while(n>0)
		{
			sum+=facts[n%10];
			n/=10;
		}
	return sum;
	}
	private int sfn (int n)
	{
		int sumFactDigits=this.fn(n);
		return this.sod(sumFactDigits);
	}
	
	private int sod(int n)
	{
		//this funtion returns the sum of digits
		int sum=0;
		while(n>0)
		{
			sum+=n%10;
			n/=10;
			
		}
		return sum;
	}
	private int giCalc(int n)
	{
		for (int i = 1; true; i++) {
			if (this.sfn(i)==n)
				return i;
		}
	}
}
