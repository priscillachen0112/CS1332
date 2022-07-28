import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stopIndex = arr.length - 1;
        while (stopIndex != 0) {
            int i = 0;
            int lastSwapped = 0;
            while (i < stopIndex) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    lastSwapped = i;
                }
                i++;
            }
            stopIndex = lastSwapped;
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Null array or comparator");
        }
        for (int n=arr.length-1; n>0; n--) {
            int maxIndex = 0;
            for (int i=1; i<=n; i++) {
                if (comparator.compare(arr[i], arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
            T temp = arr[n];
            arr[n] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("Null array or comparator");
        }
        for (int n=1; n<arr.length; n++) {
            int i = n;
            while (i > 0 && comparator.compare(arr[i], arr[i-1]) < 0) {
                T temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                i--;
            }
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (arr.length <= 1) {
            return;
        }
        int length = arr.length;
        int midIndex = length / 2;
        T[] left = (T[]) new Object[midIndex];
        T[] right = (T[]) new Object[length-midIndex];

        for (int i=0; i<midIndex; i++) {
            left[i] = arr[i];
        }
        for (int i=midIndex; i<length; i++) {
            right[i-midIndex] = arr[i];
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        int leftIndex = 0;
        int rightIndex = 0;
        /*int currentIndex = 0;*/
        while (leftIndex < midIndex && rightIndex < length-midIndex) {
            if (comparator.compare(left[leftIndex], right[rightIndex]) <= 0) {
                arr[leftIndex+rightIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[leftIndex+rightIndex] = right[rightIndex];
                rightIndex++;
            }
            /*currentIndex++;*/
        }
        while (leftIndex < midIndex) {
            arr[leftIndex+rightIndex] = left[leftIndex];
            leftIndex++;
        }
        while (rightIndex < length-midIndex) {
            arr[leftIndex+rightIndex] = right[rightIndex];
            rightIndex++;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (arr == null)  {
            throw new IllegalArgumentException("Array must not be null");
        }

        if (arr.length <= 1)    {
            return;
        }

        LinkedList<Integer>[] buckets = new LinkedList[19];
        int max = arr[0];
        int min = arr[0];
        int exp = 1;
        for (int i = 0; i < arr.length; i++)    {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min)   {
                min = arr[i];
            }
        }
        int iterations = 0;
        while (max != 0 || min != 0)   {
            max = max / 10;
            min = min / 10;
            iterations++;
        }
        int length = arr.length;

        for (int i = 1; i <= iterations; i++)    {
            for (int j = 0; j <= length - 1; j++)    {
                int bucket = (arr[j] / exp) % 10;
                bucket += 9;
                if (buckets[bucket] == null)    {
                    buckets[bucket] = new LinkedList<Integer>();
                }
                buckets[bucket].add(arr[j]);
            }
            int index = 0;
            for (int bucket = 0; bucket < 19; bucket++)    {
                if (buckets[bucket] == null)    {
                    buckets[bucket] = new LinkedList<Integer>();
                }
                while (!buckets[bucket].isEmpty())  {
                    arr[index] = buckets[bucket].removeFirst();
                    index++;
                }
            }
            exp *= 10;
        }
    }
}