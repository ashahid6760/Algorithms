import java.util.*;

public class BasicCalculator {
	public int calculate(String s) {
		int result = 0;
		int currNumber = 0;
		char operation = '+';
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < s.length() ; i++) {
			char currChar = s.charAt(i);
			if(Character.isDigit(currChar)){
				currNumber += currNumber * 10 + (currChar - '0');
			}
			if(!Character.isDigit(currChar)&&!(Character.isWhitespace(currChar)||i==s.length()-1)){
				if(operation=='+') {
					stack.push(currNumber);
				}
				else if(operation=='-') {
					stack.push(-currNumber);
				}
				else if(operation=='*') {
					stack.push(stack.pop()*currNumber);
				}
				else if(operation=='/') {
					stack.push(stack.pop()/currNumber);
				}
				operation = currChar;
				currNumber = 0;
			}
			while(!stack.isEmpty()) {
				result += stack.pop();
			}
		}
		return result;
	}
}
