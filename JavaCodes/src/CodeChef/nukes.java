package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class nukes {
	public static void main(String[] args)
	{
		nukes n= new nukes();
		n.function();
	}
	public void function()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		try {
			String s[]=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int n=Integer.parseInt(s[1]);
			n++;
			int k=Integer.parseInt(s[2]);
			StringBuilder sb=new StringBuilder();
			while(k>0) {
				sb.append(a%n);
				a=a/n;
				sb.append(" ");
				k--;
			}
			System.out.println(sb.toString());
			}
		catch(Exception E)
		{}
}
}
