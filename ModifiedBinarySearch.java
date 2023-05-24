import java.util.*;
public class ModifiedBinarySearch {
	
	public static int search(int[] arr, int key) {
	    // TODO: Write your code here
		
		
		if(arr.length==1 && arr[0]==key) {
			return 0;
		}
		
		//Determine the direction....
		int direction = arr[0] < arr[1] ? 1 : 0;
		
		return search(arr,0,arr.length-1,key, direction);
	  }
	
	private static int search(int[] arr, int low, int high, int key, int direction) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high - low)/2;
		
		if(arr[mid]==key) {
			return mid;
		}
		int index = -1;
		 if(arr[mid] > key) {
			if(direction==1) {
				index = search(arr,low,mid-1,key,direction);
			}
			else {
				index = search(arr,mid+1,high,key,direction);
			}
		}
		
		else if(arr[mid] < key) {
			if(direction==1) {
				index = search(arr,mid+1,high,key,direction);
			}
			else {
				index = search(arr,low,mid-1,key,direction);
			}
		}
		return index;
	}
	
	 public static void main(String[] args) {
		    System.out.println(search(new int[] { 4, 6, 10 }, 10));
		    System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
		    System.out.println(search(new int[] { 10, 6, 4 }, 10));
		    System.out.println(search(new int[] { 10, 6, 4 }, 4));
		  }

}
