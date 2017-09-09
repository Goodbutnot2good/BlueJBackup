
/**
 * sort smaller arrays and then combine them together to make a sorted array
 * 
 * sort the left half of the array 
 * sort the right half of the array
 * merge the two halves together
 * 
 * Technical run time is O(nlogn). The worst case scenario is we have to keep splitting up the elements 
 * and then recombine them. But as size of array doubles, we only need to do 1 more split. This means 
 * that as you double size, it takes only 1 more split to make it as before. 
 * 
 * THe best case scenario is when the array is sorted, and the process is just run. THis means that best
 * run time is same as worst run time. O(nlogn). 
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MergeSort
{
    public static List sort (List original) {
        if (original.size() < 2) {
            //return a single array in the form of an arraylist. Occurs if array cannot be split any more.
            List<Integer> single = new ArrayList<Integer>();
            single.add((Integer)original.get(0));
            return single;
        } else {
            //rounds down, so right side is bigger when original length is odd
            int midpoint = original.size()/2;
            
            //make leftside return an arraylist with only "half" of size or latter "half"
            List<Integer> leftSide = sort(original.subList(0, midpoint));
            List<Integer> rightSide = sort(original.subList(midpoint, original.size())); 
            
            //merge the two lists together and return an array that will be returned 
            List<Integer> merged = merge(leftSide, rightSide);
            return merged;
        }
    }
    public static List merge (List left, List right) {
        int l = 0; 
        int r = 0;
        List<Integer> mergedTemp = new ArrayList<Integer>();
        
        /* two independent index pointers at each array. Test which one is smaller and add to temporary list.
         * Since arrays sort themselves in order, increment if added. Keep going until one array is finished.
        */
        while (l < left.size() && r < right.size()) {
            if ((int)left.get(l) < (int)right.get(r)) {
                mergedTemp.add((Integer)left.get(l));
                l++;
            }
            else if((int)right.get(r) < (int)left.get(l)) {
                mergedTemp.add((Integer)right.get(r));
                r++;
            }
            else {
                mergedTemp.add((Integer)right.get(r));
                mergedTemp.add((Integer)left.get(l));
                l++;
                r++;
            }
        }
        //Add in the other parts of the array that may have been left over. This will be sorted.
        if (l == left.size()) {
            while (r < right.size()) {
                mergedTemp.add((Integer)right.get(r));
                r++;
            }
        }
        else if (r == right.size()) {
            while (l < left.size()) {
                mergedTemp.add((Integer)left.get(l));
                l++;
            }
        }
        return mergedTemp;
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
        scanner.close();
        System.out.println("Scanner has closed. The final array is ");
        arr = sort(arr); 
        for (Integer i : arr) {
            System.out.print(i+" ");
        }
    }
}
