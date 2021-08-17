package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Euler19CountingSundays {
	public static void main(String[] args) throws Exception
	{
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int arr[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		int arrLeap[]= {31,29,31,30,31,30,31,31,30,31,30,31};
		Euler19CountingSundays ecs= new  Euler19CountingSundays();
		
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		
		//loop for doing coding 
		while(tc-->0)
		{
			st= new StringTokenizer(br.readLine());
			int year1=Integer.parseInt(st.nextToken());
			//System.out.println(year1);
			int month1=Integer.parseInt(st.nextToken());
			int day1=Integer.parseInt(st.nextToken());
			if (day1>1)
				month1++;
			st= new StringTokenizer(br.readLine());
			int year2=Integer.parseInt(st.nextToken());
			int month2=Integer.parseInt(st.nextToken());
			int day2=Integer.parseInt(st.nextToken());
			
			
			int sundayCount=0;
			while(year1<year2)
			{
				int dayAtYearStart=ecs.getDayAtYearStart(year1);
				if (dayAtYearStart==-1)
					dayAtYearStart=6;
				int cal[]=arr;
				//if year is leap we use array with feb of 28
				if(ecs.isLeapYear(year1))
				{
					cal=arrLeap;
				}
				//if we are not starting from first month
				if(month1!=1)
				{
					for (int i = 1; i < month1; i++)
					{
						dayAtYearStart=   (dayAtYearStart+cal[i-1])%7;
					}					
				}
				//we loop fron starting month to end of year
				for (int i = month1-1; i < 12; i++) 
				{
					
					if ( (dayAtYearStart)%7==6)
					{
						//System.out.println(year1+" "+i);
						sundayCount++;
					}
					dayAtYearStart+=cal[i];	
				}
				year1++;
				month1=1;
			}
			if (year1==year2)
			{
				int dayAtYearStart=ecs.getDayAtYearStart(year1);
				if (dayAtYearStart==-1)
					dayAtYearStart=6;
				int cal[]=arr;
				//if year is leap we use array with feb of 28
				if(ecs.isLeapYear(year1))
				{
					cal=arrLeap;
				}
				//we loop fron starting month to end of year
				for (int i = 0; i < month1-1; i++) 
				{
					
					dayAtYearStart+=cal[i];	
				}
				
				for (int i = month1-1; i <= month2-1; i++) 
				{
					
					if ( (dayAtYearStart)%7==6)
					{
						//System.out.println(year1+" "+i);
						sundayCount++;
					}
					dayAtYearStart+=cal[i];	
				}
			}
		System.out.println(sundayCount);
		}
	}
	
	private int getDayAtYearStart(long year)
	{
		//this function returns the day which is on the starting date
		if (year==1900l)
			return 0;
		long yearDiff=year-1900;
		long leaps=year>>2;
		int nintHund=1900>>2;
		nintHund-=1900/100;
		nintHund+=1900/400;
		leaps-=year/100;		
		leaps+=year/400;
		leaps=leaps-nintHund;
		int totalDays=(int)((yearDiff+leaps)%7);
		return this.isLeapYear(year)?totalDays-1:totalDays;
		
	}
	private boolean isLeapYear(long year)
	{
		if((year&3)==0)
		{
			if (	(year%100)!=0 || year%400==0)
				return true;
		}
		return false;
	}
}
