import java.util.*;

public class SearchInRotatedArray {
	
	  
	
	public static int search(int[] arr, int key) {
		    // TODO: Write your code here
		int k = findRotationNumber(arr);
		int idx = binarySearch(arr,k,arr.length-1,key);
		if(idx==-1) {
			idx = binarySearch(arr,0,k-1,key);
		}
		return idx;
	  }
	
	private static int binarySearch(int[] arr, int low, int high, int key) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high - low)/2;
		
		if(arr[mid] < key) {
			return binarySearch(arr,mid+1,high,key);
		}
		else if(arr[mid] > key) {
			return binarySearch(arr,low,mid-1,key);
		}
		else {
			return mid;
		}
	}

	
	private static int findRotationNumber(int[] arr) {
		int i;
		for(i = 1 ; i< arr.length ; i++) {
			if(arr[i-1] > arr[i]) {
				break;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
	    System.out.println(search(new int[] { 10, 15, 1, 3, 8 }, 15));
	    System.out.println(search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	   }

}
