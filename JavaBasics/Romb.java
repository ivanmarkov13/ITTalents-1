import java.util.Scanner;

public class Romb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		
		int stars = 1;
		int spaces = n-1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = spaces; j > 0; j--) {
				System.out.print(" ");
			} System.out.print(i);
			if (i>1) {
				for (int p = 0; p < stars; p++) {
					System.out.print("*");
				}
				System.out.print(i);
				stars+=2;
			}
			System.out.println();
			spaces--;
		}
		stars-=4;
		spaces++;
		
		for (int i = n-1; i >=1; i--) {
			if (i < n ) {
				for (int j = 0; j <= spaces; j++) {
					System.out.print(" ");
				}
				spaces++;
			}
				System.out.print(i);
			if(i > 1) {
				for (int p = stars; p > 0; p--) {
					System.out.print("*");
				}
				System.out.print(i);
				stars-=2;
			}
			
			System.out.println();
			}
		}
	}


