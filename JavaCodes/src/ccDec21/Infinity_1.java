package ccDec21;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;



public class Infinity_1 {
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
			int[] a = in.readArray(n);
			int nc=0,pc=0;
			int min=0,minN=0;
			for (int i = 0; i < a.length; i++) {
			if(a[i]<0)
				nc++;
			else if (a[i]>0)
				pc++;
			}
			int negs[]=new int[nc];
			int pos[]=new int[pc];
			
			for (int i = 0,ncc=0,pcc=0; i < a.length; i++) {
				if(a[i]<0)
				{
					negs[ncc++]=a[i];
				}
				else if (a[i]>0)
				{	
					pos[pcc++]=a[i];
				}
			}
			
			if (pc>0)
			{
				//for positive values
				min=Integer.MAX_VALUE;
				for (int i = 0; i < pos.length; i++) {
					if(pos[i]<min)
						min=pos[i];
				}
				int min1=Integer.MAX_VALUE;
				while(true)
				{
					for (int i = 0; i < pos.length; i++) {
						if(pos[i]%min!=0)
						{
							if ((pos[i]%min)<min1)
							{
								min1=pos[i]%min;
							}
						}
					}
					
					if (min1==min || min1==Integer.MAX_VALUE)
						break;
					else
						min=min1;
				}
			}
			
			if(nc>0)
			{//for negative values
				minN=Integer.MAX_VALUE;
				for (int i = 0; i < negs.length; i++) {
					negs[i]=negs[i]*-1;
					if(negs[i]<minN)
						minN=negs[i];
				}
				int min1N=Integer.MAX_VALUE;
				while(true)
				{
					for (int i = 0; i < negs.length; i++) {
						if(negs[i]%minN!=0)
						{
							if ((negs[i]%minN)<min1N)
							{
								min1N=negs[i]%minN;
							}
						}
					}
					
					if (min1N==minN || min1N==Integer.MAX_VALUE)
						break;
					else
						minN=min1N;
				}}
			
			
			if(nc>0 && pc>0 && nc+pc==n)
				out.println(minN+ min);
			else if (nc>0 && pc==0)
				out.println(minN);
			else if (pc>0 && nc==0)
				out.println(min);
			else
				out.println(2*gcd(min,minN));
		}
		private int gcd(int a, int b) 
		{
			if (a==0)
				return b;
			if (b==0)
				return a;
			if (a>b)
				return gcd(a-b,b);
			else
				return gcd(a,b-a);
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