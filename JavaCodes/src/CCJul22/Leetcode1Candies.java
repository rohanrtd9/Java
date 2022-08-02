package CCJul22;

public class Leetcode1Candies {
	public static void main(String[] args) {
		int i[]= {1,2,87,87,87,2,1};
		System.out.println(candy(i));
	}
	public static int candy(int[] ratings) 
	{
		if (ratings.length==1)
			return 1;
		
		//initially every one gets 1 candy each
		int result=0;
		
		
		int prefixDist[]=new int[ratings.length+2];
		int postfixDist[]=new int[ratings.length+2];
		
		if (ratings[0]>ratings[1])
			prefixDist[1]=2;
		else
			prefixDist[1]=1;
		if (ratings[ratings.length-1]>ratings[ratings.length-2])
			postfixDist[ratings.length]=2;
		else
			postfixDist[ratings.length]=1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i]> ratings[i-1])
				prefixDist[i+1]=prefixDist[i]+1;
			else
			{
				prefixDist[i+1]=1;
			}
		}
		
		for (int i = ratings.length-2; i >=0 ; i--) {
			if (ratings[i]> ratings[i+1])
				postfixDist[i+1]=postfixDist[i+2]+1;
			else
			{
				postfixDist[i+1]=1;
			}
		}
		
		for (int i = 1; i <= ratings.length; i++) {
			result+=Math.max(prefixDist[i], postfixDist[i]);
		}
		return result;
		
	}
}