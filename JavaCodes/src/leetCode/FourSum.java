package leetCode;


import java.util.List;


public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
	     
		int numLen=nums.length;
		
		int numsSum[]=new int[ ( numLen* (numLen-1) ) / 2 ];
		String indexArr[]=new String[numsSum.length];
		int ptr=0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < numsSum.length; j++) {
				numsSum[ptr]=nums[i]+nums[j];
				indexArr[ptr++]=i+","+j+":"+nums[i]+","+nums[j];
			}
		}
		quickSort(numsSum, 0, numsSum.length-1, indexArr);
        System.out.println();
        return null;
    }
	private static int partition(int arr[], int low, int high,String suppArr[])
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
  
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                String temp1 = suppArr[i];
                suppArr[i] = suppArr[j];
                suppArr[j] = temp1;
            }
        }
  
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
  
        return i+1;
    }
  
  
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private static void quickSort(int arr[], int low, int high,String suppArr[])
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high,suppArr);
  
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1,suppArr);
            quickSort(arr, pi+1, high,suppArr);
        }
    }
	
}
