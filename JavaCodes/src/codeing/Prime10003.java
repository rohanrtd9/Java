package codeing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prime10003 {
	public static void main(String[] args) {
		Prime10003 pp = new Prime10003();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t;
		try {
			t = Integer.parseInt(br.readLine());
			for(int a0 = 0; a0 < t; a0++){
	            int n = Integer.parseInt(br.readLine());
	            int upperRange=n*20;
	            long startTime =  System.currentTimeMillis();
	            System.out.println(pp.getNthPrime(n,upperRange));
	         // At the end
	            long endTime = System.currentTimeMillis();
	            System.out.println("It took " + (endTime - startTime) + " milliseconds");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	private int getNthPrime(int n,int upperRange)
	{
		Number start=this.generateSequence(upperRange);
		this.seiveTillN(upperRange, start);
		for (int i = 1; i < n; i++) {
			start=start.next;
		}
		return start.value;
	}
	
	private Number generateSequence(int n)
	{	
		Number start= new Number(2);
		Number current= start;
		for (int i = 3; i <= n; i+=2) {
			Number next= new Number(i);
			current.next=next;
			current=current.next;
		}
		return start;
	}
	private void seiveTillN(int n, Number start)
	{
		Number current=start;
		current=current.next;
		while(current.next!=null && current.value<=Math.sqrt(n))
		{
			this.seive(current.value, current.next);
			current=current.next;
		}
	}
	private void seive(int n,Number start)
	{
		Number current=start;
		Number prev=current;
		
		while(current.next!=null)
		{
			if (current.value%n==0)
				prev.next=current.next;
				
			else
				prev=current;
			current=current.next;
				
			
		}
	}

}
class Number
{
	int value;
	
	Number next;
	public Number(int n) {
		value=n;
		// TODO Auto-generated constructor stub
	}
}