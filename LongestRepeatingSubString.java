import java.util.*;
public class LongestRepeatingSubString {
	public int findLRSLength_R(String str) {
	    // TODO: Write your code here
		int idx1 = 0;
		int idx2 = 0;
		return findLRS(str,idx1,idx2);
	}
	private int findLRS(String str, int idx1,int idx2) {
		
		if(idx1==str.length() ||idx2==str.length()) {
			return 0;
		}
		
		if(str.charAt(idx1)==str.charAt(idx2)&&idx1!=idx2) {
			return 1 + findLRS(str,idx1+1,idx2+1);
		}
		
		int l1 = findLRS(str,idx1+1,idx2);
		int l2 = findLRS(str,idx1,idx2+1);
		return Math.max(idx1, idx2);
	}
	
	public int findLRSLength(String str) {
		
		int n = str.length();
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 0 ; i <=n ; i++) {
			dp[0][i] = 0;
		}
		
		for(int i =1; i <=n ; i++) {
			dp[i][0] = 0;
		}
		
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1; j <=n ; j++) {
				if(str.charAt(i)==str.charAt(j)&&(i!=j)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}
}
