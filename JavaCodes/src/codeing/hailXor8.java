package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hailXor8 {
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
				int a[]=new int[s.length];
				for (int i = 0; i < a.length; i++) 
				{
					a[i]=Integer.parseInt(s[i]);
				}
				for (int i = 0; i < N-1 && X > 0; i++) 
				{
					if (a[i]==0)
						continue;
					
					//setting the msb
					int hb=Integer.highestOneBit(a[i]);
					//taking its xor with msb
					a[i]=a[i]^hb;
					if(a[i]>0)
						i--;
					X--;
					boolean xorDone=false;
					for (int j = i+1; j < N-1; j++)
					{
						if ((a[j]^hb)<a[j])
						{
							a[j]=a[j]^hb;
							xorDone=true;
							break;
						}
					}
					if (! xorDone)
					{
						a[N-1]=a[N-1]^hb;
					}
				}
				if(X>0)
				{
					if(N==2 && (X&1)==1)
					{
						a[N-1]=a[N-1]^1;
						a[N-2]=a[N-2]^1;
					}
					
				}
				for (int i : a) {
					System.out.print(i+" ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
