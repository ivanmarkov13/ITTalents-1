
public class RecursiveSumOfElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,64,7,4,6,7,21,5,6,8,9,0,43,56};
		
		System.out.println(sumOfElements(arr,3,0,0));
	}
	
	static int sumOfElements(int[]arr, int n, int i,int sum) {
	
		if(i==arr.length) {
		return sum;
	}
		if(arr[i]>n && arr[i]%2!=0) {
			sum+=arr[i];
		}
		return sumOfElements(arr,n,i+1,sum);
	}

}
