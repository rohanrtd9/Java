package codeing;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sumOfDigits {
public static void main(String[] args) throws Exception {
	sumOfDigits sf=new sumOfDigits();
	int factorial[]=sf.factorialArray();
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	int q=Integer.parseInt(br.readLine());
	
	while(q-->0)
	{	StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int res=sf.sumOfFactCalculator(n, factorial);
		System.out.println(res%m);
	}
}
private int sumOfFactCalculator(int n, int factorial[])
	{
		int sum=0;
		for (int i = 1; i <= n; i++) {
			sum+=this.gi(i, factorial);
		}
		return sum;
	}
private int fn(int a,int factorial[])
	{//this function returns the sum of factorial of digits of the given number
		int sum=0;
		while(a>0)
		{
			sum+=factorial[a%10];
			a/=10;
		}
		return sum;
	}
private int sfn(int a,int factorial[])
	{
		//this function returns the sum of digits of given number
		int sum=0;
		int aa=this.fn(a, factorial);
		while (aa>0)
		{
			sum+=aa%10;
			aa/=10;
		}
		return sum;
	}
private int gi(int a,int factorial[])
	{
		//this function returns the gi for the given a
	int i=1;
	int sfna=this.sfn(a, factorial);
	while(true)
	{
		int gi=this.sfn(i, factorial);
		if (gi==sfna)
			return i;
		i++;
	}
	}
private int[] factorialArray()
{
	//in this array we are storing index wise factorial as it will be easier than computing again and again
	int fact[]= new int[10];
	for (int i = 0; i < fact.length; i++) {
		fact[i]=this.factorial(i);
	}
	return fact;
	}
private int factorial(int a)
{// this function returns the factorial of the given number
	if (a<=1)
		return 1;
	return a*this.factorial(--a);
}
}
