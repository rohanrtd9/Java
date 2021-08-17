package codeing;

public class test2 {
	public static void main(String[] args) {
		int n=32;
		test2 tt= new test2();
		tt.breakNumberIn4(n);
	}
	private void breakNumberIn4(int n)
	{
		//this function is used to break a given number in four sums
		int a[]=new int[4];
		int ptr=0;
		while(n>0)
		{
			if(n>=9)
			{
				n-=9;
				a[ptr++]=9;
			}
			else 
			{
				a[ptr]=n;
				n=0;				
			}
		}
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
}
