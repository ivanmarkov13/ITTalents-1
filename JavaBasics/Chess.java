import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [][] chessBoard = {
									{' ','x','x',' ',' ',' ',' ',' '},	
									{' ','x','x',' ',' ',' ',' ',' '},	
									{'x','x','x',' ',' ',' ',' ',' '},	
									{'x','x','x',' ',' ',' ',' ',' '},	
									{' ',' ',' ',' ',' ',' ',' ',' '},	
									{' ',' ',' ',' ',' ',' ',' ',' '},	
									{' ',' ',' ',' ',' ',' ',' ',' '},	
									{' ',' ',' ',' ',' ',' ',' ',' '}
							};
		int numberOfPawns = 0;
		
		do{ 
			Random r = new Random();
			int x = r.nextInt(8);
			int y = r.nextInt(8);
			chessBoard [x][y] = 'x';
			numberOfPawns++;
		}while (numberOfPawns<15);
		 
		for (int i = 0; i < chessBoard.length; i++) {
			System.out.println(Arrays.toString(chessBoard[i]));
		}
		
		Scanner sc = new Scanner(System.in);
		int horseRow,horseCol,kingRow,kingCol;
		
		do {
			System.out.println("Please enter coordinates of the king(first row, then column):");
			kingRow = sc.nextInt();
			kingCol = sc.nextInt();
			System.out.println("Please enter coordinates of the horse(first row, then column):");
			horseRow = sc.nextInt();
			horseCol = sc.nextInt();
		} while (!isValid(kingRow,chessBoard) || !isValid(kingCol,chessBoard) || !isValid(horseRow,chessBoard) || 
				!isValid(horseCol,chessBoard) || checkForPawn(chessBoard,kingRow,kingCol) || 
				checkForPawn(chessBoard,horseRow, horseCol) || !horseIsDifferentThanKing(kingRow,kingCol,horseRow,horseCol));

		
		System.out.println(killKing(chessBoard,kingRow,kingCol,horseRow,horseCol));
	}
	
		static boolean killKing (char[][] arr, int kingRow, int kingCol, int horseRow, int horseCol){
			
			return horseMover(arr,kingRow,kingCol,horseRow,horseCol);
		}
		
		static boolean horseMover (char[][] arr, int kingRow, int kingCol, int horseRow, int horseCol) {
				if (!isValid(horseRow,arr) || !isValid(horseCol,arr) || 
				arr[kingRow][kingCol]!=arr[horseRow][horseCol] ||
				checkForPawn(arr,horseRow,horseCol)) {
				return false;
			}
				arr[horseRow][horseCol] = 'h';
		
			if (arr[kingRow][kingCol] == arr[horseRow][horseCol]) {
				return true;
			}
			
			return (horseMover(arr,kingRow,kingCol,horseRow-1,horseCol-2) ||
			horseMover(arr,kingRow,kingCol,horseRow-2,horseCol-1) || 
			horseMover(arr,kingRow,kingCol,horseRow-1,horseCol+2)|| 
			horseMover(arr,kingRow,kingCol,horseRow-2,horseCol+1)||
			horseMover(arr,kingRow,kingCol,horseRow+1,horseCol-2)||
			horseMover(arr,kingRow,kingCol,horseRow+2,horseCol-1)||
			horseMover(arr,kingRow,kingCol,horseRow+2,horseCol+1)||
			horseMover(arr,kingRow,kingCol,horseRow+1,horseCol+2) );
		}
	
	static boolean isValid (int x,char[][]arr) {
		if (x < 0 || x > arr.length-1) {
			return false;
		}
		return true;
	}
	
	static boolean checkForPawn (char[][]arr, int x, int y) {
		if (arr[x][y] == 'x') {
			return true;
		}
		return false;
	}
	
	static boolean horseIsDifferentThanKing ( int x, int y,int x1, int y1) {
		if(x==x1 && y == y1) {
			return false;
		} return true;
	}
}
