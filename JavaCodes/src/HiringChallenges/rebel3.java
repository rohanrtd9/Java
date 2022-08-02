package HiringChallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class rebel3 {
	public static void main(String[] args) {
		int a[]= {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
		System.out.println(Integer.MAX_VALUE);
	}
	static int reversePairs(int[] nums) {
	    //importing io functions
        //this implies that we look for two pairs at once
		int pairSize=2;
        int result=0;
        while(pairSize/2<nums.length)
        {
            int offSet=0;
            int []newArr=new int[nums.length];
            //dont worry inner loop sorta works in tandem so is linear
            while(offSet<nums.length)
            {
                int i=offSet,j=offSet+(pairSize/2),k=offSet;
                while(j<nums.length && i<offSet+(pairSize/2) && j<offSet+pairSize)
                {
                    if(nums[i]>=nums[j])
                    {
                    	int p=offSet+(pairSize/2);
                    	p--;
                    	while(p>=offSet && (long)nums[p--]>(long)2*nums[j])
                    		result++;
                        newArr[k++]=nums[j++];
                    }
                    else
                    {
                    	
                        newArr[k++]=nums[i++];
                    }
                }
                if (i== (offSet+(pairSize/2)))
                    while(j <nums.length && j<offSet+pairSize)
                        newArr[k++]=nums[j++];
                else
                    while(i<nums.length && i<offSet+(pairSize/2))
                    {
                        newArr[k++]=nums[i++];
                        
                    }
                offSet+=pairSize;
            }
            pairSize*=2;
            nums=newArr;
        }
        return result;
    }
}