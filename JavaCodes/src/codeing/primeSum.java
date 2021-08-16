package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class primeSum {
	public static void main(String[] args) 
		{ primeSum ps= new primeSum();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc = Integer.parseInt(br.readLine());
			while(tc-->0)
				{
					int n= Integer.parseInt(br.readLine());
					if(n==1)
						System.out.println(0);
					else if(n==2)
						System.out.println(2);
					else 
					{
						ArrayList<Number1> lst= new ArrayList<>();
						ps.populateList(lst, n);
						
						System.out.println(ps.seive(lst, n));
					}
					
					
				}
			} 
		catch (Exception e) 
			{
			}		
		}
	private int seive(ArrayList<Number1> lst,int n)
	{
		int sum=this.oddSum(n);
		
		for (int i = 0; lst.get(i).value<=Math.sqrt(n)  ; i++) {
			if(lst.get(i).isPrime)
			{
				int ptr=i+((i+1)*2)+1;
				while(ptr<lst.size())
				{
					if(lst.get(ptr).isPrime)
						sum-=lst.get(ptr).value;
					lst.get(ptr).isPrime=false;
					ptr+=((i+1)*2)+1;
					
				}
			}
		}
		return sum+2;
	}
	private int oddSum(int n)
	{
		int nmbr=(int)((n-1)/2.0);
		return (int )(	(nmbr/2.0)	*	(	6	+(	(nmbr-1)*2	)	)	);
	}
	private void populateList(ArrayList<Number1> lst,int n)
	{
		int v=3;
		while(v<=n)
		{
			Number1 num= new Number1(v,true);
			lst.add(num);
			v+=2;
		}
	}
	
}	
class Number1
{	
	int value;
	boolean isPrime;
	public Number1(int valuez,boolean isPrimez) {
		value=valuez;
		isPrime=isPrimez;
		// TODO Auto-generated constructor stub
	}
}