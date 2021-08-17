package codeing;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class multiplesOf3And5 {
	public static void main(String[] args) {
		multiplesOf3And5 mp=new multiplesOf3And5();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc= Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				long n=Long.parseLong(br.readLine());
				n--;
				long sum3=mp.sumOfAp(3, n/3, 3);
				long sum5=mp.sumOfAp(5, n/5, 5);
				long sum15=mp.sumOfAp(15, n/15, 15);
				long summ=(sum3+sum5)-sum15;
				System.out.println(summ);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private long sumOfAp(int a, long n , int d)
	{
		//here n is the last term of the given gp
		long sum=0;
		long tc=n*(2*a + (n-1)* d);
		sum=tc!=0?tc/2:0;
		return sum;
	}

}
