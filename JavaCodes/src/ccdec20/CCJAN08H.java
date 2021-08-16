package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CCJAN08H {
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
					//this is number of test cases
					int n=Integer.parseInt(st.nextToken());
					int m=Integer.parseInt(st.nextToken());
					ArrayList<Integer> a= new ArrayList<>();
					int max=0;
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < n; i++) {
						int nn=Integer.parseInt(st.nextToken());
						a.add(nn);
						max=max|n;
					}
					
					ArrayList<Integer> b= new ArrayList<>();
					st= new StringTokenizer(br.readLine());
					for (int i = 0; i < m; i++) {
						b.add(Integer.parseInt(st.nextToken()));
					}
					int size=Integer.numberOfTrailingZeros(Integer.highestOneBit(max))+1;
					//next we make an array of new nodes
					treeNode[] tn= new treeNode[size+1];
					for (int i = 0; i <tn.length; i++) {
						treeNode temp= new treeNode();
						temp.maxVal=combo(size,i);
						tn[i]=temp;
					}
					tn[0].insert(0);
					for (Integer ors : a) {
						int idx=Integer.bitCount(ors);
						tn[idx].insert(ors);
					}
				}
	}
	public static int combo(int n, int r)
	{
		int res=1;
		if (r<n/2)
			r=n-r;
		for (int i = r+1; i <= n; i++) {
			res=(int)(((double)res/(i-r))*i);
		}
		return res;
	}
}
class treeNode
{
	int maxVal;
	int currentVal;
	ArrayList<Integer> Nodes;
	void insert(int n)
	{
		if (Nodes==null) {
			Nodes=new ArrayList<>();
			currentVal=0;}
		Nodes.add(n);
		currentVal+=1;
	}
	
}