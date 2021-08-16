package Utility;

public class sum {
	public static void main(String[] args) {
		double a=100000;
		System.out.println(a);
		for (int i = 0; i <= 32; i++) {
			double interest=0.07*a;
			a=(interest)+a+100000;
			System.out.println((long)a+" year "+(i+1)+" interest "+interest);
		}
		for (int i = 33; i < 50; i++) {
			double interest=0.07*a;
			a=interest+a;
			System.out.println((long)a+" year "+(i+1)+" interest "+interest);
		}
	}

}
