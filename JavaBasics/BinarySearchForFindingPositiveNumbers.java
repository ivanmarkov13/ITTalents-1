
public class BinarySearchForFindingPositiveNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = { -50,-45,-34,-21,-9,-2,7,10,17,25,29,31,45,56,65,78};
		System.out.println(binarySearch(arr,1,arr.length-1));

	}
	static int binarySearch (int[]arr,int start,int end) {
		if (start>end) {
			return 0;
		}
		int mid=(start+end)/2;
		if (arr[mid-1]<0 && arr[mid]>=0) {
			return arr.length-mid;
		}
		if(arr[mid]>=0 && arr[mid-1]>=0) {
			return binarySearch(arr,start,mid-1);
		}
		return binarySearch(arr,mid+1,end);
	}

}
