import java.util.*;
public class SearchNextLetter {
	
	//Assume that the array is circular....
	public static char searchNextLetter(char[] letters, char key) {
	    // TODO: Write your code here
		
		return searchNextLetter(letters, 0, letters.length-1,key);
	  }
	
	private static char searchNextLetter(char[] letters, int low, int high, char key) {
		
		if(letters[low]  > key) {
			return letters[low];
		}
		
		if(letters[high] < key) {
			return letters[(high + 1) %letters.length];
		}
		
		int mid = low + (high - low)/2;
		
		if(letters[mid]==key) {
			return letters[(mid + 1) %letters.length];
		}
		
		if(letters[mid] < key) {
			return searchNextLetter(letters,mid + 1, high,key);
		}
		else {
			return searchNextLetter(letters,low,mid-1,key);
		}
		
	}
	
	public static void main(String[] args) {
	    System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
	    System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
	    System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
	    System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	  }
}
