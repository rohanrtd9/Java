package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListTest {
	public static void main(String[] argv)
    {
  
        // Creating object of Set
        Set<Integer> arrset1 = new HashSet<Integer>();
  
        // Populating arrset1
 
    
  
        // print arrset1
        System.out.println("First Set: " + arrset1);
  
        // Creating another object of Set
        Set<Integer> arrset2 = new HashSet<Integer>();
  
        // Populating arrset2
      
        // print arrset2
        System.out.println("Second Set: " + arrset2);
  
        // comparing first Set to another
        // using equals() method
        boolean value = arrset1.equals(arrset2);
  
        // print the value
        System.out.println("Are both set equal? "
                           + value);
        
        ArrayList<Integer>i1=new ArrayList<>();
        ArrayList<Integer>i2=new ArrayList<>();System.out.println(i1.equals(i2));
    }
}
