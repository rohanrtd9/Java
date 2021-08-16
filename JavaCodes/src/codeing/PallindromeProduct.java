package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PallindromeProduct {
	public static void main(String[] args) {
		PallindromeProduct pp = new PallindromeProduct();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer tc= Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				int n=Integer.parseInt(br.readLine());
				System.out.println(pp.getMultiplePallindrome(n));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private int largestPallindrome(Integer n)
	{
		//this function returns the largest pallindrome just smaller than this number
		n--;
		char c[]=n.toString().toCharArray();
		if	(	(int)	c[5]	>	(int) c[0])
		{
			c[5]= c[0]; 
		}
		else
		{
			if	(	(int)	c[4]	>	(int) c[1])
			{
				c[4]=c[1];
				c[5]=c[0];
			}
			else
			{
				if	(	(int)	c[3]	>	(int) c[2])
				{
					c[3]=c[2];
					c[4]=c[1];
					c[5]=c[0];
				}
				else
				{
					if (c[2]=='0')
					{
						if (c[1]=='0')
						
						{
							c[0]-=1;
							c[5]=c[0];
							c[1]=c[2]=c[3]=c[4]='9';
						}
						else
						{
							c[1]-=1;
							c[4]=c[1];
							c[5]=c[0];
							c[2]=c[3]='9';
						}
					}
					else
					{
						c[2]-=1;
						c[3]=c[2];
						c[4]=c[1];
						c[5]=c[0];
					}
				}
				
			}
		}
		String s="";
		for (int i = 0; i < c.length; i++) {
			s=s+c[i];
		}
		return Integer.parseInt(s);
	}
	private int getMultiplePallindrome(int n)
	{	int currentPallindrome=n;
		do {
			currentPallindrome=this.largestPallindrome(currentPallindrome);
		} while (!this.isMultiThreeDigit(currentPallindrome));
		return currentPallindrome;
	}
	private boolean isMultiThreeDigit(int n)
	{
		for (int i = 101; i < 1000; i++) {
			if (n%i==0 && (n/i)<1000)
				return true;
				
		}
		return false;
	}
}
