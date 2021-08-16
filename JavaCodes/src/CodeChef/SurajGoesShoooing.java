package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SurajGoesShoooing {
	public static void main(String[] args) {
		SurajGoesShoooing sgs= new SurajGoesShoooing();
		sgs.shopping();
	}
	public void shopping ()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		try {
			t = Integer.parseInt(br.readLine());
			while(t>0)
			{
				t--;
				br.readLine();
				String s[]=br.readLine().split(" ");
				int a[]=new int[s.length];
				for (int i = 0; i < a.length; i++) 
				{
					a[i]=Integer.parseInt(s[i]);
					
				}
				this.insertionSort(a);
				int bill=0;
				for (int i = 0; i < a.length; i+=4) {
					bill+=a[i];
					bill+=i+1<a.length?a[i+1]:0;
				}
				System.out.println(bill);
			}
		} 
		catch (Exception e) 
			{}
		
	}
	public void insertionSort(int a[])
	{//descending
		for (int i = 0; i < a.length-1; i++) {
			int max=a[i],indx=i;
			for (int j = i+1; j < a.length; j++) 
			{
				if (a[j]>max)
				{
					max=a[j];
					indx=j;
				}
			}
			if (indx!=i)
			{
				a[indx]=a[i];
				a[i]=max;
			}
		}
	}
}
