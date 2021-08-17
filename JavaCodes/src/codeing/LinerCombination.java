package codeing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinerCombination {
	public static void main(String[] args) {
		LinerCombination lc= new LinerCombination();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			//number of factors of index number
			
			int tc=Integer.parseInt(br.readLine());
			String s[]=br.readLine().split(" ");
			int a[]=new int[tc];
			for (int i = 0; i <tc; i++) 
			{
				a[i]=Integer.parseInt(s[i]);
				
				
			}
			System.out.println(lc.prod(a, 0, 0, 0));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private long prod(int a[],int i,int cptr,long curSum)
	{
		
		int sum=0;
		if (cptr==a.length-1) 
		{
			for (int j = i; j < 239 ; j++)
			{
				if((curSum+ (a[cptr]*j) ) %239 ==0 )
				{
					sum++;
				}
			}
		}
		else
		{
			for (int j = i; j < 239; j++) {
				long prod=1;
				prod*=this.prod(a, (j+1), (cptr+1), curSum+ ( a[cptr] * j ) );
				sum+=prod;
			}
		}
			
		return sum;
	}
}
