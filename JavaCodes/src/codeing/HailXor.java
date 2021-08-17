package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HailXor {
	public static void main(String[] args) 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc=Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				
				String s[]=br.readLine().split(" ");
				int n=Integer.parseInt(s[0]);
				int k=Integer.parseInt(s[1]);
				s=br.readLine().split(" ");
				int arr[]= new int[n];
				int bitCur=0;
				arr[n-1]=Integer.parseInt(s[n-1]);
				for (int i = 0; i < n-1; i++) {
					arr[i]=Integer.parseInt(s[i]);
					if(k>0)
					{
						bitCur=Integer.bitCount(arr[i]);
						if(bitCur>k)
						{
							while(k-->0)
							{
								int Hb=Integer.highestOneBit(arr[i]);
								arr[i]=arr[i]^Hb;
								arr[n-1]=arr[n-1]^Hb;
							}
						}
						else
						{
							bitCur=Integer.bitCount(arr[i]);
							int Hb=Integer.highestOneBit(arr[i]);
							int HbNext=Integer.highestOneBit(arr[i+1]);
							//start from here

							arr[n-1]=arr[n-1]^arr[i];
							k-=bitCur;
							arr[i]=0;
						}
						
					}
				}
				if ((k&1)==1)
				{
					arr[n-2]=arr[n-2]^1;
					arr[n-1]=arr[n-1]^1;
				}
			for (int i : arr) {
				System.out.print(i+" ");
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
