package cses;





import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;



public class CoinCombination {
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastReader in = new FastReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solution1 solver = new Solution1();
		
		solver.solve(1, in, out);
		out.close();
	}

	static class Solution1 
	{
		public void solve(int testNumber, FastReader in, PrintWriter out) 
		{
			
			int n = in.nextInt(), x = in.nextInt();
			int[] a = in.readArray(n);
			int combs[]=new int[x+1];
			//root case basically telling that at zero we can make it in 1 way
			//by not picking any of the given numbers
			combs[0]=1;
			for (int i = 1; i < combs.length; i++) 
			{
				//combs[i] will be number of combination
				for (int nums : a) {
					if(i-nums>=0) {
						combs[i]+=combs[i-nums];
						combs[i]%=1000000007;
					}
				}
			}
			out.println(combs[x]);
			
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