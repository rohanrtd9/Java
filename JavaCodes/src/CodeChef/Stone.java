package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Stone {
	public static void main(String[] args)
	{
		Stone s= new Stone();
		s.function1();
	}
	
	public void function1()
	{	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
		
		String s[]=br.readLine().split(" ");
		long a[]=new long[Integer.parseInt(s[0])];
		int k=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		for (int i = 0; i < a.length; i++) {
			a[i]=Long.parseLong(s[i]);
			}
		long result[]=a;
		if (k>0)
		{
			if (k%2==1)
			{	long max=this.getMax(result);
				for (int i = 0; i < result.length; i++) {
					result[i]=max-result[i];
				}
			}
			else
			{
				long max=this.getMax(result);
				for (int i = 0; i < result.length; i++) {
					result[i]=max-result[i];
				}
				System.out.println(Arrays.toString(result));
				max=this.getMax(result);
				for (int i = 0; i < result.length; i++) {
					result[i]=max-result[i];
				}
			}
		}
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
			sb.append(" ");
			
		}
		System.out.println(sb.toString());
		}
		catch(Exception E)
		{}
		
	}
	private long getMax(long a[])
	{
		long max=a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i]>max)
				max=a[i];
		}
		return max;
	}
}
