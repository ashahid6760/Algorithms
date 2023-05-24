import java.util.*;

public class MinimumInsertionAndDeletion {
	 
	public void findMDI(String s1, String s2) {
		    // TODO: Write your code here
		    //Find longest common Subsequence....
		    int n = s1.length();
		    int m  = s2.length();
		    
		    int[][]dp = new int[n+1][m+1];
		    
		    for(int i = 0; i <=m ; i++) {
		    	dp[0][i] = 0;
		    }
		    
		    for(int i =1; i <=n ; i++) {
		    	dp[i][0] = 0;
		    }
		    
		    for(int i = 1; i <= n ; i++) {
		    	for(int j = 1; j <=m ;j++) {
		    		if(s1.charAt(i-1)==s2.charAt(j-1)) {
		    			dp[i][j] = 1 + dp[i-1][j-1];
		    		}
		    		else {
		    			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
		    		}
		    	}
		    }
		    
		    //lcs -> Longest common subsequence...
		    
		    int c1 = dp[n][m];
		    
		    
		    System.out.println("Minimum deletions needed: " + (s1.length() - c1));
		    System.out.println("Minimum insertions needed: " + (s2.length() - c1));
	}
}
