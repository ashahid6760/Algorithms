import java.util.*;
public class LIS {
	 public int findLISLength(int[] nums) {
	      // TODO: Write your code here
		 int[] dp = new int[nums.length];
		 //Initially all number can form a subsequence containing the number itself
		 //Length of the longest subsequence would be 1.
		 for(int i = 0; i < dp.length ; i++) {
			 dp[i] = 1;
		 }
		 int n = nums.length;
		 for(int i = 1; i < n ; i++) {
			 for(int j = 0; j < i ;  j++) {
				 if(nums[i] > nums[j]) {
					 dp[i] = dp[j] + 1;
				 }
			 }
		 }
		 int max = 0;
		 for(int i =0; i < dp.length ; i++) {
			 if(dp[i] > max) {
				 max = dp[i];
			 }
		 }
	      return max;
	  }
}
