import java.util.*;
public class FindRange {
	
	public static int[] findRange(int[] arr, int key) {
	    int[] result = new int[] { -2, -1 };
	    // TODO: Write your code here
	    findRange(arr,0,arr.length-1,key,result,true);
	    findRange(arr,0,arr.length-1,key,result,false);
	    return result;
	}
	
	private static void findRange(int[]arr,int low, int high, int key, int[] result,boolean goLeft) {
		
		if(low >= high){
			return;
		}
		
		int mid =  low + (high - low)/2;
		
		if(arr[mid] > key) {
			findRange(arr,low,mid - 1,key,result,goLeft);
		}
		else if(arr[mid] < key) {
			findRange(arr,mid+1,high,key,result,goLeft);
		}
		else {
			
			if(goLeft) {
				if(mid==0||arr[mid-1]!=key) {
					result[0] = mid;
				}
				else {
					findRange(arr,low,mid-1,key,result,goLeft);
				}
			}
			else {
				if(mid==arr.length-1 || arr[mid+1]!=key) {
					result[1] = mid;
				}
				else {
					findRange(arr,mid+1,high,key,result,goLeft);
				}
			}
		}
		
		
	}
	
	 public static void main(String[] args) {
		    int[] result = findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
		    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		    result = findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
		    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		    result = findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
		    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
		  }

}
