package codeing;

import java.util.Scanner;

public class longestCollatzSequence {
	public static void main(String[] args) {
		longestCollatzSequence lcs= new longestCollatzSequence();
		Scanner sc= new Scanner(System.in);
		try {
			long tc=sc.nextInt();
			int [] res= lcs.collatzSequenceArray(5000000);
			while(tc-->0)
			{
				
				int n=sc.nextInt();
				System.out.println(res[n]);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int[] collatzSequenceArray(long N)
	{
		int seqSol[]=new int[(int) (N+1)];
		//this function is used to return the collatz sequence for each of the given values
		long seq[]=new long[(int) (N+1)];
		seq[2]=1;
		long currentPtr=2;
		seqSol[1]=1;
		int currentMax=0;
		int currentMAxIdx=1;
		while(++currentPtr<=N)
		{
			if (seq[(int) currentPtr]==0)
			{
				
				seq[(int) currentPtr]=this.updateSeq(currentPtr, currentPtr, seq);
			}
			if((int)seq[(int) currentPtr]>=currentMax)
			{
				currentMax=(int)seq[(int) currentPtr];
				currentMAxIdx=(int) currentPtr;
			}
			seqSol[(int) currentPtr]=currentMAxIdx;
		}
		return seqSol;
	}
	private long updateSeq(long currentN,long currentCollq,long seq[])
	{
		long nextCollq=0;
		if ((currentCollq&1)==0)
		{
			nextCollq=currentCollq>>1;
		}
		else
		{
			nextCollq=currentCollq*3+1;
		}
		
		if (nextCollq<seq.length && seq[(int) nextCollq]!=0)
		{
			long sequence=seq[(int) nextCollq]+1;
			if (seq.length>currentCollq)
				{	
					seq[(int) currentCollq]=sequence;
				}
			return sequence;
		}
		else
		{
			long sequence=this.updateSeq(currentN, nextCollq, seq)+1;
			if (seq.length>currentCollq)
			{	
				seq[(int) currentCollq]=sequence;
			}
		return sequence;
		}
	

	}
}
