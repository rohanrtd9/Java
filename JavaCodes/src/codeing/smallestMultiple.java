package codeing;

import java.util.Scanner;

public class smallestMultiple {
	public static void main(String[] args) {
		smallestMultiple sm= new smallestMultiple();
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(sm.lcm(n));
            
        }
        
	}
	private int lcm(int n)
	{
		int primes[]= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		int values[]= {0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0};
		int lcm=1;
		for (int i = 2; i <= n; i++) {
			int currentN=i;
			while(currentN>1)
			{
				for (int j = 0; j < primes.length; j++) {
					int valuesPrime=0;
					while(currentN%primes[j]==0)
					{
						valuesPrime+=1;
						currentN/=primes[j];
					}
					if (values[j]<valuesPrime)
						values[j]=valuesPrime;
				}
			}
		}
		for (int i = 0; i < values.length; i++) {
			if(values[i]!=0)
				lcm*=Math.pow(primes[i], values[i]);
		}
		return lcm;
	}

}
