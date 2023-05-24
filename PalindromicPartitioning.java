import java.util.*;
public class PalindromicPartitioning {
	
	 public static int findMPPCuts(String st) {
		 
		 int n = st.length();
		 boolean[][] dp = new boolean[n][n];
		 
		 for(int i = 0; i < n ; i++) {
			 dp[i][i] = true;
		 }
		 int maxLength = 0;
		 for(int start = n - 2 ; start >= 0 ; start--) {
			 for(int end = start + 1; end < n ;  end++) {
				 if(st.charAt(start)==st.charAt(end)) {
					 if(end -  start==1 ||dp[start+1][end-1]) {
						 dp[start][end]= true;
						 maxLength = Math.max(maxLength,end - start + 1);
					 }
				 }
			 }
		 }
		 
		 System.out.println("Max Length is :" + maxLength);
		 if(maxLength == 0) {
			 return st.length()-1;
		 }
		 return st.length() - maxLength;
	}
	 
	 public static void main(String[] args) {
		    System.out.println(findMPPCuts("abdbca"));
		    System.out.println(findMPPCuts("cdpdd"));
		    System.out.println(findMPPCuts("pqr"));
		    System.out.println(findMPPCuts("pp"));
		    System.out.println(findMPPCuts("madam"));
		  }

}
