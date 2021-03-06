package ccDec21;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;




public class lt03OptimalSorting {
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
				
				int []aSorted=a.clone();
				
				//first we sort the array
				this.quickSort(aSorted, 0, n-1);
				
				//now we find outta place numbers 
				
				//this is our result
				int res=0;
				
				int ptr=0;
				while(ptr<n)
				{
					//if element is in place then all good
					if(a[ptr]==aSorted[ptr])
						{
						ptr++;
						continue;
						}
					int jPtr=ptr;
					int max=a[ptr];
					int maxIter=max;
					int min=aSorted[ptr];
					do {
					while( max>aSorted[++jPtr]);					
					maxIter=max;
					for (int i = ptr; i <= jPtr; i++) {
						if(a[i]>max)
							max=a[i];
					}
					}while(maxIter!=max);
					res+=max-min;
					ptr=++jPtr;
				}
				
				
				out.println(res);
				}
			private int partition(int arr[], int low, int high)
		    {
		        int pivot = arr[high]; 
		        int i = (low-1); // index of smaller element
		        for (int j=low; j<high; j++)
		        {
		            // If current element is smaller than or
		            // equal to pivot
		            if (arr[j] <= pivot)
		            {
		                i++;
		  
		                // swap arr[i] and arr[j]
		                int temp = arr[i];
		                arr[i] = arr[j];
		                arr[j] = temp;
		            }
		        }
		  
		        // swap arr[i+1] and arr[high] (or pivot)
		        int temp = arr[i+1];
		        arr[i+1] = arr[high];
		        arr[high] = temp;
		  
		        return i+1;
		    }
		  
		  
		    /* The main function that implements QuickSort()
		      arr[] --> Array to be sorted,
		      low  --> Starting index,
		      high  --> Ending index */
		    private void quickSort(int arr[], int low, int high)
		    {
		        if (low < high)
		        {
		            /* pi is partitioning index, arr[pi] is 
		              now at right place */
		            int pi = partition(arr, low, high);
		  
		            // Recursively sort elements before
		            // partition and after partition
		            quickSort(arr, low, pi-1);
		            quickSort(arr, pi+1, high);
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