package ccdec20;

import java.util.BitSet;

public class test1 {
public static void main(String[] args) {
	
	test1 t= new test1();
	for (int i = 0; i < 10; i++) {
		t.intPow(i);
	}
	
	
}public int combo(int n, int r)
{
	int res=1;
	if (r<n/2)
		r=n-r;
	for (int i = r+1; i <= n; i++) {
		res=(int)(((double)res/(i-r))*i);
	}
	return res;
	}
private char[] intPow(int c)
{
	char cC[];
	String s="";
	while (c>0)
	{
		s=c%2+s;
		c/=2;
	}
	System.out.println(s);
	return s.toCharArray();
}
}
