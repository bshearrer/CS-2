//Assignment 5 Sorting
//By: Brandon Shearrer
//CS 2 Spring 2018
/**
*
*@WRITE_SOME_COMMENTS_ON_O(N)_AND_LOG(O)????
*
*https://www.geeksforgeeks.org/bubble-sort/
*https://www.geeksforgeeks.org/merge-sort/
**/
import java.util.Random;


public class Sorting
{
    public static long startTimeBubble = 0;
    public static long endTimeBubble = 0;
    public static long lastBubbleSortTime = 0;
    public static long startTimeMerge = 0;
    public static long endTimeMerge = 0;
    public static long lastMergeSortTime = 0;
    public static long startTime = 0;
    public static long endTime = 0;
    public static int num = 1;
    public static int incItems = 10;
    public static Sorting ob = new Sorting();

	 // Driver method to test above
    public static void main(String args[])
    {
    	while(true)
    	{
    		num*=incItems;

			double[] array1 = new double[num];
   		 	double[] array2 = new double[num];

	    	for (int i = 0; i<num; i++) 
	    	{
	    		double rand = Math.random();
	    		array1[i] = rand;
	    		array2[i] = rand;
	    	}
        	startTimeMerge = System.currentTimeMillis();
        	ob.sort(array2, 0, array2.length-1);
        	endTimeMerge = System.currentTimeMillis();
        	lastMergeSortTime = endTimeMerge - startTimeMerge;

            ob.bubbleSort(array1);

            System.out.println();
	        System.out.println(num + " items");
	        System.out.println("Merge Sort took " + lastMergeSortTime + " ms");
	        System.out.println("Bubble Sort took " + lastBubbleSortTime + " ms");
	    }
    }

    public static void bubbleSort(double arraySort[])
    {
        startTimeBubble = System.currentTimeMillis();
        boolean timeTest = true;
        while(timeTest)
        {
            if (System.currentTimeMillis() - startTimeBubble > 20000) 
            {
                System.out.println("Bubble Sort took longer than 20 seconds!");
                System.exit(0);    
            }
            timeTest = false;
            int sort = arraySort.length;
            for (int i = 0; i < sort-1; i++)
            {
    			if (arraySort[i] > arraySort[i+1])
    			{
        		    // swap temp and arr[i]
    			    double temp = arraySort[i];
       			    arraySort[i] = arraySort[i+1];
        		    arraySort[i+1] = temp;
                    timeTest = true;
            	}
            }
        }
        endTimeBubble = System.currentTimeMillis();
        lastBubbleSortTime = endTimeBubble - startTimeBubble;
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(double arr[], int a, int b, int c)
    {
        // Find sizes of two subarrays to be merged
        int n1 = b - a + 1;
        int n2 = c - b;
 
        /* Create temp arrays */
        double Left[] = new double [n1];
        double Right[] = new double [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
        {
            Left[i] = arr[a + i];
        }
        for (int j=0; j<n2; ++j)
        {
            Right[j] = arr[b + 1+ j];
        } 
        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;
        // Initial index of merged subarry array
        int k = a;
        while (i < n1 && j < n2)
        {
            if (Left[i] <= Right[j])
            {
                arr[k] = Left[i];
                i++;
            }
            else
            {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = Left[i];
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(double arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}