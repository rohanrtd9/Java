package CodeChef;
import java.util.Scanner;


public class johny {
	public void funciton1()
	{
		
		Scanner scanner= new Scanner(System.in);
		
		//number of test cases
		int tc=scanner.nextInt();
		
		while(tc>0)
		{
			//this is length of array in each test case
			int n=scanner.nextInt();
			int inputArray[]=new int[n];
			for (int i = 0; i < inputArray.length; i++) {
				inputArray[i]=scanner.nextInt();
			}
			//this is position of song
			int p=scanner.nextInt();
			
			//now our array's index starts from 0 while here position is form 1 so offset by -1
			p--;
			int songValue=inputArray[p];
			
			//song index will be 1 if SongValue is minimum in array
			int songIndex=1;
			
			for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i]<songValue)
				songIndex++;
			}
			System.out.println(songIndex);
			tc--;
		}
		scanner.close();
	}
}
