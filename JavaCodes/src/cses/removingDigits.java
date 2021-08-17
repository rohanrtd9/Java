package cses;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;




public class removingDigits {public static void main(String[] args) 
{
	InputStream inputStream = System.in;
	OutputStream outputStream = System.out;
	FastReader in = new FastReader(inputStream);
	PrintWriter out = new PrintWriter(outputStream);
	Solution1 solver = new Solution1();
	int n = Integer.parseInt(in.next());
	solver.solve(n, in, out);
	out.close();
}

static class Solution1 
{
	public void solve(int number, FastReader in, PrintWriter out) 
	{
		int inf = 1000;
		Map<Integer,Integer> mp=new HashMap<>();
	
		
		out.print(number);
	}
	private int getSteps(int n,Map<Integer,Integer> mp)
	{
		if(mp.containsKey(n))
			return mp.get(n);
		return 0;
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