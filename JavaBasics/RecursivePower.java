
public class RecursivePower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 2;
		int y = 7;
		System.out.println(powerRecursively(x,y));
		

	}
	static int powerRecursively(int a,int b) {
		if (b==0) {
			return 1;
		}
		if(b==1) {
			return a;
		}
		return multRecursively(powerRecursively(a,b-1),a);
	}
	static int multRecursively(int a,int b) {
		if (b==1) {
			return a;
		}
		return a + multRecursively(a,b-1); 
	}
	

}
