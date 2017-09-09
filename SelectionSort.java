
/*
 * 
 * repeat until no unsorted elements remain
 *      search the unsorted part of the data to find the smallest value
 *      swap the smallest value found with the first element of the unsorted part
 *      
 * worst case: iterate over every array to find smallest. repeat n times.
 * best case: same as above
 * both n(n^2)
 */

import java.util.Scanner;
import java.util.Arrays;
public class SelectionSort
{
    public static int[] sort (int[] arr) {
        for (int start_point = 0; start_point < arr.length; start_point++) {
            arr = swap(arr, search(arr, start_point) , start_point);
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
    public static int search (int[] arr, int start_point) {
        int min = arr[start_point];
        int index_of_min = -1;
        for (int i = start_point; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index_of_min = i;
            }
        }
        //return another index if a smaller minimum was found
        if (min < arr[start_point])
            return index_of_min;
        else
            return start_point;
    }
    public static int[] swap (int[] arr, int index_of_small, int index_of_big) {
        int temp = arr[index_of_big];
        arr[index_of_big] = arr[index_of_small];
        arr[index_of_small] = temp;
        return arr;
    }
    
    public static void main (String args[]) {
        System.out.println("Enter in the size of the array");
        Scanner scanner = new Scanner(System.in);
        int sz = scanner.nextInt();
        System.out.println("Enter in numbers into array");
        int[] arr = new int[sz];
        for (int i = 0; i < sz; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Scanner has closed");
        System.out.println("The final array is" + Arrays.toString(sort(arr)));
    }
}
