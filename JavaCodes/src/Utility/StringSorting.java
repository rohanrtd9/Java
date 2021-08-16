package Utility;

public class StringSorting {
	public static void main(String[] args) {
		String s[]= {"a","aa","ab","aab"};
		StringSorting ss= new StringSorting();
		ss.sortAscend(s);
		for (String string : s) {
			System.out.println(string);
		}
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
