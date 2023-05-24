import java.util.*;
public class LongestSubStringDistinctCharacter {
	 public static int findLength(String str) {
		    // TODO: Write your code here
		 
		 int start = 0;
		 int maxLength = 0;
		 
		Set<Character> diffChar = new HashSet<>();
		for(int end = 0; end < str.length() ; end++) {
			
			if(diffChar.contains(str.charAt(end))) {
				maxLength = Math.max(maxLength, end-start);
				diffChar.clear();
				maxLength = Math.max(maxLength, end-start);
				start = end;
			}
			
			if(!diffChar.contains(str.charAt(end))) {
				diffChar.add(str.charAt(end));
				maxLength = Math.max(maxLength, end-start+1);
			}
		}
		return maxLength;
	 }

}
