
/**
 * Call the first element of the array "sorted"
 *  repeat until all elements are sorted
 *      look at the next unsorted element. insert into the "sorted" portion
 *      by shifting the requisite number of elements.
 *      
 *      
 * worst case: array is in reverse order. shift n elements n times. (n^2)
 * best case scenario: array is already sorted. (n)
 */
import java.util.Scanner;
import java.util.Arrays;
public class InsertionSort
{
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
    
    public static int[] sort (int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i+1] < arr[i]) {
                //shift all items that are bigger than this item
                System.out.println("Found a smaller number at index " + (i+1));
                arr = shift(arr, (i+1));
                System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }
    public static int[] shift (int[] arr, int index_of_small) {
        //save the insert item
        int save = arr[index_of_small];
        int index_of_big = 0;
        //test which values before insert_index are bigger and move them over
        for (int i=index_of_small-1; i>=0; i--) {
            if (arr[i] > save) {
                arr[i+1] = arr[i];
                index_of_big = i;
            } 
        }
        System.out.println("Index of bigger number : " + index_of_big);
        arr[index_of_big] = save;
        return arr;
    }
}
