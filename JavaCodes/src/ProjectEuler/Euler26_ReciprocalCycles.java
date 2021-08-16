package ProjectEuler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

import ProjectEuler.Euler26_ReciprocalCycles.FastReader;



public class Euler26_ReciprocalCycles {
	public static void main(String[] args) 
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastReader in = new FastReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Solutions solver = new Solutions();
		int testCount = Integer.parseInt(in.next());
		int result[]= new int[10002];
		result[3]=3;
		int cc=3;
		
        for (int i = 4; i <= 10001; i++)
        {
            
            int a=solver.res(i);
            if(a>cc)
            {
                result[i]=i;
                cc=a;
            }
			else
			result[i]=result[i-1];	
		}
		
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out,result);
		out.close();
	}

	static class Solutions 
	{
		public void solve(int testNumber, FastReader in, PrintWriter out, int result[]) 
		{
		
			int n = in.nextInt();
			out.println(result[n-1]);
		}
		private int res(int n)
		{
			int d=1;
			//this function returns the cycle length in the given n
			int cyc[]=new int[20000];
			
			//this is digits that are after decimal
			int i=0;
			while (d!=0) {
				d*=10;
				while(d<n && i < cyc.length) 
					{
						d*=10;
						cyc[i++]=0;
					}
				if (i >= cyc.length)
					break;
				cyc[i++]=d/n;
				d=d%n;
			}
			//now what we do is start from index zero with turtle and hare
			boolean cycleNotDetected=true;
			int cycle=0;
			int turt=i-1;
			while(cycleNotDetected && turt>=0 )
			{
				int hare=turt- (int)(Math.log(n)+1);
				while(hare>=0 )
				{
					
					//then we traverse using turt and hare pointer comparing each of them at each and every step
					if(cyc[hare]==cyc[turt])
					{
						cycle=this.detectCycle(cyc, turt, hare);
						if (cycle>=0)
						{
							cycleNotDetected=false;
							break;
						}
					}
				hare--;
				}
				turt--;
			}
			return cycle;
		}
		private int detectCycle(int [] arr,int turt, int hare)
		{//this function returns true if it can detect cycle starting with the given turt value
			int cycle=0;
			int harePtr=hare;
			while(turt!=harePtr && hare>0)
			{
				cycle++;
				if (arr[--hare]!=arr[--turt])
					return -1;
			}
			//in case no cycle is detected we return -1
			return cycle;
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