import java.util.*;
public class LongestSubStringKDistinct {
	
	public static int findLength(String str, int k) {
	    // TODO: Write your code here
		Set<Character> hashSet = new HashSet<>();
		int windowStart = 0;
		int maxLength = Integer.MIN_VALUE;
		for(int windowEnd = 0; windowEnd < str.length() ; windowEnd++) {
			char currChar = str.charAt(windowEnd);
			if(!hashSet.contains(currChar)) {
				hashSet.add(currChar);
			}
			if(hashSet.size()==k) {
				maxLength = Math.max(maxLength,windowEnd - windowStart + 1);
				hashSet.remove(str.charAt(windowStart));
				windowStart++;
			}
		}
	    return maxLength;
	 }

}
