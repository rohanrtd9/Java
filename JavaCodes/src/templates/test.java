package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }

            long out_ = solve(N, A);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static long solve(int N, int[] A){
       // Write your code here
        long result = 0;
        long max=0,max2=0;
        
        //first we find a which is first non zero element that occurs in the array
        int dp[][]=new int[N+1][N+1];
        int postfixMax[]=new int[N];
        for (int i=0;i<N;i++)
        {
            dp[0][i]=A[i];
        }
        for (int j=N-2;j>=0;j--)
        {
            for (int i=1; i<N-j;i++)
                dp[i][j]=dp[i-1][j+1]+dp[0][j];
        }
        //next we maintain prefix max in an array;
        
        for (int i=N-2;i>=0;i--)
        {
            for (int j=0;j<N;j++)
                {
                    if  ( postfixMax[i] < dp [i+1] [j] )
                        { 
                            postfixMax[i] = dp[i+1] [j];
                        }
                }
            if ( postfixMax[i+1] > postfixMax[i] )
                {postfixMax[i]=postfixMax[i+1];}
        }
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<N;j++)
            {
                if (dp[i][j]+postfixMax[i]>result)
                result=dp[i][j]+postfixMax[i];
            }
        }
        return result;
    
    }
}