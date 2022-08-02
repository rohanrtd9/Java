package leetCode;

public class bs {
	public static void main(String[] args) {
	
		int n[]= {-1,0,3,5,9,12};
		int b=13;
		bs sb = new bs();
		sb.search(n, b);
	}
	public int search(int[] nums, int target) {
	      
        return this.findX(0,nums.length,nums,target);
    }
    private int findX(int l, int r, int [] nums, int target)
    {
        if( r >= l ) {
        int mid=  l + ( r - l)  / 2;
        if( nums[mid]==target)
            return mid;
        if (nums[mid]>target)
            return this.findX(l,mid-1,nums,target);
        
        return this.findX(mid+1,r,nums,target);
        }
        return -1;
            
    }
}