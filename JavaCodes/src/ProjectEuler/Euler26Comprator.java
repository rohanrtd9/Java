package ProjectEuler;

import java.io.PrintWriter;

import ProjectEuler.Euler26_ReciprocalCycles.FastReader;

public class Euler26Comprator {
	
	
	public static void main(String[] args) {
		Solutions s= new Solutions();
		int cmax=1;
		int imax=3;
		System.out.println(s.res(9967, 9943));
		for (int i = 4; i < 10001; i++) 
		{
			int cyc=s.res(i, cmax);
			if(cyc>cmax)
			{
				cmax=cyc;
				imax=i;
				
			}
			int cyc1=run(i);
			if(cmax!=cyc1-1)
				System.out.println(i+" gives in mine"+cmax+" and in his"+(cyc1-1));
		}
;	}
	
	public static int run(int num) {
        /**
         * observational notes note that the maximum recurring cycle length of
         * 1/d is d-1
         */
        int sequenceLength = 0;
        int i = 0;
        for (i = num; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
            }
        }
        int n=sequenceLength + 1;
        return( n);
    }
	
	
	static class Solutions 
	{
		public void solve(int testNumber, FastReader in, PrintWriter out, int result[]) 
		{
		
			int n = in.nextInt();
			out.println(result[n-1]);
		}
		private int res(int n,int cmax)
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

}
