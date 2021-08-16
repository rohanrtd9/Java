package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CCJAN06BlackJack2 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				PrintWriter out = new PrintWriter(System.out);
				StringTokenizer st= new StringTokenizer(br.readLine());
				//this is number of test cases
				int tc=Integer.parseInt(st.nextToken());
				
				//loop for doing coding 
				while(tc-->0)
				{
					st= new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int x=Integer.parseInt(st.nextToken());
					int y=Integer.parseInt(st.nextToken());
					ArrayList<Integer>path[][]= new ArrayList[y+1][];
					ArrayList<Integer> nums=new ArrayList<>();
					
					st= new StringTokenizer(br.readLine());
					
					
					for (int i = 0; i < n; i++) {
						nums.add(Integer.parseInt(st.nextToken()));
					}
					//this array contains location of n as they come
					int sumN[]=new int [y+1];
					int sum=0;
					for (int ix : nums) {
							sum+=ix;
							if(sum>=path.length)
								break;
							sumN[sum]=1;
							//new arraylist for containing subset of given ns
							ArrayList<Integer> t= new ArrayList<Integer>();
							for (int i : nums) 
							{
								if (i==ix)
									continue;
								t.add(i);
							}
							
							if (path[sum]==null)
							{
								ArrayList<Integer>path1[]= new ArrayList[1];
								path1[0]=t;
								path[sum]=path1;
							}
							else
							{
								ArrayList<Integer>path1[]= new ArrayList[path[sum].length+1];
								//copy to new
								int idx=0;
								for (ArrayList<Integer> i : path[sum]) 
								{
									path1[idx++]=i;
								}
								path1[idx]=t;
								path[sum]=path1;
							}
							
							
					}
					if(sum<x)
					{
						System.out.println(-1);
						continue;
					}
					sumN[0]=1;
					
					//doing same as above but copying path
					ArrayList<Integer>path1[]= new ArrayList[1];
					ArrayList<Integer> t= new ArrayList<Integer>();
					int l=nums.get(0);
					for (int i : nums) 
					{
						if (i==l)
							continue;
						t.add(i);
					}
					path1[0]=t;
					path[0]=path1;
					int sumN1[]=new int [y+1];
					
					int done=-1;
					//(n*(n-1))/2
					for (int swaps = 0; swaps <n; swaps++) 
					{
						if(checkDone(sumN,x,y))
						{
							done=swaps;
							break;
						}
						ArrayList<Integer>pathN1[][]= new ArrayList[y+1][];
						sumN1=new int [y+1];
						for (int i = 0; i < sumN.length; i++) {
							if(sumN[i]==0)
								continue;
							for (ArrayList<Integer>[] arrayLists : path) {
								if(arrayLists==null)
									continue;
								for (ArrayList<Integer> ix : arrayLists) {
									for (int iz : ix) {
										if(i+iz>=sumN1.length)
											continue;
										sumN1[i+iz]=1;
										
										t= new ArrayList<Integer>();
										for (int ixz : ix) 
										{
											if (iz==ixz)
												continue;
											t.add(i);
										}
										
										
										if (pathN1[i+iz]==null)
										{
											ArrayList<Integer>pathx[]= new ArrayList[1];
											pathx[0]=t;
											pathN1[i+iz]=pathx;
										}
										else
										{
											ArrayList<Integer>pathx[]= new ArrayList[pathN1[i+iz].length+1];
											//copy to new
											int idx=0;
											for (ArrayList<Integer> iv : pathN1[i+iz]) 
											{
												pathx[idx++]=iv;
											}
											pathx[idx]=t;
											pathN1[i+iz]=pathx;
										}
									}
									
								}
							}
							
						}
						sumN=sumN1;
						path=pathN1;
					}
					System.out.println(done);
				}
	}
	static boolean checkDone(int arr[], int l,int u)
	{
		//this function checks whether the bits form l to u inclusive
		//have 1 set
		for (int i = l; i <=u; i++) {
			if(arr[i]==1)
				return true;
		}
		return false;
	}

}
