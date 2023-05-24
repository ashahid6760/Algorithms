import java.util.*;
public class MIS {
	 
	public int findMSIS_R(int[] nums) {
	      // TODO: Write your code here
		int previous = -1;
		int current = 0;
		return maxIncreasingSum(nums, previous, current);
	  }
	
	private int maxIncreasingSum(int[] nums, int previous, int current) {
		if(current == nums.length) {
			return 0;
		}
		int sum1 = Integer.MIN_VALUE;
		if(previous==-1 || nums[current] >= nums[previous]) {
			sum1 = nums[current] + maxIncreasingSum(nums,current, current + 1);
		}
		int sum2 = maxIncreasingSum(nums,previous,current+1);
		return Math.max(sum1, sum2);
	}
	
	public int findMSIS(int[] nums) {
	      // TODO: Write your code here
		int[] dp = new int[nums.length];
		for(int i = 0; i < dp.length ; i++) {
			dp[i] = nums[i];
		}
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i ; j++) {
				if(nums[j] <= nums[i]) {
					if(dp[i] < dp[j] + nums[i]) {
						dp[i] = dp[j] + nums[i];
					}
				}
			}
		}
	      return dp[nums.length-1];
	  }
}
