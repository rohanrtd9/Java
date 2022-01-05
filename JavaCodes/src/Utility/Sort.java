package Utility;



public class Sort {
	public static void main(String[] args) {
		int []a= {3,2,1,6,4,8,2,4,-1,32,-13};
		Sort s= new Sort();
		s.quickSortDesc(a, 0, a.length-1);
		for (int i : a) {
			System.out.println(i);
		}
	}

	private void sortARr(int arr[])
	{
		//this array sorts the given array in ascending order
		for (int i = 0; i < arr.length-1; i++) {
			int min=i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[min])
					min=j;
			}
			int t=arr[i];
			arr[i]=arr[min];
			arr[min]=t;
		}
	}
	
	/* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index */
  private void quickSortDesc(int arr[], int low, int high)
  {
      if (low < high)
      {
          /* pi is partitioning index, arr[pi] is 
            now at right place */
          int pi = partitionDesc(arr, low, high);

          // Recursively sort elements before
          // partition and after partition
          quickSortDesc(arr, low, pi-1);
          quickSortDesc(arr, pi+1, high);
      }
  	}
  
  private int partitionDesc(int arr[], int low, int high)
  {
      int pivot = arr[high]; 
      int i = (low-1); // index of smaller element
      for (int j=low; j<high; j++)
      {
          // If current element is greater than or
          // equal to pivot
          if (arr[j] >= pivot)
          {
              i++;

              // swap arr[i] and arr[j]
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }

      // swap arr[i+1] and arr[high] (or pivot)
      int temp = arr[i+1];
      arr[i+1] = arr[high];
      arr[high] = temp;

      return i+1;
  }
  
  
  
	private int partition(int arr[], int low, int high)
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
    private void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
  
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}
