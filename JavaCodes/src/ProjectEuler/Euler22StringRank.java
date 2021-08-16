package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Euler22StringRank {
	
	public static void main(String[] args)throws Exception
	{
		Euler22StringRank sr= new Euler22StringRank();
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
				
		//this is number of test cases
		int tc=Integer.parseInt(st.nextToken());
		String s[]= new String[tc];
				
		//loop for doing coding 
		while(tc-->0)
		{
			s[tc]=br.readLine();
		}
		sr.sortAscend(s);
		//this is number of test cases
		st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			String name=br.readLine();
			for (int j = 0; j < s.length; j++) {
				if(s[j].equals(name))
				{
					System.out.println(sr.getStringRank(s[j])*(j+1));
					break;
				}
			}
		}
	}
	private int getStringRank(String s)
	{
		int pow=0;
		char c[]=s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			pow+=(int)c[i]-(int)'A'+1;
		}
		return pow;
	}

	private void sortAscend(String s[])
	{
		//this sorts ascending 
		for (int i = 0; i < s.length-1; i++) {
			int min=i;
			for (int j = i+1; j < s.length; j++) {
				if(this.compareStrings(s[j], s[min])==true)
					min=j;
			}
			if (min!=i)
			{
				String temp=s[min];
				s[min]=s[i];
				s[i]=temp;
			}
		}
	}
	private boolean compareStrings(String s1,String s2)
	{
		//this returns true of s1 is lexicographically before or equal to s2
		char c1[]=s1.toCharArray();
		char c2[]=s2.toCharArray();
		boolean isLess=false;
		for (int i = 0; i < c2.length && i < c1.length; i++) {
			if((int)c1[i]>(int) c2[i])
				return false;
			if((int)c1[i]<(int) c2[i])
				return true;
			if (i==c1.length-1 ||i==c2.length-1)
				isLess=true;
				
		}
		if (isLess && c1.length>c2.length)
			return false;
		return true;
	}
}
