
public class Labirinth2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] labirinth = { 
				//0   1   2   3   4   5   6   7   8   9
				{'W','W','W',' ','W','W','W','W',' ','W'},// 0
				{'W',' ',' ',' ',' ',' ',' ',' ',' ','W'},// 1
				{'W',' ',' ',' ',' ',' ',' ',' ',' ','W'},// 2
				{'W',' ','W',' ',' ','W',' ',' ',' ',' '},// 3
				{'W',' ',' ','W',' ',' ',' ',' ',' ','W'},// 4
				{'W',' ',' ',' ',' ',' ',' ',' ',' ','W'},// 5
				{'W',' ','W','W','W','W','W','W','W','W'}// 6
		};
		int x = 0;
		int y = 8;
		System.out.println(countSteps(labirinth,x,y,6,1));
		
		

	}
	static int countSteps (char[][]arr,int x1,int y1,int x2,int y2) {
		int counter = 0;
		if (canStep(arr,x1,y1,x2,y2)) {
			for (int i = x1<x2?x1:x2; i < (x1<x2?x2:x1); i++) {
				counter++;
			}
			for (int i = y1<y2?y1:y2; i < (y1<y2?y2:y1); i++) {
				counter++;
			}
			
			return counter;
		}
		return -1;
	}
	static boolean canStep (char[][] arr, int x1,int y1, int x2, int y2) {
		if (!isValid(arr,x1,y1) || arr[x1][y1]!=arr[x2][y2]) {
			return false;
		}
		arr[x1][y1] = 'x';
		if (x1==x2 && y1==y2) {
			return true;
		}
		
		return (canStep(arr,x1+1,y1,x2,y2) ||
				canStep(arr,x1,y1+1,x2,y2) ||
				canStep(arr,x1-1,y1,x2,y2)||
				canStep(arr,x1,y1-1,x2,y2));
	}
	
	
	static boolean isValid(char[][] arr, int x,int y) {
		if (x<0 || x>arr.length-1 || y<0 || y>arr[0].length-1 || arr[x][y] != ' ') {
			return false;
		}
		else {
			return true;
		}
	}

}
