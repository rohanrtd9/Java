package leetCode;

public class InvertArray {
	public static void main(String[] args) {
		int num[][]= {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(flipAndInvertImage(num));
	}
	 public static int[][] flipAndInvertImage(int[][] image) {
	        for(int i=0;i<image.length;i++)
	        {
	            int rowLen=image[i].length;
	            for(int j=0;j<rowLen/2;j++)
	            {
	                int temp=( image[i][j]+1 )&1;
	                int t1=( image[i][rowLen-1-j] + 1 )&1;
	                image[i][j]=t1;
	                image[i][rowLen-1-j]=temp;
	            }
	            if( ( rowLen&1 ) ==1)
	            {
	                image[i][rowLen/2]=( image[i][rowLen/2] + 1 ) &1;
	            }
	        }
	        return image;
	    }
}
