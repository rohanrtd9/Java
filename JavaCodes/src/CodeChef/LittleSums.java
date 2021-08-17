package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LittleSums {
	public static void main(String[] args)
	{
		LittleSums s= new LittleSums();
		s.function();
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{
					br.readLine();
					String s[]=br.readLine().split(" ");
					int arr[]= new int[s.length];
					for (int i = 0; i < arr.length; i++) {
						arr[i]=Integer.parseInt(s[i]);
					}
					System.out.println(this.calculateSum(arr));
					a--;
				}
			}
		catch(Exception E)
		{}
}
	public int calculateSum(int arr[])
	{
		long min=Long.MAX_VALUE;
		int idx=0;
		long preSum=0;
		long postSum=this.calSum(arr);
		//this function returns the minimum index for which sum is least
		for (int i = 0; i < arr.length; i++) {
			preSum+=arr[i];
			if(preSum+postSum<min)
			{
				min=preSum+postSum;
				idx=i;
			}
			postSum-=arr[i];
		}
		return idx+1;
		
	}
	public long calSum(int arr[])
	{	long sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
