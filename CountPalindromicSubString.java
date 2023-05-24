
public class CountPalindromicSubString {
	
	private static int findCPS(String str) {
		
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		int count = 0;
		for(int i = 0; i < n ; i++) {
			dp[i][i] = true;
			count++;
		}
		
		for(int start = n-2; start >=0 ; start--) {
			for(int end = start+1 ; end < n ; end ++) {
				
				if(str.charAt(start)==str.charAt(end)) {
					if(end - start==1 || dp[start+1][end-1]) {
						dp[start][end] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
	
	 public static void main(String[] args) {
		    System.out.println(findCPS("abdbca"));
		    System.out.println(findCPS("cdpdd"));
		    System.out.println(findCPS("pqr"));
		  }

}
