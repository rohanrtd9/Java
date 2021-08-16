package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SumOfDigits {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		try {
			int a=Integer.parseInt(br.readLine());
			int b=9,c=9;
			int digit=1;
			while(a>b)
			{
				b=c+b*10;
				digit++;
			}
			int f=10,g=0;
			int r;
			for (int i=1;i<=digit;i++)
			{
				r=a%f;
				g=g+r;
				a=a-r;
				a=a/10;
			}
			System.out.println(g);
		} 
		catch (Exception e) {
						// TODO Auto-generated catch block
			System.out.println("Invalid input");
 		}
	}
}
