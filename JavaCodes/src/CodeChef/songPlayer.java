package CodeChef;

public class songPlayer {
public static void main(String[] args) {
	String song="DC E EE ED CB C AA A A AB CCCC CB AG A GG G G    BC BC CC CD CD DC  BC BC CC CD CD DC  BC BC CC CD CD DC BC BC CC CD CD    CD E EE ED CB C AA A A AB CCCC CB AG A GG G G    CD E E EG ED CB C AA A A AB CCCC CB AG A GG G G    GA CCD CA    AC DE F GG    G FA GF ED EF FE D BC    B B CCC BCC GG AAA GAA EE FFF G AB A GG EF ED CBA    B B CCC BCC GG AAA GAA EE FFF G AB A GG EF ED CBA    B B CCC BCC GG AAA GAA EE FFF G AB A GG EF ED CBA    ";
	songPlayer sp=new songPlayer();
	sp.songPlayer1(song);
	
}
	private void songPlayer1(String song)	{
	Tone t=new Tone();
	char []c =song.toCharArray();
	for (int i = 0; i < c.length; i++) {
		Double freq=this.getFrequency(c[i]);
		System.out.println(c[i]+" "+freq);
		t.playFrequency(freq);
	}
	}
	private double getFrequency(char c)
	{
		if (c==' ')
		{
			return 0;
		}
		else
		{int distance=0;
			switch(c)
			{
			case 'A':
			break;
		
			case 'B':
			distance=2;
			break;
			
			case 'C':
			distance=3;
			break;
			
			
			case 'D':
			distance=5;
			break;
			
			case 'E':
			distance=7;
			break;
			
			case 'F':
			distance=8;
			break;
			
			case 'G':
			distance=10;
			break;
				
			default:;
			}
		double f=distance/12.0;
		f=Math.pow(2, f);
		f=f*440;
		return f;
		}
	}
}
