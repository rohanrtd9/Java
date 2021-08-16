package codeing;

public class testinGround {
	public static void main(String[] args) {
		testinGround tg= new testinGround();
		int arr[]=tg.factorsNo();
		for (int i : arr) {
			System.out.print(i+",");
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
	}private void printSeq(int n)
	{
		for (int i = 2; i <=n; i++) {
			this.printS(i);
		}
	}
	private void printS(int n)
	{
		while(n>1)
		{System.out.print(" "+n);
			if((n&1)==0)
			{
				
				n=n>>1;
			}
			else
			{n=3*n+1;}
		}
		System.out.println(" 1\n");
		
	}
	private int[] factorsNo()
	{
		int factors[]=new int[240];
		int primes[]= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163 ,167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239};
		factors[1]=1;
		for (int i = 2; i <240; i++) {
			int n=i;
			int fact=1;
			while(n>1)
			{
				for (int j = 0; j < primes.length; j++) {
					int iterFacto=1;
					while(n%primes[j]==0)
						{
							n/=primes[j];
							iterFacto++;
						}
					fact*=iterFacto;
				}
			}
			factors[i]=fact;
		}
		return factors;
	}
	
}
