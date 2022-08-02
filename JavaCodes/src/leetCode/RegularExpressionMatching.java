package leetCode;

public class RegularExpressionMatching 
{
	public boolean isMatch(String s, String p) 
	{
		char pattern[]=p.toCharArray();
		char str[]=s.toCharArray();
		int pPtr=0;
		int sPtr=0;
		while(pPtr<pattern.length && sPtr<str.length)
		{
			//if we match the string or dot is our corrent thing
			
			if(pattern[pPtr]=='.' )
			{
				if(pPtr< pattern.length-1 && pattern[pPtr+1]=='*')
					return true;
				pPtr++;
				sPtr++;
			}
			
		}
		return false;
	}
}