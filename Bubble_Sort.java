/*Bubble Sort is sorting algorithm that works by repeatedly swapping the
 adjacent elements if they are in wrong order.
Example:
First Pass:
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and
swaps since 5 > 1.
( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5),
algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
Now, the array is already sorted, but our algorithm does not know if it is completed.
 The algorithm needs one whole pass without any swap to know it is sorted.

Third Pass:
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

*/

public class Bubble_Sort {

    void bubbleSort(int arr[]){
/*In Bubble Sort if we swap grater number to next smaller number till we get
 grater number at the last of the array. We repeat same process n or
 array.length times*/
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int swap = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = swap;
                }
            }
        }
    }

    void printArray(int arr[]){
/*For Printing sorted Array*/
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");

        }
    }

    public static void main(String[]args){
        Bubble_Sort obj=new Bubble_Sort();
        int arr[]={5,8,4,3,6,7,5};
        System.out.println("Print array before Sort");
        obj.printArray(arr);
        obj.bubbleSort(arr);
        System.out.println();
        System.out.println("Print Sorted Array");
        obj.printArray(arr);


    }
}
/* Time complexity for this program is =O(n2)
* Space complexity for this program is =O(1) */

/*Optimized Bubble Sort Algorithm*/


class OptimizedBubbleSort
{
    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    // Function to print an array
    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        System.out.println("Array Before Sorted: ");
        printArray(arr, n);
        System.out.println();
        bubbleSort(arr, n);
        System.out.println("Optimized Sorted array: ");
        printArray(arr, n);
    }
}
/* Time complexity for this program is =O(n2)
 * Space complexity for this program is =O(1) */