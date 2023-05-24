import java.util.*;
public class AlienDictionary {
	static boolean isCyclic;
	public static String alienOrder(List<String> words) {
	    // Write your code here
		
		Map<Character,List<Character>> graph = new HashMap<>();
		Map<Character,Boolean> visited = new HashMap<>();
		Map<Character,Boolean> onStack = new HashMap<>();
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < words.size()-1;i++) {
			String currWord = words.get(i);
			String nextWord = words.get(i+1);
			int i1 = 0;
			int i2 = 0;
			while(i1 < currWord.length() && i2 < nextWord.length()) {
				
				if(currWord.charAt(i1)==currWord.charAt(i2)) {
					i1++;
					i2++;
				}
				
			}
		}
		
		return "";
	   }
}
