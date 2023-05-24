import java.util.*;
public class LongestPalindromicSubString {
	
	 public static int findLPSLength(String st) {
		    return findLPSLength(st, 0, st.length() - 1);
     }
	 
	 private static int findLPSLength(String st, int start, int end) {
		 
		 if(start > end) {
			 return 0;
		 }
		 
		 if(start==end) {
			 return 1;
		 }
		 
		 if(st.charAt(start)==st.charAt(end)) {
			 int remainingLength = end - start - 1;
			 if(remainingLength == findLPSLength(st,start + 1, end-1)) {
			 return remainingLength +2;
		   }
	     }
		 
			 int len1 = findLPSLength(st, start + 1, end);
			 int len2 = findLPSLength(st, start,end-1);
			 return Math.max(len1, len2);
		 
	 }
	 
	 public static int findLPSLengthOptimized(String st){
		 int n = st.length();
		 boolean[][]dp = new boolean[n][n];
		 for(int i = 0 ; i < n ; i ++) {
			 dp[i][i] = true;
		 }
		 int maxLength = 1;
		 for(int start = n-2; start >= 0 ; start--) {
			 for(int end = start + 1 ; end < n ; end ++) {
				 if(st.charAt(start)==st.charAt(end)) {
					 if(end-start==1 || dp[start+1][end-1]) {
						 dp[start][end] = true;
						 maxLength = Math.max(maxLength, end-start + 1);
					 }
				 }
			 }
		 }
		 return maxLength;
	}
	 
	 public static void main(String[] args) {
		    System.out.println(findLPSLengthOptimized("abdbca"));
		    System.out.println(findLPSLengthOptimized("cddpd"));
		    System.out.println(findLPSLengthOptimized("pqr"));
      }

}
