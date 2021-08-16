package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HailXor4 {
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
				for (int i = 0; i < N-1 && X>1; ) 
				{
					if(arr[i]==0)
						{
							i++;
							continue;
						}
					while(X>1 && arr[i]>0)
					{
						int hb=Integer.highestOneBit(arr[i]);
						int j=i+1;
						for (; j <N-1; j++)
						{
							if ((arr[j]^hb)<arr[j])
								{arr[j]=arr[j]^hb;
								break;}
						}
						if(j==N-1)
							arr[j]=arr[j]^hb;
						X--;
						arr[i]=arr[i]^hb;
					}
					if(X==1)
					{
						int ptr=i;
						if(arr[ptr]==0 && ptr!=N-1)
							ptr++;
							
						if( ( arr[ptr]^Integer.highestOneBit(arr[ptr]))<arr[ptr] )
						{
							
							int j=ptr+1;
							int hb=Integer.highestOneBit(arr[ptr]);
							arr[ptr]=arr[ptr]^Integer.highestOneBit(arr[ptr]);
							for (; j <N-1; j++)
							{
								if ((arr[j]^hb)<arr[j])
									{arr[j]=arr[j]^hb;
									break;}
							}
							if(j==N-1)
								arr[j]=arr[j]^hb;
							X--;
						}
					}
					
				}
				for (int i : arr) {
					System.out.print(i+" ");
				}
				System.out.println("\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
