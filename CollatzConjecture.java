
/**
 * The collatz conjecture says that it is always possible to get the number 1 if you follow this step with
 * any positive number.
 * 
 * if n is one, stop.
 * otherwise, if n is even, repeat this process on n/2.
 * otherwise, if n is odd, repeat this process on 3n+1. 
 */
public class CollatzConjecture
{
    //returns how many steps it takes to get to 1.
    public static int collatz(int n) {
        //the base case
        if (n == 1)
            return 0;
        //recursive case
        else if (n % 2 ==0) {
            //the current operation is one step
            return 1 + collatz(n/2);     
        }
        else {
            return 1 + collatz(3*n +1); 
        }
    }
}
