import java.util.*;

public class BitonicArrayMaximum {
	
	 public static int findMax(int[] arr) {
		    // TODO: Write your code here
		 int max = Integer.MIN_VALUE;
		    return findMax(arr,0,arr.length-1,max);
	  }
	 
	 private static int findMax(int[] arr, int low, int high,int max) {
		 
		 if(low > high) {
			 return max;  //This base case is incorrect...
		 }
		 
		 int mid = low + (high - low)/2;
		 int currMax = arr[mid];
		 
		 if(currMax > max) {
			 max = currMax;
		 }
		 //Found a peak..
		 if(mid!=0 &&  arr[mid-1] > arr[mid]) {
			 max =   findMax(arr,low,mid-1,max);
		 }
		 else if(mid!=arr.length-1 && arr[mid+1] > arr[mid]) {
			 max =  findMax(arr,mid+1,high,max);
		 }
		 return max;
	 }
	 
	 public static void main(String[] args) {
		    System.out.println(findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
		    System.out.println(findMax(new int[] { 3, 8, 3, 1 }));
		    System.out.println(findMax(new int[] { 1, 3, 8, 12 }));
		    System.out.println(findMax(new int[] { 10, 9, 8 }));
		  }

}
