package leetCode;

public class circle {
public static void main(String[] args) {
	circle c= new circle();
	for (int i = 1; i < 10; i++) {
		System.out.println(c.smallestRepunitDivByK(i));
	}
	
}
	  public int smallestRepunitDivByK(int k) {
	        if(k==1)
	            return 1;
	        int dp[]=new int [k];
	        int i=1;
	       
	        int res=1;
	        while(dp[i]==0)
	        {
	            dp[i]=1;
	            i = ( ( ( 10 * i ) % k )+1 ) % k;
	            res++;
	            if(i==0)
	                return res; 
	        }
	        return -1;
	    }
	}