package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class sweetestCandy {

	public static void main(String[] args)
	{
		sweetestCandy s= new sweetestCandy();
		s.function();
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			short a=Short.parseShort(br.readLine());
				while (a>0)
				{
					int al=Integer.parseInt(br.readLine());
					String s[]=br.readLine().split(" ");
					int arr[]=new int[s.length];int max=0;
					long sum=0;
					for (int i = 0; i < s.length; i++) {
						arr[i]=Integer.parseInt(s[i]);
						sum+=arr[i];
						max=arr[i]>max?arr[i]:max;
					}
					this.returnString(al);
					a--;
				}
			}
		catch(Exception E)
		{}
}
	public void returnString(int al)
	{
		long t=  (long) (((al+1.0)/2)*al);
		
		System.out.print(t);
		for (int i = al-1; i >0; i--) {
			t+=i;
			System.out.print(" "+t);
		}
		System.out.println("\n"+t);
		
	}
}
