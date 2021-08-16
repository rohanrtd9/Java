package CodeChef;


public class Util {
	public static void main(String[] args) {
	int a[]={5,4,1,2,3};
	Util u = new Util();
	u.insertionSort1(a);
	for (int i = 0; i < a.length; i++) {
		System.out.println(a[i]);
	}
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
	public int insertionSort1(int a[])
	{//ascending
		int sum=0;
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
		return sum;
	}
}
