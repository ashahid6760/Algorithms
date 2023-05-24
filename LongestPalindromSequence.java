import java.util.*;
public class LongestPalindromSequence {
	
	
	public static int findLPSLength(String st) {
		  int start = 0;
		  int end = st.length()-1;
		  return findLPSLengths(st,start, end);
	}
	
	private static int findLPSLengths(String str, int start, int end) {
		
		if(start > end) {
			return 0;
		}
		
		//Three Possible cases
		//1-if first and last element are equal, then they will be included in plaindromic subsequence
		//If first and last are not equal, the return Max by excluding either first or last
		
		if(start==end) {
			return 1;
		}
	
		if(str.charAt(start) == str.charAt(end)) {
			return  2 + findLPSLengths(str, start + 1, end -1);
		}
		else  {
			int len1, len2;
			len1 = findLPSLengths(str, start + 1, end);
			len2 = findLPSLengths(str,start,end-1);
			return Math.max(len1, len2);
		}
	}
	
	public static int findLPSLengthOptimized(String st) {
		
		int n = st.length();
		int[][] dp = new int[n][n];
		
		//All the diagonal Entry will be one as it deals with string of just on character, and indeed it is a 
		//Palindromic subsequence of length 1;
		
		for(int i = 0; i < n ; i++) {
			dp[i][i] = 1;
		}
		
		for(int start = n-2 ; start >= 0 ;  start --) {
			for(int end = start +1 ; end < n ; end ++) {
				if(st.charAt(start)==st.charAt(end)) {
					dp[start][end] = 2 + dp[start + 1][end-1];
				}
				else {
					dp[start][end] = Math.max(dp[start + 1][end], dp[start][end-1]);
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(findLPSLengthOptimized("abdbca"));
	    System.out.println(findLPSLengthOptimized("cddpd"));
	    System.out.println(findLPSLengthOptimized("pqr"));
	}
	  

}
