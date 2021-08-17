package ProjectEuler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Euler17NumberToName {
	public static void main(String[] args) throws Exception
	{
		//importing io functions
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st= new StringTokenizer(br.readLine());
				int tp=Integer.parseInt(st.nextToken());
				while(tp-->0)
				
				{
					st= new StringTokenizer(br.readLine());
					//this is number of test cases
					long tc=Long.parseLong(st.nextToken());
					String divThou[]={"","Thousand","Million","Billion","Trillion"};
					String num[]= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
					String divTen[]= {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
					String divElev[]= {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
					String name="";
					int ptr=0;
					if(tc==0)
						name="Zero";
					while(tc>0)
					{
						String tempStr="";					
						int part=(int)(tc%1000);
						if (part>100)
						{
							tempStr=num[(part/100)];
							tempStr=tempStr+" Hundred ";
						}
							
						else if (part==100)
							tempStr=tempStr+"Hundred";
						part=part%100;
						if(part>=20) 
						{
							tempStr=tempStr+divTen[(part/10)-2];
							if (part%10!=0)
								tempStr=tempStr+" "+num[(part%10)];
						}
						else if (part>=10)
						{
							tempStr=tempStr+divElev[(part)-10];
						}
						else
							tempStr=tempStr+num[(part%10)];
						tc/=1000;
						if (tempStr.equals(""))
							{ptr++;}
						else if (ptr==0)
							{
								name=tempStr;
								ptr++;
							}
						else 
						{
							if (name.equals(""))
								name=tempStr+" "+divThou[ptr++];
							else
								name=tempStr+" "+divThou[ptr++]+" "+name;
						}							
					}
					
					System.out.println(name);
				}
				
		}
	
}
