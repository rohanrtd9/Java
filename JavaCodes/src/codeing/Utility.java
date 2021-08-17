package codeing;

public class Utility {
	public static void main(String[] args) {
		int a[]= {8, 12, 4, -100, 23, 35, -9 ,1, 19, 99, 32, 3, 7 ,99, 3 ,99, 8};
		Utility u= new Utility();
		u.sortInsert(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	public void sortInsert(int a[])
	{
		// this thing sorts ascending the given sequence
		for (int i = 0; i < a.length-1; i++) {
			int minIdx=i;
			for (int j = i+1; j < a.length; j++) {
				if (a[minIdx]>a[j])
				{
					minIdx=j;
				}
			} 
			int temp=a[minIdx];
			a[minIdx]=a[i];
			a[i]=temp;
					
		}
	}
	public void sortDesc(int a[])
	{
		for (int i = 0; i < a.length-1; i++) {
			int minIdx=i;
			for (int j = i+1; j < a.length; j++) {
				if (a[minIdx]<a[j])
				{
					minIdx=j;
				}
			} 
			int temp=a[minIdx];
			a[minIdx]=a[i];
			a[i]=temp;
					
		}
	}
	private void splitSequence(int n[])
	{
		int riskPtr=0;
		for (int i = 0; i < n.length; i++) {
			if(n[i]<=9 || n[i]>=80)
			{
				int temp=n[riskPtr];
				n[riskPtr]=n[i];
				n[i]=temp;
				riskPtr++;
				
			}
		}
	}
}
