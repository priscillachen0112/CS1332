import java.util.ArrayList;
import java.util.Comparator;

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

    /* public static void main(String[] args) {
        int[] testArr = new int[]{5, 0, 1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println(selectionSort(testArr);
    } */
}