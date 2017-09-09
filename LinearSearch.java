
/**
 * Linear search iterates across the element from left to right. 
 * 
 * Repeating at the first element, 
 *      if the first element is what you're looking for, then stop.
 *      otherwise, move on to the next element. 
 *      
 * While this algorithm is simple, it offers the fastest best case secnario run time of O(1) being the first
 * element. In the worst time, it takes O(n) since we iterate over the entire array. 
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class LinearSearch
{
    public static int sort (List arr, int target) {
        /* convert the list arr to specifically hold Integer. Without this conversion, you get an error
         * about object is not compatible with integer.
         */
        List<Integer> arrConvert = new ArrayList<Integer>();
        arrConvert = arr;
        /* hold the index of target in local variable in order to satisfy condition that something has to
         * return at the end. Return -1 if not found.
         */
        int index = -1;
        for (Integer num : arrConvert) {
            if (num == target) {
                index = arrConvert.indexOf(num);
                break;
            }
        }
        return index;
    }
    
    public static void main (String [] args) {
        System.out.println("Enter in the size of the array");
        Scanner scanner = new Scanner(System.in);
        int sz = scanner.nextInt();
        System.out.println("Enter in numbers into array");
        List<Integer> arr = new ArrayList<Integer>(sz);
        for (int i = 0; i < sz; i++) {
            arr.add(scanner.nextInt());
        }
        System.out.println("Enter in the number/target that you want");
        int target = scanner.nextInt();
        scanner.close();
        System.out.print("Scanner has closed.\nThe target you are looking for "); 
        //hold answer in variable, check if answer is -1 (meaning it doesn't exist). and print correct response
        int answer = sort(arr, target);
        if (answer == -1) {
            System.out.print("does not exist in this array");
        } else {
            System.out.print("is located in index " + answer);
        }
    }
}
