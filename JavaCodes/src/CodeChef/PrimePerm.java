package CodeChef;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class PrimePerm {
	public static void main(String[] args) 
	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrimePerm pr=new PrimePerm();

		try {
			int t=Integer.parseInt(br.readLine());
			while (t>0)
				{
					int a=Integer.parseInt(br.readLine());
					Integer b[]=new Integer[a];
					while(a>0)
					{
						b[a-1]=a;
						a--;
					}
					System.out.println(pr.getPrimePermutations(b));
					
					t--;
				}
			} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	private int getPrimePermutations(Integer a[])
	{	//in this function we are creating a pool list and adding all the elements from the
		//integer array and just removing the current element, then creating an sequence list
		//and adding the removed current element into it
		// and calling get count function that returns count of 
		//prime sequences starting from the given element
		int count=0;
		for (int i = 0; i < a.length; i++) {
			ArrayList <Integer> pool=new ArrayList<Integer>();
			for (int j = 0; j < a.length; j++) {
				pool.add(a[j]);
			}
			pool.remove((Integer)a[i]);
			LinkedList <Integer> sequence=new LinkedList<Integer>();
			sequence.add(a[i]);
			count+=this.getCount(pool, sequence);
			
		}
		return count;
	}
	private int getCount(ArrayList<Integer> pool,LinkedList<Integer> sequence)
	{
		//here pool is the current pool of choices that can be added next in prime sequence and sequence is current sequence
		LinkedList <Integer> buffer=new LinkedList<Integer>();
		int count=0;
		//this condition means that we have constructed a prime sequence and counter should be incremented by 1
		if (pool.isEmpty())
			return 1;
		//saving initial size of pool
		int s=pool.size();
		for (int i = 0; i < s; i++) {
			Integer current=pool.get(i);
			if (this.isThisSequencePrime(sequence, current))
			{
				pool.addAll(buffer);
				LinkedList<Integer> sequence_clone=(LinkedList<Integer>) sequence.clone();
				sequence_clone.addLast(current);
				count+=this.getCount(pool, sequence_clone);
			}
			else
			{
				buffer.addLast(current);
			}
		}
		return count;
	}
	private boolean isThisSequencePrime(LinkedList<Integer>sequence, Integer current)
	{
		LinkedList<Integer> sequence_clone=(LinkedList<Integer>) sequence.clone();
		sequence_clone.addLast(current);
		int t=sequence_clone.peekLast();
		int count=1;
		for (Integer i : sequence_clone) {
		if (t>i)	
			count++;
		}
			
		
		return this.checkPrime(count);
	}
	private boolean checkPrime(int a)
	{//this function is used to check for the prime number and return whether given number is one or not
		if (a%2==0&&a!=2)
			return false;
		for (int i = 3; i <=Math.sqrt(a); i+=2) {
			if (i%3==0)
				return false;
		}
		return true;
	}

}

