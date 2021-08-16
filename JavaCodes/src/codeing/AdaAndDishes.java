package codeing;

import java.util.Scanner;

public class AdaAndDishes {
	public static void main(String[] args) 
	{
		AdaAndDishes aad= new AdaAndDishes();
		aad.driver();
	}
	public void driver()
	{
		Scanner scanner= new Scanner(System.in);
		//number of test cases
		int testCases=scanner.nextInt();
		while(testCases>0)
		{	//number of values in the array
			int n=scanner.nextInt();
			//array to parse the number of values
			int inputArray[]=new int[n];
			for (int i = 0; i < inputArray.length; i++) {
				//here we are parsing the int values to the array
				inputArray[i]=scanner.nextInt();
			}
			System.out.println(this.adaDishes(inputArray));
			testCases--;
		}
		scanner.close();
	}
	private int adaDishes(int a[])
	{
		int burner1=0;
		int burner2=0;
		this.sortDesc(a);
		for (int i = 0; i < a.length; i++) {
			if(burner1>=burner2)
				burner2+=a[i];
			else 
				burner1+=a[i];
		}
		return burner1>=burner2?burner1:burner2;
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
