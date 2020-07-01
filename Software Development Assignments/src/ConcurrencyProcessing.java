import java.util.*;
public class ConcurrencyProcessing extends Thread {
	
	private int[] arr;
	private int low, high, partial;

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[200000000];

	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = rand.nextInt(101) + 1; // 1..100
	    }

	    long start = System.currentTimeMillis();

	    int singleSum = ConcurrencyProcessing.sum(arr);

	    System.out.println("Single Time: " + (System.currentTimeMillis() - start));
	    System.out.println("Single Sum: " + singleSum);

	    start = System.currentTimeMillis();

	    int parallelSum = ConcurrencyProcessing.parallelSum(arr);

	    System.out.println("Parallel Time: " + (System.currentTimeMillis() - start));
	    System.out.println("Parallel Sum: " + parallelSum);

	}
	
	public ConcurrencyProcessing(int[] arr, int low, int high){
        this.arr = arr;
        this.low = low;
        this.high = Math.min(high, arr.length);
    }
	
	public static int sum(int[] arr){
        return sum(arr, 0, arr.length);
    }
	
	public void run(){
        partial = sum(arr, low, high);
    }
	
	public int getPartialSum(){
        return partial;
    }
	
	public static int sum(int[] arr, int low, int high) {
		int total = 0;

        for (int i = low; i < high; i++) {
            total += arr[i];
        }

        return total;
	}
	
	public static int parallelSum(int[] arr){
        return parallelSum(arr, Runtime.getRuntime().availableProcessors());
    }
	
	public static int parallelSum(int[] arr, int threads)
    {
        int size = (int) Math.ceil(arr.length * 1.0 / threads);

        ConcurrencyProcessing[] sums = new ConcurrencyProcessing[threads];

        for (int i = 0; i < threads; i++) {
            sums[i] = new ConcurrencyProcessing(arr, i * size, (i + 1) * size);
            sums[i].start();
        }

        try {
            for (ConcurrencyProcessing sum : sums) {
                sum.join();
            }
        } catch (InterruptedException e) { }

        int total = 0;

        for (ConcurrencyProcessing sum : sums) {
            total += sum.getPartialSum();
        }

        return total;
    }

}
