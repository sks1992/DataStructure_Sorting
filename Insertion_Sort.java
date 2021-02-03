/*Insertion sort is a simple sorting algorithm that works similar to
 the way you sort playing cards in your hands. The array is virtually
 split into a sorted and an unsorted part. Values from the unsorted part
 are picked and placed at the correct position in the sorted part.
Algorithm
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (temp) to its predecessor.
3: If the temp element is smaller than its predecessor, compare it to the
 elements before. Move the greater elements one position up to make space
 for the swapped element.

 Ex:
 12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 4 (last element of the array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one
 position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position
ahead of their current position.
5, 6, 11, 12, 13
* */
public class Insertion_Sort {

    /*Function to sort array using insertion sort*/
    void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int temp = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than temp, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };

        Insertion_Sort isort = new Insertion_Sort();

        System.out.println("Print Array Before sorting");
        printArray(arr);

        System.out.println();
        System.out.println();

        System.out.println("Print array after Sorting");
        isort.insertionSort(arr);

        printArray(arr);
    }
}
/*
* Time Complexity: O(n*2)

Auxiliary Space: O(1)

Boundary Cases: Insertion sort takes maximum time to sort if elements are
sorted in reverse order. And it takes minimum time (Order of n) when
elements are already sorted.

Algorithmic Paradigm: Incremental Approach

Sorting In Place: Yes

Stable: Yes

Online: Yes

Uses: Insertion sort is used when number of elements is small. It can also
be useful when input array is almost sorted, only few elements are
misplaced in complete big array.

What is Binary Insertion Sort?
We can use binary search to reduce the number of comparisons in normal insertion
sort. Binary Insertion Sort uses binary search to find the proper location to
insert the selected item at each iteration. In normal insertion, sorting takes O(i)
(at ith iteration) in worst case. We can reduce it to O(logi) by using binary search.
The algorithm, as a whole, still has a running worst case running time of O(n2)
because of the series of swaps required for each insertion.*/