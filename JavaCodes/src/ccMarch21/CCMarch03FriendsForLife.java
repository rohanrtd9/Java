package ccMarch21;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;


public class CCMarch03FriendsForLife {
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
			int n = in.nextInt(), e = in.nextInt(), h = in.nextInt();
			int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
			Map<String,Integer> pricePool=new HashMap<>();
			out.println(this.returnPrice(n, e, h, a, b, c, 0, pricePool));
		}
		private int returnPrice(int n,int e,int h, int a, int b, int c,int sum,Map<String,Integer> pricePool)
		{
			String key=n+","+e+","+h;
			if(pricePool.containsKey(key))
				return pricePool.get(key);
			//this function returns the minimum sum that can serve all the folks
			//if friends ==0 then return the sum
			if (n==0)
				return sum;
			else 
			{
				int priceOmelette=-1;
				int priceChocoBar=-1;
				int priceChocoCake=-1;
				//else we can order stuff
				
				//lets order omelette
				// we reduce order by 1, eggs by 2 and add a to sum
				if(e>1)
					priceOmelette=this.returnPrice(n-1, e-2, h, a, b, c, sum+a,pricePool);
				
				//then we order milkshake
				//we reduce order by 1 choco bar by 3 and add b to sum
				if(h>2)
					priceChocoBar=this.returnPrice(n-1, e, h-3, a, b, c, sum+b,pricePool);
				
				//then we order choco cake
				//we reduce order by 1 choco bar by 1 and egg by 1 and add c to sum
				if(e>0 && h>0)
					priceChocoCake=this.returnPrice(n-1, e-1, h-1, a, b, c, sum+c,pricePool);
				
				int t=Integer.MAX_VALUE;
				if (priceOmelette>0)
					t=Math.min(t, priceOmelette);
				if (priceChocoBar>0)
					t=Math.min(t, priceChocoBar);
				if (priceChocoCake>0)
					t=Math.min(t, priceChocoCake);
				if(t==Integer.MAX_VALUE)
					t=-1;
				pricePool.put(key, t);
				return t;
				
			}
			
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