import java.util.*;
public class Ceiling {
	
	public static int searchCeilingOfANumber(int[] arr, int key) {
	    // TODO: Write your code here
		
		int low = 0;
		int high = arr.length - 1;
		return searchCeilingOfANumber(arr,low,high,key);
	  }
	
	private static int searchCeilingOfANumber(int[] arr, int low, int high, int key) {
		if(key <= arr[low]) {
			return low;
		}
		if(key > arr[high]) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		
		if(arr[mid] == key) {
			return mid;
		}
		
		if(arr[mid] < key) {
			//The the ceiling is in the right half..
			return searchCeilingOfANumber(arr,mid + 1, high,key);
		}
		
		else {
			return searchCeilingOfANumber(arr,low,mid-1,key);
		}
		
		
	}
	
	public static void main(String[] args) {
	    System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
	    System.out.println(searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
	    System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
	    System.out.println(searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
	  }

}
