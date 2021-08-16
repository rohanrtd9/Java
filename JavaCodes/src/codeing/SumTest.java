package codeing;

public class SumTest{
	public static void main(String[] args)
	{
		int sumsfn=0;
		SumTest st=new SumTest();
		for (int i = 1; i <= 1000; i++) {
			
			
			System.out.print("Number "+i+" fn is " +st.fn(i)+" sfn is "+st.sfn(i)+"\n");
			sumsfn+=st.sfn(i);
		}
		System.out.println(sumsfn);
	}
	private int fn(int n)
	{	
		if (n==0)
			return 1;//this function is used to return the factorial of digits of n
		//this array contains the factorial of first ten digits
		int facts[]= {1,1,2,6,24,120,720,5040,40320,362880};
		int sum=0;
	while(n>0)
		{
			sum+=facts[n%10];
			n/=10;
		}
	return sum;
	}
	private int sfn (int n)
	{
		int sumFactDigits=this.fn(n);
		return this.sod(sumFactDigits);
	}
	private int sod(int n)
	{
		//this funtion returns the sum of digits
		int sum=0;
		while(n>0)
		{
			sum+=n%10;
			n/=10;
			
		}
		return sum;
	}
	private int sfnPredictor(int n)
	{	int sum=0;
		int values[]={1,1,2,6,6,3,9,9,9,27}; 
		
		//this function predicts the sfn of given number 
		return 0;
	}
}
