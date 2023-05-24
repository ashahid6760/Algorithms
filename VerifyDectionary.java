import java.util.*;
class VerifyDectionary {
  public static boolean verifyAlienDictionary(String[] words, String order) {
    // Write your code here
	  Map<Character,Integer> orderIdx = new HashMap<Character,Integer>();
	  for(int i = 0; i < order.length() ; i++) {
		  orderIdx.put(order.charAt(i),i);
	  }
	  for(int i = 0; i < words.length-1 ; i++) {
		  String currWord = words[i];
		  String nextWord = words[i+1];
		  int idx = 0;
		  while(idx < currWord.length()) {
			  if(idx==nextWord.length()) {
				  return false;
			  }
			  if(currWord.charAt(idx)!=nextWord.charAt(idx)) {
				  char c1 = currWord.charAt(idx);
				  char c2 = nextWord.charAt(idx);
				  if(orderIdx.get(c1) > orderIdx.get(c2)) {
					  return false;
				  }
				  break;
			  }
		  }
	  }
    return true;
  }
}


