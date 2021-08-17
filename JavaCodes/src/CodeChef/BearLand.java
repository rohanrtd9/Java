package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class BearLand {
	public char[][] zoo;
	public int idx;
	public int jdx;
	public long count;
	public long current_MF=1;
	//this array has our bears
	public char[] bears={'G','B','P'};
	public static void main(String[] args)
	{
		BearLand br = new BearLand();
		br.function();
		
	}
	public void function()
	{	
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			//number of test cases
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{	//here we are dealing with each new test case
					
					//size of the zoo
					int zooSize=Integer.parseInt(br.readLine());
					
					
					// this is the main array that stores info of the bears
					zoo=new char[zooSize][];
					//intiazlizing the variables
					idx=0;
					jdx=0;
					count=0;
					current_MF=1;
					
					
					for (int i = 0; i < zoo.length; i++) {
						//here we are taking line by line input and splitting it by space and saving it into line array
						String zooLine=br.readLine();
						
						//now we iterate over the String array and save it into a char array
						char [] zooLine_Temp=new char[zooSize];
						for (int j = 0; j < zooLine_Temp.length; j++) {
							zooLine_Temp[j]=zooLine.charAt(j);
						}
						//now we save our temp char row data onto zoo array
						zoo[i]=zooLine_Temp;
						
					}
					this.fixBears();
					for (int i = 0; i < zoo.length; i++) {
						for (int j = 0; j < zoo.length; j++) {
							if (zoo[i][j]=='?')
							{
								if (this.checkIsolatedQuestion(zoo, i, j))
									current_MF*=3;
							}
						}
					}
					count=count*current_MF;
					System.out.println((count)%1000000007);
					a--;
				}
			}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public void fixBears()
	{	
		while(zoo[idx][jdx]!='?')
		{
			//if we are at very last element 
			if(idx==zoo.length-1&& idx==jdx)
			{
					// we check is there a fight if not then it is a valid combo and we increament the counter and return
				if (!this.detectFight(zoo))
					count++;
				return;		
			}
			jdx++;
			//if column index beyond then we increment row and set the column to start
			if (jdx==zoo.length)
			{
				jdx=0;
				idx+=1;
			}
			//if column beyond the given zoo size then we return
			//termination condition this is
			
		}
		if(!this.checkIsolatedQuestion(zoo, idx, jdx))
		{
			for (int i = 0; i < bears.length; i++) {
				//since we are using global variables so idx and jdx will change so we will save it
				int idx_t=idx;
				int jdx_t=jdx;
				zoo[idx][jdx]=bears[i];
				
				this.fixBears();
				//reverting idx and jdx to original value which were at time of calling the recursion
				idx=idx_t;
				jdx=jdx_t;
				
			}
			//backtracking
			zoo[idx][jdx]='?';
		}
		else
		{
			int idx_t=idx;
			int jdx_t=jdx;
			zoo[idx][jdx]=bears[0];
			
			this.fixBears();
			//reverting idx and jdx to original value which were at time of calling the recursion
			idx=idx_t;
			jdx=jdx_t;
			//backtracking
			zoo[idx][jdx]='?';
		}
		
	}
	public boolean checkIsolatedQuestion(char[][]zoo,int i,int j)
	{
		//here i and j represent the index of ? present in the zoo array
		// now we check for all boundry conditions
		if(i>0)
		{
			if(zoo[i-1][j]!='.')
				return false;
		}
		if(j>0)
		{
			if(zoo[i][j-1]!='.')
				return false;
		}
		if(i<zoo.length-1)
		{
			if(zoo[i+1][j]!='.')
					return false;
		}
		if(j<zoo.length-1)
		{
			if(zoo[i][j+1]!='.')
					return false;
		}
		return true;
	}
	public boolean detectFight(char [][] zoo)
	{
		//this function returns whether give solution has any fight or not
		for (int i = 0; i < zoo.length-1; i++) {
			for (int j = 0; j < zoo.length-1; j++) {
				if (zoo[i][j]=='.')
					continue;
				else if (zoo[i][j]=='G')
					{
						if (zoo[i+1][j]!='.'||zoo[i][j+1]!='.')
							return true;
					}
				else if (zoo[i][j]=='B')
				{
					if ((zoo[i+1][j]!='B'&&zoo[i+1][j]!='.')||(zoo[i][j+1]!='B'&&zoo[i][j+1]!='.'))
						return true;
				}
				else if (zoo[i][j]=='P')
				{
					if ((zoo[i+1][j]!='P'&&zoo[i+1][j]!='.')||(zoo[i][j+1]!='P'&&zoo[i][j+1]!='.'))
						return true;
				}	
			}
		}
		for (int i = 0; i < zoo.length-1; i++) {
			int j=zoo.length-1;
			if (zoo[i][j]=='.')
				continue;
			else if (zoo[i][j]=='G')
				{
					if (zoo[i+1][j]!='.')
						return true;
				}
			else if (zoo[i][j]=='B')
			{
				if (zoo[i+1][j]!='B'&&zoo[i+1][j]!='.')
					return true;
			}
			else if (zoo[i][j]=='P')
			{
				if (zoo[i+1][j]!='P'&&zoo[i+1][j]!='.')
					return true;
			}	
			
		}
		for (int j = 0; j < zoo.length-1; j++) {
			int i=zoo.length-1;
			if (zoo[i][j]=='.')
				continue;
			else if (zoo[i][j]=='G')
				{
					if (zoo[i][j+1]!='.')
						return true;
				}
			else if (zoo[i][j]=='B')
			{
				if (zoo[i][j+1]!='B'&&zoo[i][j+1]!='.')
					return true;
			}
			else if (zoo[i][j]=='P')
			{
				if (zoo[i][j+1]!='P'&&zoo[i][j+1]!='.')
					return true;
			}	
			
		}
		return false;
	}
	
}
