package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Template {
	public static void main(String[] args)
	{
		
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{
					a--;
				}
			}
		catch(Exception E)
		{}
}
	public void funciton1()
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
