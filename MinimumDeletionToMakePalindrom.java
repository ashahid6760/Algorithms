import java.util.*;

public class MinimumDeletionToMakePalindrom {
	  public static int findMinimumDeletions(String st) {
		  //Step 1 Find the longest palindromic sequence found
		  //Substract it with the length of the string
		  //It will geive you the minimum deletion required to make string a plaindrome
		  
		  int n = st.length();
		  int[][] dp = new int[n][n];
		  
		  for(int i = 0; i < n ; i++) {
			  dp[i][i] = 1;
		  }
		  
		  for(int start = n-2; start >= 0 ; start--) {
			  for(int end = start + 1; end < n ;  end++) {
				  if(st.charAt(start)== st.charAt(end)) {
					  dp[start][end] = 2 + dp[start+1][end-1];
				  }
				  else  {
					  dp[start][end] = Math.max(dp[start][end-1],dp[start+1][end]);
				  }
			  }
		  }
		  
		  int maxPalindrome = dp[0][n-1];
		  return st.length() - maxPalindrome;
		  }
	  
	  public static void main(String[] args) {
		    System.out.println(findMinimumDeletions("abdbca"));
		    System.out.println(findMinimumDeletions("cddpd"));
		    System.out.println(findMinimumDeletions("pqr"));
		  }
}
