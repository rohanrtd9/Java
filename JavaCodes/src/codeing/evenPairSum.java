package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class evenPairSum {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc=Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				String s[]=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int oddA=(int)Math.ceil(a/2.0);
				int evenA=a/2;
				int b=Integer.parseInt(s[1]);
				int oddB=(int)Math.ceil(b/2.0);
				int evenB=b/2;
				long oddNo=((long)oddA)*oddB;
				long evenNo=((long)evenA)*evenB;
				System.out.println((oddNo+evenNo));
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


