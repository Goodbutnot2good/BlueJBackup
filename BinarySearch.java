
/**
 * Binary search is a fast way to searching for an item in a sorted array.
 * It cuts the array in half depending on whether the item in the middle
 * of the array is bigger/smaller than the target. 
 * 
 * In the worst case scenario, the target we are looking for is at the last
 * division, meaning that we have to split the n elements in half repeatedly.
 * It can also happen if the target isn't in the array at all.
 * 
 * Best case scenario, the item is in the middle and we find it immeditately.
 * 
 * O(logn)
 * O(1)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch
{
    public static int find (List arr, int target) {
        while (arr.size() > 1) {
            int midpoint = arr.size()/2;
            if ((Integer)arr.get(midpoint) == target) {
                return midpoint;
            } else if ((Integer)arr.get(midpoint) < target) {
                return find(arr.subList(0, midpoint), target);
            } else {
                return find(arr.subList(midpoint+1, arr.size()), target);
            }
        }
        if ((Integer)arr.get(0) == target)
            return (Integer)arr.get(0);
        else
            return -1;
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
        int answer = find(arr, target);
        if (answer == -1) {
            System.out.print("does not exist in this array");
        } else {
            System.out.print("is located in index " + answer);
        }
    }
}
