package codeing;

import java.util.Scanner;

public class AbsoluteDiff {
	public static void main(String[] args) {
		AbsoluteDiff abd= new AbsoluteDiff();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(abd.getAbsoluteDiff(n));
        }
    }
	private long getAbsoluteDiff(int n)
	{
		return (((long)Math.pow(this.getSum(n), 2))-this.getSquareSum(n));
	}
	private long getSum(int n)
	{
		return n>1?((n*(n+1))/2):1;
	}
	private long getSquareSum(int n)
	{
		return  (n*(n+1)*((2*n)+1))/6;
	}
}
