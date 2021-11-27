package Utility;

public class Mathematics {

	public static int log2(int N)
    {
  
        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));
  
        return result;
    }
}
