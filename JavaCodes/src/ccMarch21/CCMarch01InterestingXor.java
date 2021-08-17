package ccMarch21;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;


public class CCMarch01InterestingXor {
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastReader in = new FastReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solution1 solver = new Solution1();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class Solution1 
	{
		public void solve(int testNumber, FastReader in, PrintWriter out) 
		{
			
			int c = in.nextInt();
			
			char cc[]=this.intPow(c);
			Map <String,Integer> val=new HashMap<>()
;			out.println(this.maxProd(0, cc, 0, 0,val));
			
		}
		private int  maxProd(int i,char cc[],int a,int b,Map <String,Integer> val)
		{
			String key="";
			
			if(a>b)
				key=a+","+b;
			else
				key=b+","+a;
			if(val.containsKey(key))
				return val.get(key);
			if (i>=cc.length)
			{
				val.put(key, a*b);
				return a*b;	
			}
				
			else
			{
				while(i<cc.length && cc[i]=='0' )
				{
					a+=Math.pow(2, cc.length-i-1);
					b+=Math.pow(2, cc.length-i-1);
					i++;
				}
				int a1= (int) (a+Math.pow(2, cc.length-i-1));
				int b1= (int) (b+Math.pow(2, cc.length-i-1));
				
				int m=maxProd(i+1,cc,a1,b,val);
				int n=maxProd(i+1,cc,a,b1,val);
				if(m>n)
				{
					if(a1>b)
						key=a1+","+b;
					else
						key=b+","+a1;
					val.put(key,m);
				}
				else
				{
					if(b1>a)
						key=b1+","+a;
					else
						key=a+","+b1;
					val.put(key,n);
				}
				return Math.max(m, n);
			}
				
			
		}
		private char[] intPow(int c)
		{
			
			String s="";
			while (c>0)
			{
				s=c%2+s;
				c/=2;
			}
			return s.toCharArray();
		}

	}

	static class FastReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private FastReader.SpaceCharFilter filter;

		public FastReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c)) c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public int[] readArray(int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++) array[i] = nextInt();
			return array;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);

		}

	}
}
