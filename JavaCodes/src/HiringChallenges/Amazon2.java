package HiringChallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Amazon2 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int Q = Integer.parseInt(line[1]);
            String S = br.readLine();
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
            {
            	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }
            int[][] ranges = new int[Q][2];
            for(int i_ranges = 0; i_ranges < Q; i_ranges++)
            {
            	String[] arr_ranges = br.readLine().split(" ");
            	for(int j_ranges = 0; j_ranges < arr_ranges.length; j_ranges++)
            	{
            		ranges[i_ranges][j_ranges] = Integer.parseInt(arr_ranges[j_ranges]);
            	}
            }

            int out_ = goodString(N, Q, S, arr, ranges);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static int goodString(int N, int Q, String S, int[] arr, int[][] ranges){
       // Write your code here
        int result = 0;
        Map<Character,ArrayList<Integer>> mp=new HashMap<>();
        char c[]=S.toCharArray();
        
        //array offset by one, ie zero isnt included
        int pos[]=new int[N+1];
        for (int i = 0; i < arr.length; i++) {
			pos[arr[i]]=i+1;
		}
        //our dp array is initialized with the zeroes
        
        int dp[][]=new int[N+2][N+2];
        int val=0;
        int temp=0;
        for (int ws=1;ws<N;ws++)
        {
        	for (int i = 1; i+ws <= N; i++) 
        	{
        		val=dp[i-1][i+ws];
        		if(i+ws+1< N)
        		val=Math.max(val,dp[i][i+ws+1]);
				if (c[i-1]==c[i+ws-1])
				{
					
					temp=Math.min(arr[i-1], arr[i+ws-1]);
					val=Math.max(val, temp);
				}
				dp[i][i+ws]=val;
			}
        }
        int l=0;
        int r=0;
        for (int[] range:ranges)
        {
        	l=range[0];
        	r=range[1];
        	temp=dp[l][r];
        	result=Math.max(result, temp);
        }
        return result;
    
    }
}