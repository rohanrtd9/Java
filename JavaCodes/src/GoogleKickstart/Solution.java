package GoogleKickstart;

import java.util.*;

public class Solution {

  static boolean canFormPalindrome( int left, int right, int leftArr[],int rightArr[]) {
 
    // TODO: implement logic to determine whether blocks[l]..blocks[r] can form a palindrome
    // NOTE: remember that blocks[] indexes start at 1, so blocks[0] is empty!
    int countOdd=0;
    int res=0;
    for (int i = 0; i < 26; i++) {
		res= leftArr[i]-rightArr[i];
		//if odd count of char
		if ( (res & 1) == 1 )
			countOdd++;
	}
    if( countOdd > 1 )
    	return false;
    else 
    	return true;
   
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Get number of test cases in input
    int testCaseCount = scanner.nextInt();
    // Iterate through test cases
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Get number of blocks & questions for this test case
      int numberOfBlocks = scanner.nextInt();
      int numberOfQuestions = scanner.nextInt();

      // Read consecutive block characters as a single string
      String blockString = scanner.next();
      // Create array of characters for each block, starting with index 1
      char[] blocks = new char[numberOfBlocks + 1];
      int [][] charGrid=new int[numberOfBlocks + 1][];
      int charRow[]=new int[26];
      charGrid[0]=charRow.clone();
      char tempC;
      for (int i = 0; i < numberOfBlocks; ++i) {
    	tempC = blockString.charAt(i);
        blocks[i + 1] = tempC;
        
        charRow[ ( (int) tempC ) - 65]++;
        charGrid[i+1]=charRow.clone();
      }
      int palindromeCount = 0;
      // Iterate through questions for this test case
      for (int i = 0; i < numberOfQuestions; ++i) {
        // Get left-index and right-index (inclusive) for this question
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        // Create a copy of blocks[] array so that canFormPalindrome()
        // can safely modify it without affecting other questions
        
        // Increment count if this question's sub-array can form a palindrome
        if (canFormPalindrome( left, right, charGrid[left-1], charGrid[right])) {
          ++palindromeCount; 
        }
      }
      // Print results
      System.out.println("Case #" + tc + ": " + palindromeCount);
    }
  }
}
