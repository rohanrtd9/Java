package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hailXor3 {
	public static void main(String[] args) {
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
				for (int i = 0; i < N; i++) 
				{
					arr[i]=Integer.parseInt(s[i]);
					
				}
				for (int i = 0; X>0 && i<N-1; i++) 
				{
					if(arr[i]==0)
						continue;
					while(X>0)
					{
						if(X>=Integer.bitCount(arr[i]))
						{
							int bitC=Integer.bitCount(arr[i]);
							
							X-=bitC;
							int ptr=i+1;
							while(bitC>0 && ptr<N)
							{//bitCurr marks the bits of pointed integer
								int BitCurr=Integer.bitCount(arr[ptr]);
								if (BitCurr>=bitC)
								{
									arr[ptr]=arr[ptr]^arr[i];
								}
								else
								{
									arr[ptr]=0;
									bitC-=BitCurr;
								}
								ptr+=1;
							}
							arr[i]=0;
						}
						else 
						{
							while(X-->0)
							{
								int bitC=Integer.highestOneBit(arr[i]);
								arr[i]=arr[i]^bitC;
								int ptr=i+1;
								while(bitC>0 && ptr<N-1)
								{
									if((arr[ptr]^bitC)==0)
										arr[ptr]=arr[ptr]^bitC;
									ptr++;
								}
								if(ptr==N-1)
									arr[ptr]=arr[ptr]^bitC;
																
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
