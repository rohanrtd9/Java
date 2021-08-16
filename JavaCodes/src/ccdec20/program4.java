package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class program4 {
	public static void main(String[] args) throws Exception
	{
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				program4 pp= new program4();
				
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					
					//this is number of test cases
					int n=Integer.parseInt(st.nextToken());
					int m=Integer.parseInt(st.nextToken());
					int spells[]= new int[m];
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < spells.length; i++) {
						spells[i]=Integer.parseInt(st.nextToken());
						spells[i]=spells[i]%n;
					}
					pp.sortInsert(spells);
					int count=0;
					for (int i = 0; i < spells.length; i++) {
						if (spells[i]==0)
							continue;
						count+=(n)-spells[i];
						n-=count;
						break;
					}
					System.out.println(count);
				}
				
	}
	public void sortInsert(int a[])
	{
		// this thing sorts ascending the given sequence
		for (int i = 0; i < a.length-1; i++) {
			int minIdx=i;
			for (int j = i+1; j < a.length; j++) {
				if (a[minIdx]>a[j])
				{
					minIdx=j;
				}
			} 
			int temp=a[minIdx];
			a[minIdx]=a[i];
			a[i]=temp;
					
		}
	}

}
