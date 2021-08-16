package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class sumOfDigits3 {
public static void main(String[] args) {
	//this map saves the g(as we find them and when needed furthur it is retrived from here)
	driver drv= new driver();
	sumOfDigits3 sf=new sumOfDigits3();
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	int q;
	try {
		q = Integer.parseInt(br.readLine());
		while(q-->0)
		{	StringTokenizer st= new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			System.out.println(sf.sumGi(n, drv)%m);	
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	private int sumGi(int n,driver drv)
	{	int sum=0;
		for (int i = 1; i <= n; i++) {
			if(drv.map.containsKey(i))
				sum+=drv.map.get(i);
			else
				sum+=this.giCalc(i, drv);
		}
		return sum;
	}
	private int giCalc(int in, driver drv)
	{	
		for (; true; drv.currentPtr++) {
			int sfnOfi=this.sfn(drv.currentPtr);
			if (!drv.map.containsKey(sfnOfi))
				drv.map.put(sfnOfi, sod(drv.currentPtr));
			if (sfnOfi==in)
				return sod(drv.currentPtr);
		}
		
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
}
class driver
	{
	int currentPtr;
	Map<Integer, Integer> map;
	public driver() {
		// TODO Auto-generated constructor stub
		currentPtr=1;
		map=new HashMap<Integer, Integer>();
	}
}
