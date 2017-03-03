
public class BinarySearchForFindingNegativeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {-1,8,5,4,3,2,1,1,0,15};
		
		int numberOfNegativeNumbers = binarySearch(arr,1,arr.length-1);
		System.out.println(numberOfNegativeNumbers);
	}
	
	static int binarySearch (int [] arr, int start, int end) {
		
		if(start>end) {
			return 0;
		}
		int mid = (start+end)/2;
		
		if (arr[mid]>=0 && arr[mid-1]<0) {
			return mid;
		}
		
		if(arr[mid]>=0 && arr[mid-1]>=0) {
			return binarySearch(arr,start,mid-1);
		}
		
		return binarySearch(arr,mid+1,end);
	}

}
