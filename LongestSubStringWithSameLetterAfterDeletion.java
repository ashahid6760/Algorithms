import java.util.*;
public class LongestSubStringWithSameLetterAfterDeletion {
	
	public static int findLength(String str, int k) {
	    // TODO: Write your code here
		Map<Character,Integer> charFreq = new HashMap<>();
		int start = 0;
		int maxLength = 0;
		int maxRepeat = 0;
		for(int end = 0; end < str.length() ;  end++) {
			char rightChar = str.charAt(end);
			charFreq.put(rightChar, charFreq.getOrDefault(rightChar, 0)+ 1);
			maxRepeat = Math.max(maxRepeat, charFreq.get(rightChar));
			while(end - start - maxRepeat + 1  > k) {
				char leftChar = str.charAt(start);
				charFreq.put(leftChar, charFreq.get(leftChar)-1);
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
	    return maxLength;
	  }

}
