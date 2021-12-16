package ProjectEuler;
//this is the working solution of the porblem
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Euler29DistinctPowers3 {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		//this is the number of elements or our grid square
		int n=Integer.parseInt(st.nextToken());
		
		//this contains all possible numbers for any given power i
		//lets say inititally for each number i there will be n-1 numbers
		int possibleNumbers[]=new int[n+1];
		
		long finalAnswer=(n-1)*(n-1);
		//here numbers are from0-N
		//if allNums[i]==1 then number has been checked else not
		int allNums[]=new int[n+1];
		
		
		//next thing that we do is we make sure we remove the duplicate values
		Map<Integer,Integer> map=new HashMap<>();
		Euler29DistinctPowers3 edp= new Euler29DistinctPowers3();
		edp.populateToll(map, n);
		for (int i = 2; i < possibleNumbers.length; i++) {
			if(possibleNumbers[i]==1)
				continue;
			int maxPow=1;
			for (int j=2; (int)Math.pow(i, j)<=n;j++)
			{
				possibleNumbers[(int)Math.pow(i, j)]=1;
				maxPow=j;
			}
			finalAnswer-=map.get(maxPow);
			
		}
		out.println(finalAnswer);
		
		//loop for doing coding 
		
		out.flush();
	}
	
	private void populateToll (Map<Integer,Integer> map,int n)
	{
		map.put(1, 0);
		map.put(0, 0);
		
		
		int nums[]= new int[n-1];
		
		Set<Integer> se= new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			nums[i]=i+2;
			se.add(i+2);
		}
	
		for (int i = 2;  (int)Math.pow(2,i)<=n; i++) {
			for (Integer numbs : nums) {
				se.add(numbs*i);
			}
			
			map.put(i, (((n-1)* i)-se.size()));
		}
		
		//this function populates the toll that we get per element
	}
	
	
}
