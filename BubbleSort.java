
/**
 * set swap counter to a non-zero value
 * repeat until the swap counter is zero
 *      reset swap counter to zero
 *      look at each adjacent pair
 *          if tow adjacent elements are not in order, swap them and add
 *          one to the swap counter
 *
 * worst case: array in reverse order : n^2
 * best case: no swaps needed : n
 */
import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort
{
    public static int[] sort(int[] arr) {
        int swap_counter = -1;
        int end = arr.length-1;     //tracker to avoid comparing already sorted in end
        while (swap_counter != 0) {     //stop if no swaps were made in last run
            swap_counter = 0;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i+1]) {
                    arr = swap(arr, i, i+1);
                    swap_counter++;
                }
            }
            end--;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
    public static int[] swap(int[] arr, int bigger, int smaller) {
        int temp = arr[bigger];
        arr[bigger] = arr[smaller];
        arr[smaller] = temp;
        return arr;
    }
    
    public static void main(String args[]) {
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
