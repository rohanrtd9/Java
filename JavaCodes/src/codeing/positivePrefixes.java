package codeing;


import java.util.Scanner;

public class positivePrefixes {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		try {
			int tc=scanner.nextInt();
			while(tc-->0)
			{
				int n=scanner.nextInt();
				int k=scanner.nextInt();
				int seq[]=new int[n+1];
				for (int i = 1; i < seq.length; i++) {
					if ((i&1)==1)
						seq[i]=-i;
					else
						seq[i]=i;
				}
				int pos=n/2;
				if(pos>k)
				{
					for (int i = seq.length-1; i >0 &&pos>k ; i--) 
					{
						if(seq[i]>0)
						{
							seq[i]*=-1;
							pos--;
						}
					}
				}
				else if(pos<k)
				{for (int i = seq.length-1; i >0 &&pos<k ; i--) 
					{
					if(seq[i]<0)
					{
						seq[i]*=-1;
						pos++;
					}
					}
				}
				for (int i = 1; i < seq.length; i++) {
					System.out.print(seq[i]+" ");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


