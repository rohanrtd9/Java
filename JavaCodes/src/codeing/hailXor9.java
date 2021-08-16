package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hailXor9 {
	public static void main(String[] args) throws java.lang.Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer stz = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(stz.nextToken()); 
		while(tc-->0)
			{
				
				stz = new StringTokenizer(br.readLine());
				int N=Integer.parseInt(stz.nextToken());
				int X=Integer.parseInt(stz.nextToken());
				int a[]=new int[N];
				stz = new StringTokenizer(br.readLine());
				
				for (int i = 0; i < a.length; i++) 
				{
					a[i]=Integer.parseInt(stz.nextToken());
				}
				for (int i = 0; i < N-1 && X > 0; i++) 
				{
					if (a[i]==0)
						continue;
					int bitC=Integer.bitCount(a[i]);
					if(bitC>=X)
					{
						boolean xorDone=false;
						for (int j = i+1; j < N-1; j++) 
						{
							if((a[j]^a[i])<a[i])
							{
								int comBits=Integer.bitCount(a[j]&a[i]);
								a[j]=a[j]^a[i];
								X-=comBits;
								xorDone=true;
								break;
							}
							
						}
						if(! xorDone)
							{
							a[N-1]=a[N-1]^a[i];
							X-=bitC;
							}
					}
					else
					{
						//setting the msb
						int hb=Integer.highestOneBit(a[i]);
						//taking its xor with msb
						a[i]=a[i]^hb;
						if(a[i]>0)
							i--;
						X--;
						boolean xorDone=false;
						for (int j = i+1; j < N-1; j++) {
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
					
				}
				if(X>0)
				{
					if(N==2 && (X&1)==1)
					{
						a[N-1]=a[N-1]^1;
						a[N-2]=a[N-2]^1;
					}
					
				}
				for(int i=0;i<N;i++)
			        out.print(a[i]+" ");
			        
			    out.println();
			}
			out.flush();
		} 
	}






