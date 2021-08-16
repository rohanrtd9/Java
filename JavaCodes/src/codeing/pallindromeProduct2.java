package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class pallindromeProduct2 {
	public static void main(String[] args) {
		pallindromeProduct2 pp = new pallindromeProduct2();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc= Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				Integer n=Integer.parseInt(br.readLine());
				System.out.println(pp.getPall(n));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private int getPall(int n)
	{	
		for (--n; n >100000; n--) {
			if (this.isPallindrome(n))
			{
				for (int j = 100; j < 1000; j++) {
					if (n%j==0)
					{
						if (n/j<1000)
							return n;
					}
				}
			}
		}
		return 0;
	}
	private boolean isPallindrome(int n)
	{	
		StringBuilder sb=new StringBuilder();
		String st=sb.append(n).toString();
		String str=sb.reverse().toString();
		return st.equals(str);
	}
}
