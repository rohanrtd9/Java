package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hailXor5 {
	public static void main(String[] args) {
		hailXor5 hf5= new hailXor5();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc=Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				String s[]=br.readLine().split(" ");
				int N=Integer.parseInt(s[0]);
				int X=Integer.parseInt(s[1]);
				s=br.readLine().split(" ");
				int arr[]=new int[N];
				//int bcount=0;
				for (int i = 0; i < N; i++) 
				{
					arr[i]=Integer.parseInt(s[i]);
					//bcount+=Integer.bitCount(arr[i]);
					
				}
				/*	if (X>bcount)
				{
					if(((X^bcount)&1)==1)
						bcount++;
					X=bcount;
				}	*/
				arr=hf5.minSeq(arr,X ,0);
				for (int i = 0; i < arr.length; i++) {
					System.out.print(arr[i]+" ");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int[] minSeq(int arr[],int X,int index)
	{
		if (X==0)
			return arr;
		X--;
		int idx=this.getI(arr, index);
		int hb=Integer.highestOneBit(arr[idx])>0?Integer.highestOneBit(arr[idx]):1;
		if(idx==arr.length-2 && hb==1)
			{
				X=X&1;
			}
		
		arr[idx]=arr[idx]^hb;
		int currMaxSeq[]=arr.clone();
		currMaxSeq[idx+1]=currMaxSeq[idx+1]^hb;
		currMaxSeq=this.minSeq(currMaxSeq, X,idx);
		for (int k = idx+2; k < arr.length; k++) 
		{
			int [] iterSeq=arr.clone();
			iterSeq[k]=iterSeq[k]^hb;
			iterSeq=this.minSeq(iterSeq, X,idx);
			if(this.seqCompare(iterSeq, currMaxSeq,idx))
				currMaxSeq=iterSeq;
		}
		
		return currMaxSeq;
	}
	private int getI(int arr[],int index)
	{
		for (int i = index; i < arr.length-2; i++) 
		{
			if(arr[i]>0)
				return i;
		}
		return arr.length-2;
	}
	private boolean seqCompare(int arr1[],int arr2[],int idx)
	{
		for (int i = idx+1; i < arr2.length; i++) {
			if(arr2[i]<arr1[i])
				return false;
		}
		return true;
	}
	
}
