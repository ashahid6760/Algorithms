import java.util.*;
public class SearchInBitonicArray {
	
	  public static int search(int[] arr, int key) {
		    // TODO: Write your code here
		  int peak = findPeak(arr,0,arr.length-1);
		  if(arr[peak]==key) {
			  return peak;
		  }
		  int result = binarySearch(arr,0,peak-1,key);
		  if(result==-1) {
			  result = rBinarySearch(arr,peak+1,arr.length-1,key);
		  }
		  return result;
	}
	  
	  //Function to find the peak...
	  
	  private static int findPeak(int[] arr, int low, int high) {
		  
		  if(low==high) {
			  return low;
		  }
		  int mid = low + (high - low)/2;
		  if( arr[mid-1] > arr[mid]) {
			  return findPeak(arr,low,mid-1);
		  }
		  else if(arr[mid+1] >  arr[mid]) {
			  return findPeak(arr,mid+1,high);
		  }
		  else {
			  return mid;
		  }
		  
	  }
	  
	  private static int binarySearch(int[] arr, int low, int high, int key) {
		  if(low > high) {
			  return -1;
		  }
		  int mid = low + (high - low)/2;
		  if(key < arr[mid]) {
			  return binarySearch(arr,low,mid-1,key);
		  }
		  else if(key > arr[mid]) {
			  return binarySearch(arr,mid+1,high,key);
		  }
		  else {
			  return mid;
		  }
	  }
	  
	  private static int rBinarySearch(int[]arr, int low, int high, int key) {
		  if(low > high) {
			  return -1;
		  }
		  int mid = low + (high - low)/2;
		  if(arr[mid] > key) {
			  return rBinarySearch(arr,mid+1,high,key);
		  }
		  else if(arr[mid] < key) {
			  return rBinarySearch(arr,low,mid-1,key);
		  }
		  else {
			  return mid;
		  }
	  }
	  
	 
	  
	  public static void main(String[] args) {
		    System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));
		    System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));
		    System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));
		    System.out.println(search(new int[] { 10, 9, 8 }, 10));
		  }

}
