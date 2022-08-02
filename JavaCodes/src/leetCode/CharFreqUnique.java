package leetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class CharFreqUnique {
	public static void main(String[] args) {
		String s="bbcebab";
		System.out.println(minDeletions(s));
	}
	public static int minDeletions(String s) {
        char c[]=s.toCharArray();
		int freq[]=new int[26];
		for (int i = 0; i < c.length; i++) 
			freq[(int)c[i]-(int)'a']++;
		
        PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        
		int count=0;
		for (int i=0;i<26;i++)
        {
            if (freq[i]==0)
                continue;
            pQueue.add(freq[i]);
        }
        
        int cur=pQueue.poll();
        while (!pQueue.isEmpty() && cur!=0)
        {
            int nex=pQueue.poll();
            int curMatchCount=0;
            while(nex==cur)
            {
                curMatchCount++;
                if(!pQueue.isEmpty())
                	nex=pQueue.poll();
                else
                	break;
            }
            pQueue.add(nex);
            count+=curMatchCount;
            while(curMatchCount-->0)
            {
                pQueue.add(cur-1);
            }
            cur=pQueue.poll();
        }
		
        return count;
    }
    
}