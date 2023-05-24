import java.util.*;


class ArrayReader {
	  int[] arr;

	  ArrayReader(int[] arr) {
	    this.arr = arr;
	  }

	  public int get(int index) {
	    if (index >= arr.length)
	      return Integer.MAX_VALUE;
	    return arr[index];
	  }
	}



public class SearchInSortedInfiniteArray {

	public static int search(ArrayReader reader, int key) {
	    // TODO: Write your code here
		///Step 1 search valid range..
		int start = 0;
		int end = 1;
		while(reader.get(end) < key) {
			int newStart = end + 1;
			end += (end - start + 1) * 2;
			start = newStart;
		}
		//We have found a range, Perform binary Search to get the real Position...
		int index = findIndex(reader,start,end,key);
	    return index;
	  }
	
	private static int findIndex(ArrayReader reader, int start, int end, int key) {
		if(start > end) {
			return -1;
		}
		int mid = start + (end - start)/2;
		if(reader.get(mid) > key) {
			return findIndex(reader,start,mid-1,key);
		}
		else if(reader.get(mid) < key) {
			return findIndex(reader,mid+1,end,key);
		}
		else {
			return mid;
		}
	}
	
	public static void main(String[] args) {
	    ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
	    System.out.println(search(reader, 16));
	    System.out.println(search(reader, 11));
	    reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
	    System.out.println(search(reader, 15));
	    System.out.println(search(reader, 200));
	  }

}
