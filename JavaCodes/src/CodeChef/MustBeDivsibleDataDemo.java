package CodeChef;

public class MustBeDivsibleDataDemo {
	public static void main(String[] args) {
		//we will check for 1 2 3 4 5 consecutive element sums for 1 2 3 4 5 with a 1 2 3 4 5
		for (int a = 1; a < 6; a++) 
		{
			for (int k = 1; k < 6; k++) 
			{	int sum=1;
				for (int n = 0; n < 5; n++) 
				{
					sum*=(a+(n*k));
					System.out.println("for a ="+a+" and n="+(n+1)+" and k = "+(k)+" product is "+sum);
				}
				
			}
		}
	}
}
