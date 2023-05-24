import java.util.*;

class CompilationOrder {
	static boolean isCycle = false;
    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies){
        // Write your code here
    	//Make  a graph...
    	List<Character> sortedOrder = new ArrayList<>();
    	HashMap<Character,List<Character>> graph = new HashMap<>();
    	
    	//Initialize the graph..
    	for(List<Character> edge :dependencies) {
    		char parent = edge.get(0);
    		char child = edge.get(1);
    		graph.put(parent, new ArrayList<>());
    		graph.put(child, new ArrayList<>());
    	}
    	
    	for(List<Character> edge : dependencies) {
    		char u = edge.get(0);
    		char v = edge.get(1);
    			graph.get(u).add(v);
    		
    	}
    	for(char key : graph.keySet()) {
    		System.out.println(key);
    	}
    	Map<Character,Boolean> visited = new HashMap<>();
    	for(char key: graph.keySet()) {
    		visited.put(key, false);
    	}
    	
    	Map<Character,Boolean> onStack = new HashMap<>();
    	for(char key : graph.keySet()) {
    		onStack.put(key, false);
    	}
    	Stack<Character> order = new Stack<>();
    	isCycle=false;
    	for(char key : graph.keySet()) {
    		if(!visited.get(key)) {
    			dfs(key,graph,visited,onStack,order);
    		}
    	}
    	for(char x : order) {
    		sortedOrder.add(x);
    	}
        return sortedOrder;
    }
    
    private static void dfs(char v,Map<Character,List<Character>> graph, Map<Character,Boolean> visited,Map<Character,Boolean> onStack, Stack<Character> order) {
    	visited.put(v,true);
    	onStack.put(v, true);
    	for(char w :graph.get(v)) {
    		if(isCycle) {
    			return;
    		}
    		else if(!visited.get(w)) {
    			dfs(w,graph,visited,onStack,order);
    		}
    		else if(onStack.get(w))  {
    			isCycle = true;
    		}
    	}
    	if(!isCycle) {
    	order.push(v);
    	onStack.put(v, false);
    	}
    }
    public static String repeat(String str, int pValue){
        String out = "";
        for(int i = 0; i < pValue; i++)
        {
            out += str;
        }
        return out;
    }
    public static void main( String args[] ) {
        List<List<List<Character>>> inputs = Arrays.asList(
            Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B')),
            Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'B'), Arrays.asList('E', 'B'), Arrays.asList('E', 'D'),Arrays.asList('E', 'C'), Arrays.asList('F', 'D'), Arrays.asList('F', 'E'), Arrays.asList('F', 'C')),
            Arrays.asList(Arrays.asList('A', 'B'), Arrays.asList('B', 'A')),
            Arrays.asList(Arrays.asList('B', 'C'), Arrays.asList('C', 'A'), Arrays.asList('A', 'F')),
            Arrays.asList(Arrays.asList('C', 'C'))
        );
        ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<ArrayList<ArrayList<Character>>>();
    for(int j = 0; j < inputs.size(); j++)
    {
      dependencies.add(new ArrayList<ArrayList<Character>>());
      for(int k = 0; k < inputs.get(j).size(); k++)
      {
        dependencies.get(j).add(new ArrayList<Character>());
        for(int g = 0; g < inputs.get(j).get(k).size(); g++)
        {
          dependencies.get(j).get(k).add(inputs.get(j).get(k).get(g));
        }
      }
    }
        for(int i = 0; i < dependencies.size(); i++){
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(repeat("-", 100));
        }
    }
}