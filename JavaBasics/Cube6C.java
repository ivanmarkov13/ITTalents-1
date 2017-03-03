
public class Cube6C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 125;
		cube(n,square(n));
		
		

	}
	static void cube (int n,int x) {
		for (int i = 1; i <= x; i++) {
			if(i*i*i==n) {
				System.out.println(n + " is a cube of " + i);
				return;
			}
		}
			System.out.println("The number is not a cube.");
	}
	static int square (int n) {
		for (int i = 1; i <= i/2; i++) {
			if(i*i==n) {
				return i;
			}
		}
		return n;
	}

}
