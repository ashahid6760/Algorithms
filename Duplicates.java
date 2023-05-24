import java.util.*;
public class Duplicates {
	

	public static String removeDuplicates(String s) {
		// Write your code here
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length() ; i++) {
			char currChar = s.charAt(i);
			if(stack.isEmpty()||stack.peek()!=currChar) {
				stack.push(currChar);
			}
			else {
				stack.pop();
			}
		}
		char[] newStr = new char[stack.size()];
		for(int i = newStr.length-1; i >=0 ; i--) {
			newStr[i] = stack.pop();
		}
		return new String(newStr);
    }
	
}
