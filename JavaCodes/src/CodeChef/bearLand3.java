package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class bearLand3 {
	public static void main(String[] args)
	{
		bearLand3 b3= new bearLand3();
		b3.function();
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{
					char[][] zoo;
					
					//size of the zoo
					int zooSize=Integer.parseInt(br.readLine());
					
					
					// this is the main array that stores info of the bears
					zoo=new char[zooSize][];
					
					for (int i = 0; i < zoo.length; i++) 
					{
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
					
					System.out.println(this.fixBears(zoo));
					a--;
				}
			}
		catch(Exception E)
		{}
	}
	public long fixBears(char[][]zoo)
	{
		long count=0;
		long mf=1;
		for (int i = 0; i < zoo.length; i++) {
			for (int j = 0; j < zoo.length; j++) {
				if(zoo[i][j]=='?')
				{	int t=this.questionMarkStatus(zoo, i, j);
					if(t==-1)
						return 0;
					else 
						mf*=t;
				}
			}
		}
		if(!this.detectFight(zoo))
			count++;
		return ((count*mf)%1000000007);
		
	}
	public int questionMarkStatus(char[][]zoo,int i,int j)
	{
		char c[]=this.checkProximity(zoo, i, j);
		//grizzly count brown count polar count question count and dot count
		int gc=0,bc=0,pc=0,dc=0,qc=0;
		for (int k = 0; k < c.length; k++) 
		{
			switch (c[k]) {
			case '.':
				dc++;
				break;
			case 'G':
				gc++;
				break;
			case 'P':
				pc++;
				break;
			case 'B':
				bc++;
				break;
			case '?':
				qc++;
				break;

			}
		}
		//we return -1 if theres grizzly bear in next cell and terminate the operation
		if(gc>0)
			return -1;
		// here we return 3 if it is an isolated ? and fill it with grizzly bear
		if(dc==4)
		{
			zoo[i][j]='G';
			return 3;
		}
		// if we have two different species then we return -1 as there is no possible way to fill the given cell
		if(bc>0&&pc>0)
			return -1;
		//if we have bear at proximity we fill the cell with the given bear and return 1 as the end result
		if(bc>0&& qc==0)
		{
			zoo[i][j]='B';
			return 1;
		}
		if(pc>0 && qc==0)
		{
			zoo[i][j]='P';
			return 1;
		}
		if(qc==2)
		{	int count=0;
			char cc='?';
			if (bc==0)
			{
				zoo[i][j]='P';
				
				if (this.questionMarkStatus(zoo, i+1, j)>0)
				{
					if (this.questionMarkStatus(zoo, i, j+1)>0)
					{
						count++;
						cc='P';
					}
				}
			}
			if (bc==0)
			{
				zoo[i][j]='B';
				if (this.questionMarkStatus(zoo, i+1, j)>0)
				{
					if (this.questionMarkStatus(zoo, i, j+1)>0)
					{
						count++;
						cc='B';
					}
				}
			}
			zoo[i][j]=cc;
			if (count==0)
				return -1;
			else 
				return count;
		}
		if (qc==1)
		{
			int count=0;
			char cc='?';
			if(bc==0)
			{
				zoo[i][j]='P';
				if( (i+1) <zoo.length && zoo[i+1][j]=='?')
				{
					if (this.questionMarkStatus(zoo, i+1, j)>0)
					{
						cc='P';
						count++;
					}
				}
				if( (j+1) <zoo.length && zoo[i][j+1]=='?')
				{
					if (this.questionMarkStatus(zoo, i, j+1)>0)
					{
						cc='P';
						count++;
					}
				}
				
			}
			if(pc==0)
			{
				zoo[i][j]='B';
				if( (i+1) <zoo.length && zoo[i+1][j]=='?')
				{
					if (this.questionMarkStatus(zoo, i+1, j)>0)
					{
						cc='B';
						count++;
					}
				}
				if( (j+1) <zoo.length && zoo[i][j+1]=='?')
				{
					if (this.questionMarkStatus(zoo, i, j+1)>0)
					{
						cc='B';
						count++;
					}
				}
				zoo[i][j]=cc;
				if (count==0)
					return -1;
				else 
					return count;
			}
		}
		//we return 2 if the given ? ,? around it and no bear species attached to it so it can be filled in only two ways
		return 2;
	}
	public char[] checkProximity(char[][]zoo,int i,int j)
	{
		char c[]={'.','.','.','.'};
		//here we check the proximity of the given question mark add it to an arraylist and return that
		//order is left top right bottom 
		if(i>0)
		{
			c[0]=zoo[i-1][j];
		}
		if(j>0)
		{
			c[1]=zoo[i][j-1];
		}
		if(i<zoo.length-1)
		{
			c[2]=zoo[i+1][j];
		}
		if(j<zoo.length-1)
		{
			c[3]=zoo[i][j+1];
		}
		return c;
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
