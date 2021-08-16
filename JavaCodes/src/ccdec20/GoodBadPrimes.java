package ccdec20;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;



public class GoodBadPrimes {
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastReader in = new FastReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		GoodTuples solver = new GoodTuples();
		int testCount = Integer.parseInt(in.next());
		
		//these are the primes in an array
		
		int primes[]=new int[1000000+2];
		primes[0]=1;
		primes[1]=1;
		
		for (int j = 4; j < primes.length; j+=2) {
				primes[j]=1;
		}
		
		for (int i = 3; i <= 1000; i+=2) {
			for (int j = i*i; j < primes.length; j+=(2*i)) {
				primes[j]=1;
			}
		}
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out,primes);
		out.close();
	}

	static class GoodTuples
	{
		public void solve(int testNumber, FastReader in, PrintWriter out,int[] primes) 
		{
	
			int n = in.nextInt();
			int a,b;
			int c=0;
			//for in range n
			
				a=2;
				for (int j = 3; j <=n; j+=2) 
				{
				if(primes[j]==1)
					continue;
				b=j;
				if(a+b<=n)
					{
					if (primes[a+b]==0)
						c++;
					}
				}
				
			
			
			out.println(c);
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