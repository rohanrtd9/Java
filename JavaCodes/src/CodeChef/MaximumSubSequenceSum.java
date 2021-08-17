package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MaximumSubSequenceSum {

	public void function()
	{
		Scanner scanner= new Scanner(System.in);
		int tc=scanner.nextInt();
		while(tc>0)
		{
			int n=scanner.nextInt();
			int inputArray[]=new int[n];
			for (int i = 0; i < inputArray.length; i++) {
				inputArray[i]=scanner.nextInt();
			}
			tc--;
		}
		scanner.close();
	}
}
