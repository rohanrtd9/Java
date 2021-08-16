package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Euler29A {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is number n
		int n=Integer.parseInt(st.nextToken());
		
		//this is the number of toll or deduction from n-1 square
		// that we will have 0-N
		int primes[]=new int [n+1];
		
		//max possible unique terms
		long result=((long)n-1)*(n-1);
		
		//this is toll terms that we have
		long toll=0;
		
		Euler29A.primeSieve(primes);
		
		Map<Integer,Integer> valMap=new HashMap<>();
		Set<Long> dist=new HashSet<>();
		for (int i = 2; i <=n; i++) {
			dist.add((long)i);
		}
		for (int i = 2; Math.pow(2, i) < primes.length; i++) {
			dist.add((long)i*(n-1));
		}
		out.println(result);
		
		out.flush();
	}
	private static void primeSieve(int a[])
	{	// a[i]==0 is prime a[i]==1 isn't 
		//0 and 1 arent primes
		a[0]=a[1]=1;
		//all multiples of 2 aren't prime
		for (int i = 4; i < a.length; i+=2) {
			a[i]=1;
		}
		
		for (int i = 3; i <=Math.sqrt(a.length); i+=2) {
			for (int j = i*i; j < a.length; j+=(2*i)) {
				a[j]=1;
			}
		}
	}
}