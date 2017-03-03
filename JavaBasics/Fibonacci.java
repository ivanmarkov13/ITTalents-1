
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 50;
	
		System.out.println("The sum is " + findSum(1,n));
	}
	
	static int fib (int x) {
		if (x == 1) {
			return 0;
		}
		if (x == 2) {
			return 1;
		}
		
		return fib(x-1) + fib(x-2);
	}
	static int findSum (int x,int n) {
		int sum = 0;
		while (fib(x)<n) {
			fib(x);
			System.out.print(fib(x) + " ");
			sum+=fib(x);
			++x;
		}
		return sum;
		
	}
}


