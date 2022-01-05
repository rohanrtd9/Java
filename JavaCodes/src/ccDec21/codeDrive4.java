package ccDec21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class codeDrive4 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		codeDrive4 cc= new codeDrive4();
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());

		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			//this is number of test cases
			int n=Integer.parseInt(st.nextToken());
			int maxDiv=0;
			int res=n;
			int primes[]=new int[(int)Math.sqrt(n)];
			cc.returnPRines(primes);
			for (int i = 0; i < primes.length; i++) {
				if (primes[i]==0)
				{if(n%i==0)
				{
					if(cc.countDivisors(n)>maxDiv)
						res=i;
				}
				}
			}
			
			out.println(res);
		}
		out.flush();
	}
	private int countDivisors(int n)
    {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
               
                if (n / i == i)
                	count++;
 
                else
                	count = count + 2;
            }
        }
        return count;
    }
	private void returnPRines(int n[])
	{
		//this function will return primes after marking non primes with 1
		n[0]=1;
		n[1]=1;
		for (int i = 2; 2*i < n.length; i++) {
			n[i*2]=1;
			
		}
		for (int i = 3; 3*i < n.length; i+=2) {
			n[i*3]=1;
		
		}
		for (int i = 6; i < n.length; i+=6) 
		{
			if (n[i-1]==0)
			{for (int j = 2; (i-1)*j< n.length ; j++) {
				n[(i-1)*j]=1;}
			
			}
			if (n[i+1]==0)
			{for (int j = 2; (i+1)*j< n.length ; j++) 
				{
				n[(i+1)*j]=1;
				}
			
			}
			
		}
	}
}
