package codeing;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RestoreSequence {
	public static void main(String[] args) {
		RestoreSequence rsq= new RestoreSequence();
		rsq.driver();
	}
	public void driver()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{
					a--;
					br.readLine();
					String[] ints=br.readLine().split(" ");
					int arr[]=new int[ints.length];
					for (int i = 0; i < arr.length; i++) {
						arr[i]=Integer.parseInt(ints[i]);
					}
					int seq[]=this.restoreSequence(arr);
					for (int i = 0; i < seq.length-1; i++) {
						System.out.print(seq[i]+" ");
					}
					System.out.print(seq[seq.length-1]);
					
				}
			}
		catch(Exception E)
		{}
	}
	private int[] restoreSequence(int a[])
	{
		int sequence[]=new int[a.length];
		int primes[]= {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
		int currentPrime=0;
		int b[]=a.clone();
		this.sortDesc(b);
		for (int i = 0; i < b.length; i++) {
			while(i+1<b.length && b[i+1]==b[i])
				i++;
			this.replaceSequence(a, b[i], primes[currentPrime], sequence);
			currentPrime+=1;
		}
		
		return sequence;
		
	}
	private void replaceSequence(int a[],int n,int p,int sequence[])
	{
		int current=p;
		//here a is sequence n is number than should be replaced p is prime which is playing as root
		for (int i = 0; i < a.length; i++) {
			if (a[i]==n)
			{
				sequence[i]=current;
				current*=2;
			}
		}
	}
	private void sortDesc(int a[])
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

}
