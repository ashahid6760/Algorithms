import java.util.*;

public class MinimumSubString {
	public static String findSubstring(String str, String pattern) {
	    // TODO: Write your code here
		
		Map<Character,Integer> charFreq = new HashMap<>();
		for(int i = 0; i < pattern.length() ; i++) {
			char currChar = pattern.charAt(i);
			charFreq.put(currChar,charFreq.getOrDefault(currChar, 0)+1);
		}
		int[] strIdx = new int[]{-1,-1};
		int minLength = str.length();
		int start = 0;
		int matched = 0;
		
		for(int end = 0; end < str.length() ; end++) {
			char rightChar = str.charAt(end);
			if(charFreq.containsKey(rightChar)) {
				charFreq.put(rightChar, charFreq.get(rightChar)-1);
				if(charFreq.get(rightChar)>=0) {
					matched++;
				}
				while(matched==pattern.length()) {
					int currSpan = end - start + 1;
					if(currSpan < minLength) {
						minLength = currSpan;
						strIdx[0] = start;
						strIdx[1] = end;
					}
					char leftChar = str.charAt(start++);
					if(charFreq.containsKey(leftChar)) {
						if(charFreq.get(leftChar)==0) {
							matched--;
						}
						charFreq.put(leftChar,charFreq.get(leftChar)+1);
					}
			    }
		     }
		}
		String result = "";
		if(strIdx[0]!=-1) {
			result=str.substring(strIdx[0], strIdx[1]+1);
		}
	    return result;
	  }
}
