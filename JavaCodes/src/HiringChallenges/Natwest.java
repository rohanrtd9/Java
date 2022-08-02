package HiringChallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Natwest {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        int dp[]=new int[1000001];
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            
            long out_ = minimumCost(N,dp);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static int minimumCost(int N,int dp[]){
       // Write your code here
       //tabulation part
        if(dp[N]>0)
            return dp[N];
        ArrayList<Integer> factors=new ArrayList<>();

        for (int i=2;i<=Math.sqrt(N);i++)
        {
            if(N%i==0)
            {
                factors.add(N/i);
                if(N/i != i)
                	factors.add(i);
            }
            
        }
        //technically we can always make 1+ N-1
        int minCost=Integer.MAX_VALUE;
        if (N>2)
        {
        	if(factors.isEmpty())
        	{
        		minCost=minimumCost(N-1,dp);
        		minCost+=N-1;
        	}
        }
        else if (N==2)
        	return 1;
        else if (N==1)
        	return 0;
        for (int facts:factors)
        {
            int curFactCost=minimumCost(N-facts,dp);
            curFactCost+=(N-facts)/facts;
            
            if(minCost>(curFactCost))
                minCost=curFactCost;
        }
        //then we look for the fators of the given number
        //and add them to possible values to look for
        dp[N]=minCost;
        return minCost;
    
    }
    
}
