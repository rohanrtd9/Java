package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CompilersAndParsers {
public static void main(String[] args) 
	{
		CompilersAndParsers cp=new CompilersAndParsers();
		cp.longestPrefix();
		
	}
public void longestPrefix()
	{BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	
	try {
		int a=Integer.parseInt(br.readLine());
		while (a>0)
			{a--;
			char c[]=br.readLine().toCharArray();
			int l=0,b=0,t=0;
			for (int i = 0; i < c.length; i++)
				{
					if (c[i]=='<')
						{l++;
						b++;
						}
					else
						{l--;
						b++;
						if (l==0)
							t=b;
						if (l<0)
							break;
						}				
				}
			System.out.println(t);
			}
		
		} 
	catch (Exception e) 
		{}
	
	}
}
