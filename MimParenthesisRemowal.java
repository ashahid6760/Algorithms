import java.util.*;
public class MimParenthesisRemowal {
	static class Idx_info {
		char symbol;
		int idx;
		public Idx_info(char symbol, int idx) {
			this.symbol = symbol;
			this.idx = idx;
		}
	}
	public static String minRemoveParentheses(String s) {

        // Your code will replace the placeholder return statement.
		Stack<Idx_info> stack = new Stack<>();
		for(int i=0; i < s.length() ; i++) {
			char currChar = s.charAt(i);
			if(!stack.isEmpty()&&stack.peek().symbol=='('&&currChar==')') {
				stack.pop();
			}
			else if(currChar==')'||currChar=='(') {
				stack.push(new Idx_info(currChar,i));
			}
		}
		Stack<Integer> idx_remove = new Stack<Integer>();
		while(!stack.isEmpty()) {
			idx_remove.push(stack.pop().idx);
		}
		
		StringBuilder newString = new StringBuilder();
		for(int i = 0; i < s.length() ; i++) {
			
			if(!idx_remove.isEmpty()&& i==idx_remove.peek()) {
				idx_remove.pop();
				continue;
			}
			newString.append(s.charAt(i));
		}
        return newString.toString();
    }

}
