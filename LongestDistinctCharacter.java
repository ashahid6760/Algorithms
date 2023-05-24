import java.util.*;
public class LongestDistinctCharacter {
	
	  public static int findLength(String str) {
		    // TODO: Write your code here
		 int start = 0;
		 int maxLength = 1;
		 Map<Character,Integer> charSet = new HashMap<>();
		 
		 for(int end = 0; end < str.length() ; end++) {
			 char rightChar = str.charAt(end);
			 if(charSet.containsKey(rightChar)) {
				 start = Math.max(end, charSet.get(rightChar) + 1);
			 }
			 charSet.put(rightChar, end);
			 maxLength = Math.max(maxLength, end - start + 1);
			 }
		    return maxLength;
		}

}
