import java.util.*;
public class StringAnagram {
	public static List<Integer> findStringAnagrams(String str, String pattern) {
	    List<Integer> resultIndices = new ArrayList<Integer>();
	    // TODO: Write your code here
	    
	    int matched = 0;
	    int start = 0;
	    Map<Character,Integer> charFreq = loadMap(pattern);
	    for(int end = 0; end < str.length() ;end++) {
	    	char leftChar = str.charAt(end);
	    	if(charFreq.containsKey(leftChar)) {
	    		charFreq.put(leftChar, charFreq.get(leftChar)-1);
	    	}
	    	if(charFreq.get(leftChar)==0) {
	    		matched++;
	    	}
	    	if(matched==pattern.length()) {
	    		resultIndices.add(start);
	    	}
	    	//Now I deal with the condition when I do not have a match...
	    	char rightChar = str.charAt(start);
	    	if(charFreq.containsKey(rightChar)) {
	    		if(charFreq.get(rightChar)==0) {
	    			matched--;
	    		}
	    		charFreq.put(rightChar, charFreq.get(rightChar)+1);
	    	}
	    }
	    return resultIndices;
	  }
	
	private static Map<Character,Integer> loadMap(String pattern){
		Map<Character,Integer> charFreq = new HashMap<>();
	    for(int i = 0; i < pattern.length() ; i++) {
	    	charFreq.put(pattern.charAt(i), charFreq.getOrDefault(pattern.charAt(i),0)+1);
	    }
	    return charFreq;
	}
	
	
}
