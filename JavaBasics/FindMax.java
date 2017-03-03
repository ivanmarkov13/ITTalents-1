
public class FindMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = { 1,5,9,3,6,3};
		int result = findMax(array,0);
		System.out.println(result);
	}
	
	static int findMax (int [] arr, int startIdx) {
		if (startIdx == arr.length-1) {
			return arr[startIdx];
		}
		int maxOfrest = findMax (arr, startIdx+1);
		if (maxOfrest > arr[startIdx]) {
			return maxOfrest;
		}
		else {
			return arr[startIdx];
		}
	}

}
