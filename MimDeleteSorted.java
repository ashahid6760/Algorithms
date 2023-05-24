import java.util.*;
public class MimDeleteSorted {
	 public int findMinimumDeletions(int[] nums){
		    // TODO: Write your code here
		 int[] dp = new int[nums.length];
		 //Find the longest increasing subsequence...
		 //Initially every element is a part of a subsequence involving itself...
		 for(int i = 0; i < dp.length ; i++) {
			 dp[i] = 1;
		 }
		 
		 for(int i = 1; i < dp.length ; i++) {
			 for(int j = 0; j < i ; j++) {
				 if(nums[i] >= nums[j] && dp[i] <= dp[j]) {
					 dp[i] = dp[j] +1; 
				 }
			 }
		 }
		 
		 int longest = 0;
		 for(int i = 0; i < dp.length ; i++) {
			 if(longest < dp[i]) {
				 longest = dp[i];
			 }
		 }
		 
		 return nums.length-longest;
		  }
}
