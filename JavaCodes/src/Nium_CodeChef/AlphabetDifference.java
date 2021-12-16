package Nium_CodeChef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AlphabetDifference {
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
			char  crr1[]=br.readLine().toCharArray();
			
			Set<Character> word1=new HashSet<>();
			for (int i = 0; i < crr1.length; i++) {
				word1.add(crr1[i]);
			}
			
			char  crr2[]=br.readLine().toCharArray();
			Set<Character> word2=new HashSet<>();
			for (int i = 0; i < crr2.length; i++) {
				word2.add(crr2[i]);
			}
			
			word2.removeAll(word1);
			
			Set<Character> word3=new TreeSet<>();
			word3.addAll(word2);
			if (word3.size()>0)
			{
				String t=word3.toString().replaceAll("\\[|\\]","").replaceAll(","," ");
				t=t.replaceAll("\\s", "");
				out.println(t);
			}	
				
			else
				out.println(-1);
			
		}
		out.flush();
	}
}
