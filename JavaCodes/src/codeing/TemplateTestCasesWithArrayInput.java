package codeing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TemplateTestCasesWithArrayInput {
	public static void main(String[] args) 
	{
		
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
			
			testCases--;
		}
		scanner.close();
	}public void readerInput()
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc=Integer.parseInt(br.readLine());
			while(tc-->0)
			{}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
