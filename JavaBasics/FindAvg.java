
public class FindAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,-5,-7,-3,-9,50};
		System.out.println(findAvg(arr,0,0));
		

	}
	static String findAvg(int []arr, int n, double sum) {
		if (n<arr.length) {
			sum+=arr[n];
			System.out.println(sum);
		
			return findAvg(arr,n+1,sum);
		
		}
		double avg = sum/ arr.length;
		System.out.println(avg);
		if (avg> 0) {
			return "Positive";
		}
		else {
			return "Negative";
		}
	}
}
	