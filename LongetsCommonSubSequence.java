import java.util.*;
public class LongetsCommonSubSequence {

	public int findLCSLength(String s1, String s2) {
	      // TODO: Write your code here
		
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		
		//Length of longest subsequence when compared to an empty String is 0...
		for(int i = 0; i <= n ; i++) {
			dp[0][i] = 0;
		}
		
		//Length of longest subsequce when compared to an empty String is 0...
		
		for(int i = 1; i <= m ; i++) {
			dp[i][0] = 0;
		}
		
		//optimal substructure is as follow:
		for(int i=1 ; i<= n ; i++) {
			for(int j = 1; j<= m ; j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
	      return dp[n][m];
	  }
}
