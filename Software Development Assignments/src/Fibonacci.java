
/**
 * Fibonacci assignment, Iterative and Recursive
 * Fibonacci series: 1,1,2,3,5,8,13...
 * @author blake
 *
 */

public class Fibonacci {
	
	/**
	 * Iterative version
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param n
	 * @return
	 */
	
	public int fibonacciIteration(int n) {
		if(n <= 1) {
			return n;
		}
		int f = 1;
		int prevF = 1;
		
		for(int i = 2; i <= n; i++) {
			System.out.print(f + ",");
			int temp = f;
			f += prevF;
			prevF = temp;
			
		}
		return f;
	}
	
	/**
	 * Recursive Version
	 * Time Complexity: O(2^n)
	 * Space Complexity: O(n)
	 * 
	 * @param n
	 * @return
	 */
	
	public int fibonacciRecursive(int n) {
		if(n <= 1) {
			return 1;
		}
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	public static void main(String args[]) {
		Fibonacci f = new Fibonacci();
		long startTime;
		long endTime;
		long timeElapsed;
		
		System.out.println("Iterative Version:");
		startTime = System.nanoTime();
		System.out.println(f.fibonacciIteration(5));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Taken: " + timeElapsed + " Nanoseconds.");
		startTime = System.nanoTime();
		System.out.println(f.fibonacciIteration(10));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Taken: " + timeElapsed + " Nanoseconds.");
		startTime = System.nanoTime();
		System.out.println(f.fibonacciIteration(20));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Taken: " + timeElapsed + " Nanoseconds.");
		
		System.out.println("Recursive Version:");
		startTime = System.nanoTime();
		System.out.println(f.fibonacciRecursive(5));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Taken: " + timeElapsed + " Nanoseconds.");
		startTime = System.nanoTime();
		System.out.println(f.fibonacciRecursive(10));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Taken: " + timeElapsed + " Nanoseconds.");
		startTime = System.nanoTime();
		System.out.println(f.fibonacciRecursive(20));
		endTime = System.nanoTime();
		timeElapsed = endTime - startTime;
		System.out.println("Time Taken: " + timeElapsed + " Nanoseconds.");
	}
	
}
