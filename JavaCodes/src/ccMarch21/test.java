package ccMarch21;

import java.util.Iterator;

public class test {
public static void main(String[] args) {
	int a=0;
	int b=1;
	int sum=0;
	int fsum=0;
	for (int i = 0; i < 20; i++) {
		sum=a+b;
		fsum+=b;
		System.out.println("For i= "+(i+1)+" fib is "+sum+" fib sum is "+fsum);
		a=b;
		b=sum;
		
		
	}
}
}
