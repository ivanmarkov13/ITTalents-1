
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = { 1,6,8,11,13,21,90,102};
		System.out.println(binarySearch(arr,21,0,arr.length-1));

	}
	static int binarySearch (int [] arr, int x, int start, int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		
		if (arr[mid]==x) {
			return mid;
		}
		if (arr[mid] < x) {
			return binarySearch(arr,x,mid+1,end);
		}	
			return binarySearch(arr,x,start,mid-1);
		
		
	}

}
