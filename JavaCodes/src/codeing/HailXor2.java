package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HailXor2 {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc=Integer.parseInt(br.readLine());
			while(tc-->0)
			{
				String s[]=br.readLine().split(" ");
				int n=Integer.parseInt(s[0]);
				int x=Integer.parseInt(s[1]);
				s=br.readLine().split(" ");
				int arr[]=new int[n];
				arr[n-1]=Integer.parseInt(s[n-1]);
				for (int i = 0; i < n-1; i++) 
				{
					arr[i]=Integer.parseInt(s[i]);
				}
				for (int i = 0; x>0 && i<n-1; i++) {
					while(arr[i]>0 && x>0)
					{
						int maxBit=Integer.highestOneBit(arr[i]);
						arr[i]=arr[i]^maxBit;
						int j=i+1;
						for (; (arr[j]^maxBit)>arr[j]; j++) ;
						
						arr[j]=arr[j]^maxBit;
						x--;
					}
				}
				if((x&1)==1)
				{
					arr[n-1]=arr[n-1]^1;
					arr[n-2]=arr[n-2]^1;
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
