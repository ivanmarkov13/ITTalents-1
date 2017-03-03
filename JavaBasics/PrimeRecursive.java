
public class PrimeRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 101;
		boolean prosto = isPrime(n,2);
		System.out.println(prosto);

	}
	
	static boolean isPrime (int x, int delitel) {
		if (delitel == x) {
			return true;
		}
		if (x%delitel == 0) {
			return false;
		}
		return isPrime(x,delitel+1);
	}

}
