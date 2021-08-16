package dynamicProg;

import java.util.BitSet;
import java.util.Vector;

public class bitmaskin {
	public static void main(String[] args) {
		BitSet bs= new BitSet();
		
		bs.set(0);
		int a[]= {17,23,40};
		for (int i = 0; i < a.length; i++) {
			//left shift by a[i]
			long n=(long) (bs.toLongArray()[0]*Math.pow(2, a[i]));
			//or with number
			System.out.println(n);
			BitSet bs1= BitSet.valueOf(new long[]{n});
			System.out.println(bs1);
			bs.or(bs1);
		}
		System.out.println(bs);
		
	}

}
