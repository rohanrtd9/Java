package CodeChef;

public class lic {
public static void main(String[] args) {
	int initial=120000;
	int t=0;
	int amount=0;
	for (int i = 0; i < 16; i++) {
		amount+=(amount*.08)+initial;
		System.out.println("Year "+i+" "+amount);
		t=i;
	}
	for (;t<31;t++)
	{amount+=(amount*.08);
	System.out.println("Year "+t+" "+amount);}
}
}
