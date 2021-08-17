package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SweetestCandy2 {

	public static void main(String[] args)
	{
		SweetestCandy2 s= new SweetestCandy2();
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
					
					int arr[]=new int[s.length];
					int max=0;
					long sum=0;
					for (int i = 0; i < s.length; i++) {
						arr[i]=Integer.parseInt(s[i]);
						max=max>arr[i]?max:arr[i];
						sum+=arr[i];
					}
					//this.insertionSort(arr);
					System.out.print(sum);
					for (int i = 0; i < arr.length-1; i++) {
						sum+=(max-arr[i]);
						System.out.print(" "+sum);
					}
					a--;
				}
			}
		catch(Exception E)
		{}
}
	public void insertionSort(int a[])
	{//ascending
		for (int i = 0; i < a.length-1; i++) {
			int min=a[i],indx=i;
			for (int j = i+1; j < a.length; j++) 
			{
				if (a[j]<min)
				{
					min=a[j];
					indx=j;
				}
			}
			if (indx!=i)
			{
				a[indx]=a[i];
				a[i]=min;
			}
		}
	}
	
}
