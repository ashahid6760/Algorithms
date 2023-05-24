import java.util.*;
public class LongestCommonSubString {
	 
	public static int findLCSLength(String s1, String s2) {
		    // TODO: Write your code here
		return findLCS(s1,s2,0,0,0); 
	}
	
	private static int findLCS(String s1, String s2, int idx1, int idx2, int count) {
		
		if(s1=="" || s2=="") {
			return 0;
		}
		if(idx1 >= s1.length() || idx2 >= s2.length()) {
			return 0;
		}
		
		if(s1.charAt(idx1)==s2.charAt(idx2)) {
			count = findLCS(s1,s2,idx1+1,idx2+1,count+1);
		}
		int c1 = findLCS(s1,s2,idx1+1,idx2,0);
		int c2 = findLCS(s1,s2,idx1,idx2+1,0);
		return Math.max(count,Math.max(c1,c2));
	}
	
	public static void main(String[] args) {
	    System.out.println(findLCS("abdca", "cbda"));
	    System.out.println(findLCS("passport", "ppsspt"));
	  }
	
	private static int findLCS(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		
		for(int i = 0; i <= m ; i++) {
			dp[0][i] = 0;
		}
		
		for(int i = 1; i <= n ; i++) {
			dp[i][0] = 0;
		}
		
		int maxLength = 0;
		
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j<= m ; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					maxLength = Math.max(maxLength,dp[i][j]);
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		return maxLength;
	}
}
