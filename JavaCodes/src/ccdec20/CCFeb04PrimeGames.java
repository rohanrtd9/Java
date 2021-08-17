package ccdec20;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;



public class CCFeb04PrimeGames {
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastReader in = new FastReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solution1 solver = new Solution1();
		int testCount = Integer.parseInt(in.next());
		int n[]=new int [1000001];
		solver.seive(n);
		
		
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out,n);
		
		out.close();
	}

	static class Solution1 
	{
		public void solve(int testNumber, FastReader in, PrintWriter out,int n[]) 
		{
			int x = in.nextInt(), y = in.nextInt();
			if(n[x]<y+1)
				out.println("Divyam");
			else
				out.println("Chef");
		}
		public void seive(int n[])
		{
			int limit=(int)Math.sqrt(n.length);
			for (int i = 2; i <= limit; i++) 
			{
				if(n[i]>0)
					continue;
				for (int j = i*i; j < n.length; j+=2*i) 
					n[j]++;
				
			}
			//this function seives the primes till given n
			//with a twist
			//here value will represent the max number of factors that
			//the given number has
			n[0]=1;
			n[1]=1;
			int primeCount=0;
			for (int i = 0; i < n.length; i++) {
				
				if(n[i]==0)
					primeCount++;
				n[i]=primeCount;
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
