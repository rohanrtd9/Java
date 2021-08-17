package ccdec20;


import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;




public class CCFED02FrogSort {
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
			int count = 0;
			int n = in.nextInt();
			int[] w = in.readArray(n);
			int[] l = in.readArray(n);
		
			int min=100;
			int minIdx=0;
			for (int i = 0; i < w.length; i++) 
			{
			//we select minimum element	
				if(min>w[i]	)
				{
					min=w[i];
					minIdx=i;
				}
					
			}
			
			for (int pass = 0; pass < n-1; pass++) 
			{
				
				int minSec=100;
				int minSecIdx=0;
				//this gives us second minimum
				for (int i = 0; i < w.length; i++) {
					
					if(w[i]>min && w[i]<minSec)
					{
						minSec=w[i];
						minSecIdx=i;
					}
						
				}
				int minSecCur=minSecIdx;
				while(minSecCur<=minIdx)
				{
					minSecCur+=l[minSecIdx];
					count++;
				}
				min=minSec;
				minIdx=minSecCur;
				//now we kick second minimum above minimum
			}
			
			out.println(count);
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