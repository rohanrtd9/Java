package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VaccineDistribution {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		VaccineDistribution vc= new VaccineDistribution();
		try {
			int tc=Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				String s[]=br.readLine().split(" ");
				int n=Integer.parseInt(s[0]);
				int d=Integer.parseInt(s[1]);
				int nmbrs[]=new int[n];
				s=br.readLine().split(" ");
				for (int i = 0; i < nmbrs.length; i++) {
					nmbrs[i]=Integer.parseInt(s[i]);
				}
				vc.splitSequence(nmbrs);
				int i=0;
				for (; i<nmbrs.length && (nmbrs[i]<=9||nmbrs[i]>=80); i++) ;
				int daysForRisk=(int)Math.ceil(i/(double)d);
				int daysNormal=(n-i)==0?0:(int)Math.ceil((n-i)/(double)d);
				System.out.println(daysForRisk+daysNormal);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void splitSequence(int n[])
	{
		int riskPtr=0;
		for (int i = 0; i < n.length; i++) {
			if(n[i]<=9 || n[i]>=80)
			{
				int temp=n[riskPtr];
				n[riskPtr]=n[i];
				n[i]=temp;
				riskPtr++;
				
			}
		}
	}
}
