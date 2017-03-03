
public class HulmIliPadina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {1,2,3,4,10,8,7,4,0};
		System.out.println("The extremum is with index " + binarySearch(arr,0,arr.length-1));
	}
	
	static int binarySearch (int [] arr, int start, int end) {
		int mid = (start+end)/2;
		boolean hulm = false;
		boolean padina = false;
		if (arr[0] > arr[1]) {
			padina = true;
			System.out.println("Padina");
		}
		if (arr[0]<arr[1]) {
			hulm = true;
			System.out.println("Hulm");
		}
		
		if (padina) {
			if (arr[mid] < arr[mid-1] && arr[mid]==arr[end-1]){
				return mid;
			}
			if (arr[mid]< arr[mid+1] && arr[mid] < arr[mid-1]) {
				return mid;
			}
			if (arr[mid] > arr[mid+1] && arr[mid]< arr[mid-1]) {
				return binarySearch(arr,mid+1,end);
			}
			return binarySearch(arr,start,mid-1);
		}
		
		if(arr[mid]>arr[mid-1] && arr[mid]==arr[end-1]) {
			return mid;
		}
		if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid-1]) {
			return mid;
		}
		if (arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]) {
			return binarySearch(arr,start,mid-1);
		}
		return binarySearch(arr,mid+1,end);
	}

}
