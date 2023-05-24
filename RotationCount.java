import java.util.*;
public class RotationCount {
	
	  public static int countRotations(int[] arr) {
		   // TODO: Write your code here
		  return searchPivot(arr,0,arr.length-1);  
		  }
	  
	  private static int searchPivot(int[] arr, int low, int high) {
		  if(arr[low] < arr[high]) {
			  return low;
		  }
		  int mid = low + (high - low)/2;
		  if(mid < high && arr[mid] > arr[mid+1]) {
			  return mid+1;
		  }
		   if(mid > low && arr[mid-1] > arr[mid]) {
			  return mid;
		  }
		   
		   
		   if(arr[low] < arr[mid]) {
			  return searchPivot(arr,mid+1,high);
		  }
		   else {
			   return searchPivot(arr,low,mid-1);
		   }
	  }
	  
	  public static void main(String[] args) {
		    System.out.println(countRotations(new int[] { 10, 15, 1, 3, 8 }));
		    System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
		    System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));
		  }


}
