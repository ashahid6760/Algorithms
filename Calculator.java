import java.util.*;
public class Calculator {
	public static int calculator(String expression) {

        // Write your code here
		int num = 0;
		int sign = 1;
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < expression.length() ; i++) {
			char c = expression.charAt(i);
			if(Character.isDigit(c)) {
				num = num*10 +  Character.getNumericValue(c);
			}
			else if(c=='+'||c=='-') {
				result = result + num*sign;
				if(c=='+') {
					sign=1;
				}
				else {
					sign=-1;
				}
				num=0;
			}
			else if(c=='(') {
				stack.push(result);
				stack.push(sign);
				result =0;
				sign = 1;
			}
			else if(c==')') {
				result = result + num*sign;
				int sign_pop = stack.pop();
				result = result*sign_pop;
				result = result + stack.pop();
				num=0;
			}
		}
    
        return result+num*sign;
	}
	private static int calculator(String expression, int idx) {
	
	}
}
