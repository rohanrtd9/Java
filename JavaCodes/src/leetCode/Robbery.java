package leetCode;

public class Robbery {
	public static void main(String[] args) {
		Robbery r= new Robbery();
		int a[]= {1,2,1,1};
		System.out.println(r.rob(a));
	}
	 public int rob(int[] nums) {
	        int dp[]=new int[6];
	        int curElementCount=1;
	        for (int num: nums)
	        {
	            for(int i=5;i>0;i--)
	            {
	                if(dp[i]==0)
	                    continue;
	                if(dp[i]==curElementCount-1)
	                    continue;
	                dp[i+num]=curElementCount;
	            }
	            if(dp[num]==0)
	            dp[num]=curElementCount++;
	        }
	        int res=0;
	        for(int i=5;i>=0;i--)
	            {
	                res=i;
	                if(dp[i]!=0)
	                    break;
	                
	            }
	        return res;
	    }
	}