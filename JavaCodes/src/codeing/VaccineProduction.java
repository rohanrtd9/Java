package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VaccineProduction {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			String s[]=br.readLine().split(" ");
			int D1=Integer.parseInt(s[0]) , V1=Integer.parseInt(s[1]), D2=Integer.parseInt(s[2]);
			int V2=Integer.parseInt(s[3]),P=Integer.parseInt(s[4]);
			int dailySum=0;
			int currentDay=D1<D2?D1:D2;
			while(dailySum<P)
			{
				if(currentDay>=D1)
				{
					dailySum+=V1;
				}
				if(currentDay>=D2)
				{
					dailySum+=V2;
				}
				currentDay++;
			}
			System.out.println(--currentDay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}

