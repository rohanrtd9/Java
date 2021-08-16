package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fibonacciEvenSum {
public static void main(String[] args) {
	fibonacciEvenSum fc= new fibonacciEvenSum();
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	try {
		int tc= Integer.parseInt(br.readLine());
		while(tc-->0)
		{
			long n=Long.parseLong(br.readLine());
			System.out.println(fc.fiboSum(n));
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
private long fiboSum(long n)
{	long currentFibo=1;
	long prevFibo=1;
	long  fibo=currentFibo+prevFibo;
	long sum=0;
	while(n>fibo)
	{
		fibo=currentFibo+prevFibo;
		if( (fibo & 1) ==0)
		{
			sum+=fibo;
		}
		prevFibo=currentFibo;
		currentFibo=fibo;
		fibo=currentFibo+prevFibo;
	}
	return sum;
}
}
