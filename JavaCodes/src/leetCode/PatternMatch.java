package leetCode;

public class PatternMatch {
static  public boolean isMatch(String s, String p) {
    
    int i=0;
    int j=0;
    char str[]=s.toCharArray();
    char ptrn[]=p.toCharArray();
    while (i<str.length && j<ptrn.length)
    {
       if (ptrn[j]=='.')
       {
    	   if ((j+1)<ptrn.length && ptrn[j+1]=='*')
    	   {
    		   return true;
    	   }
    	   else
    		   j++;
    	   i++;
       }
       else if ( str[i]== ptrn[j])
       {
    	   if ( (j+1)<ptrn.length && ptrn[j+1]=='*')
    	   {
    		   while (i< str.length && str[i]==ptrn[j])
    			   i++;
    		   j+=2;
    	   }
    	   else
    	   {
    		   i++;
    		   j++;
    	   }
       }
       else 
       {
           if ( (j+1)<ptrn.length && ptrn[j+1]=='*')
               j+=2;
            else
               i++;
       }
    	   
    }
    if (i==str.length && j==ptrn.length)
    	return true;
    return false;
}
public static void main(String[] args) {
	String a="aab";
	String p="c*a*b";
	if (isMatch(a, p))
		System.out.println("YES");
	else
		System.out.println("NO");
}
}