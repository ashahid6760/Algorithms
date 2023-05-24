import java.util.*;
public class FindLength {
	
	public static int findLength(int[] arr, int k) {
	    // TODO: Write your code here
		int ones = 0;
		int start = 0;
		int maxLength = 0;
		for(int end = 0; end < arr.length ; end++) {
			if(arr[end]==1) {
				ones++;
			}
			while(end-start + 1 - maxLength > k) {
				if(arr[start]==1) {
					ones--;
				}
				start++;
			}
			maxLength = Math.max(maxLength, end-start + 1);
		}
	    return maxLength;
	}

}
