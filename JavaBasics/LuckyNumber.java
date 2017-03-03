import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class LuckyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int start = 0;
		int end = 100;
		Scanner sc = new Scanner(System.in);
		
		while (start<=end) {
			int mid = (start+end)/2;
			System.out.println(mid + "?");
			int answer = sc.nextInt();
			
			if (answer==0) {
				end = mid-1;
			}
			if (answer ==1) {
				break;
			}
			if (answer==2) {
				start = mid+1;
			}
		}

	}

}
