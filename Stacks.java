
/**
 * A Stack is a type of data structure that maintains data in an organized list.
 * 
 * It is unique for having different ways of adding/removing items
 * Stacks are commonly implemented in two ways: array or inked list.
 * LIFO (last in, first out)
 */
import java.util.Scanner;
import java.util.Arrays;

public class Stacks
{
    //Array based implementation
    int top; //holds the index of the most recently added element
    int[] array; 
    
    public Stacks(int size) {
        array = new int[size];
        top = -1;       
        //currently no elements added, so top points to -1. 
    }
    
    public void add(int value) {
        array[++top] = value;
    }
    
    public int pop() {
        return array[top--];
    }
    
    @Override
    public String toString() {  
        String list = Arrays.toString(array);
        return list;
    } 
    
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter in the size of the stack");
        int sz = reader.nextInt();
        System.out.println("Enter in the values");
        Stacks stack = new Stacks(sz);
        for (int i=0; i < sz; i++) {
            stack.add(reader.nextInt());
        }
        System.out.println("This is the array" + stack + "\n Do you want to make changes?");
        reader.nextLine(); //skip newline left over
        String answer = reader.nextLine();
        System.out.println("You typed in " + answer);
        if (answer.equals("yes")) {
            System.out.println("This object " + stack.pop() + "was removed");
        }
        System.out.println("Program has ended");
    }
}
