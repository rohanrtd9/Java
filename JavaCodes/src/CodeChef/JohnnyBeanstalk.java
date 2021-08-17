package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class JohnnyBeanstalk {
	public static void main(String[] args)
	{
		JohnnyBeanstalk j = new JohnnyBeanstalk();
		j.function();
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{
					br.readLine();
					String leaves[]=br.readLine().split(" ");
					int arr[]=new int[leaves.length];
					for (int i = 0; i < arr.length; i++) {
						arr[i]=Integer.parseInt(leaves[i]);
						
					}
					if(this.tree(arr))
						System.out.println("Yes");
					else
						System.out.println("No");
					a--;
				}
			}
		catch(Exception E)
		{}
}
	public boolean tree(int arr[])
	{
		int stemCount=1;
		for (int i = 0; i < arr.length; i++) {
			stemCount-=arr[i];
			if(stemCount<0)
				return false;
			stemCount*=2;
		}
		if(stemCount==0)
			return true;
		return false;
	}
}
