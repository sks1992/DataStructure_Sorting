public class Merge_Sort {
}

/* Merge Sort is a Divide and Conquer algorithm. It divides the input
array into two halves, calls itself for the two halves, and then merges
 the two sorted halves. The merge() function is used for merging two
  halves. The merge(arr, l, m, r) is a key process that assumes that
  arr[l..m] and arr[m+1..r] are sorted and merges the two sorted
  sub-arrays into one. See the following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = l+ (r-l)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
* */
/* Java program for Merge Sort */
class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
/*
* Time Complexity: Sorting arrays on different machines. Merge Sort is a
* recursive algorithm and time complexity can be expressed as following
* recurrence relation.
T(n) = 2T(n/2) + θ(n)

The above recurrence can be solved either using the Recurrence Tree method
* or the Master method. It falls in case II of Master Method and the
* solution of the recurrence is θ(nLogn). Time complexity of Merge Sort
* is  θ(nLogn) in all 3 cases (worst, average and best) as merge sort
* always divides the array into two halves and takes linear time to merge
* two halves.
Auxiliary Space: O(n)
Algorithmic Paradigm: Divide and Conquer
Sorting In Place: No in a typical implementation
Stable: Yes

Applications of Merge Sort

1.Merge Sort is useful for sorting linked lists in O(nLogn) time.In the case of
* linked lists, the case is different mainly due to the difference in memory
* allocation of arrays and linked lists. Unlike arrays, linked list nodes may
*  not be adjacent in memory. Unlike an array, in the linked list, we can
* insert items in the middle in O(1) extra space and O(1) time. Therefore,
* the merge operation of merge sort can be implemented without extra space
*  for linked lists.
2.In arrays, we can do random access as elements are contiguous in memory. Let us
*  say we have an integer (4-byte) array A and let the address of A[0] be x then
*  to access A[i], we can directly access the memory at (x + i*4). Unlike arrays,
* we can not do random access in the linked list. Quick Sort requires a lot of
* this kind of access. In a linked list to access i’th index, we have to travel
*  each and every node from the head to i’th node as we don’t have a continuous
*  block of memory. Therefore, the overhead increases for quicksort. Merge sort
* accesses data sequentially and the need of random access is low.
3.Inversion Count Problem
4.Used in External Sorting*/