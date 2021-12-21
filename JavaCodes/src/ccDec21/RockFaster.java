package ccDec21;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;



public class RockFaster {
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
			
			int n = in.nextInt();
			char[] c = in.next().toCharArray();
			Map<String,Character> mp=new HashMap<>();
			char output[]=new char[n];
			for (int i = 0; i < c.length; i++) {
				String key=c[i]+"_"+i;
				if( mp.containsKey(key))
					output[i]=mp.get(key);
				else
					output[i]=this.getWinner(c, i, mp, c[i]);
					
			}
			out.println(new String(output));
			
		}
		private char getWinner(char c[],int i, Map<String,Character> mp,char crr)
		{
			if(i==c.length-1)
				return crr;
			String key=crr+"_"+i;
			if(mp.containsKey(key))
				return mp.get(key);
			else
			{
				char curWinner;
				if (this.computeWinner(crr, c[i+1]))
					curWinner=crr;
				else
					curWinner=c[i+1];
				String key1=curWinner+"_"+(i+1);
				
				
				char c1;
				if(mp.containsKey(key1))
				{
					c1=mp.get(key1);
					mp.put(crr+"_"+i, c1);
					return c1;
				}
				else 
				{
					c1=this.getWinner(c, i+1, mp, curWinner);
					
					mp.put(crr+"_"+i, c1);
					return c1;
				}
				
			}
			
		}
			
			
		
		private boolean computeWinner(char c1,char c)
		{
			//this fucntion returns true if c1 beats c
			if(c1=='R' && c=='P')
				return false;
			if(c1=='P' && c=='S')
				return false;
			if(c1=='S' && c=='R')
				return false;
				
			return true;
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