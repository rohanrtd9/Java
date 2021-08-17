package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Tax {
	public static void main(String[] args)
	{
		Tax t= new Tax();
		t.function();
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
				while (a>0)
				{
					int inc=Integer.parseInt(br.readLine());
					this.calIncome(inc);
					a--;
				}
			}
		catch(Exception E)
		{}
}
	public void calIncome(int income)
	{	int inc=0;
		int tax=0;
		while(income>0 && tax<30)
		{	
			int slab=250000;
			if(income<250000)
				slab=income;
			inc+=slab-((slab/100)*tax);
			tax+=5;
			income-=250000;
		}
		if(income>0)
			inc+=income-(0.3*income);
		System.out.println(inc);
	}
}
