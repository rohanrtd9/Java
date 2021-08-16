package ccdec20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CCJAN08D {
	public static void main(String[] args) throws Exception
	{
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
			//number of or stuff
			ArrayList<Integer> a=new ArrayList<>();
			int max=0;
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i <n; i++) {
				int nn=Integer.parseInt(st.nextToken());
				max=max|nn;
				a.add(nn);
			}
			//number of and stuff
			ArrayList<Integer> b=new ArrayList<>();
			st= new StringTokenizer(br.readLine());
			for (int i = 0; i <m; i++) {
				b.add(Integer.parseInt(st.nextToken()));
			}
			int size=Integer.numberOfTrailingZeros(Integer.highestOneBit(max));
			int arr[]=new int[size];
			
		}
		out.flush();
	}

}
class TreeDriver
{
	public Node1 populateTreeRoot(int size)
	{
		Node1 root= new Node1(0);
		Node1[] kids= new Node1[size];
		Node1[] par= {root};
		int val=(int) Math.pow(2, size);
		int ptr=0;
		while(val>0)
		{
			val=val>>1;
			Node1 temp=new Node1(val);
			kids[ptr++]=temp;
			temp.parents=par;
		}
		return root;
	}
	public void populateRestTree()
	{
		
	}
}
class Node1
{
	int val;
	Node1 [] children;
	Node1 [] parents;
	public Node1(int n) {
		// TODO Auto-generated constructor stub
		val=n;
	}
}
