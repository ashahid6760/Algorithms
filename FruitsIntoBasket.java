import java.util.*;
public class FruitsIntoBasket {
	 public static int findLength(char[] arr) {
		    // TODO: Write your code here
		 Set<Character> fruitType = new HashSet<>();
		 int start = 0;
		 int maxFruits = 0;
		 for(int end = 0;  end < arr.length ; end++) {
			 if(!fruitType.contains(arr[end])) {
				 fruitType.add(arr[end]);
			 }
			 if(fruitType.size() >2) {
				 fruitType.remove(arr[start]);
				 start++;
			 }
			 maxFruits = Math.max(maxFruits, end-start + 1);
		 }
		    return maxFruits;
   }
	 
	 public static void main(String[] args) {
		    System.out.println("Maximum number of fruits: " + 
		                          findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
		    System.out.println("Maximum number of fruits: " + 
		                          findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
		  }
}
