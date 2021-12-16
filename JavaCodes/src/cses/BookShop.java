package cses;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BookShop {
	public static void main(String[] args)throws Exception 
	{	
		//importing io functions
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		//number of books	
		int n=Integer.parseInt(st.nextToken());
		//total price
		int x=Integer.parseInt(st.nextToken());
		
		
		
		//this array contains max pages that can be created
		//maxPages[i] corresponds to for i value what is max pages that can be created
		int maxPages[]=new int[x+1];
		
		
		//this is the price of each book
		int h[]=new int[n];
		//this is number of pages in that book
		int s[]=new int[n];
		
		st= new StringTokenizer(br.readLine());
		//parsing number of price
		for (int i = 0; i < n; i++) {
			h[i]=Integer.parseInt(st.nextToken());
			
		}
		
		st= new StringTokenizer(br.readLine());
		//parsing number of pages
		for (int i = 0; i < n; i++) {
			s[i]=Integer.parseInt(st.nextToken());
			
		}
		
		
		
		
		//first we loop for all the books
		
		for (int i = 0; i < n; i++) {
			int currentBookPrice=h[i];
			int currentBookPages=s[i];
			
			//we loop for price range from zero to max price that is allowed
			for (int j = x; j > currentBookPrice; j--) {
				
					
				int pagesLast=maxPages[j-currentBookPrice];
				if (pagesLast+currentBookPages> maxPages[j] )
					maxPages[j]=pagesLast+currentBookPages;
				
				
			}
			if(currentBookPrice<=x && maxPages[currentBookPrice]<currentBookPages)
				maxPages[currentBookPrice]=currentBookPages;
			
			
		}
		int max= maxPages[0];
		for (int i = 1; i <= x; i++) {
			if (maxPages[i]>max)
				max=maxPages[i];
		}
		//loop for doing coding 
		out.println(max);
		
		out.flush();
	}
}
