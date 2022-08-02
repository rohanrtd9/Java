package HiringChallenges;

import java.io.*;
import java.util.*;


public class Samsung {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
            {
            	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            int[] out_ = solve(N, arr);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print(" " + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();
    }
    static int[] solve(int N, int[] arr){
       // Write your code here
        
        Set<Integer> nums=new HashSet<>();  
         
        Set<Integer>[] posVals=new HashSet[N];
        int iptr=0;
        while(iptr<N)
        {
        	posVals[iptr++]=new HashSet<>();
        }

        int visited[]=new int[501];
        for (int i=N-1;i>0;i--)
        {
            if(visited[i]==1)
                continue;
            posVals[i].add(arr[i]);
            for(int j=i-1;j>=0;j--)
                {
                    if(arr[j]<arr[i])
                    {
                       
                        //we add bitwise or of the both elements in j
                        for (Integer nu : posVals[i]) {
                            posVals[j].add(arr[j]|nu);
                        }
                        
                    }
                }
            nums.addAll(posVals[i]);
            visited[i]=1;
        }
        nums.add(0);
        int result[]=new int[nums.size()];
        int ptr=0;
        for (Integer i : nums) {
            result[ptr++]=i;
        }
        return result;
    
    }
}