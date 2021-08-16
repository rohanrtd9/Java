package ProjectEuler;

import java.util.Scanner;

public class Euler26ResiprocalCycles2 {
	public static void main(String[] args) {
        for(int a0 = 3; a0 <= 10000; a0++){
           
            run(a0-1);
        }
     
    }

    public static void run(int num) {
        /**
         * observational notes note that the maximum recurring cycle length of
         * 1/d is d-1
         */
        int sequenceLength = 0;
        int i = 0;
        for (i = num; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
            }
        }
        int n=sequenceLength + 1;
        System.out.println( num+"  "+n);
    }

}