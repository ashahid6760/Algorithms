import java.util.*;
class Graph {
	private final int V;
	private int E;
	public List<Integer>[] adj;
	public Graph(int v) {
		this.V = v;
		E = 0;
		adj =new ArrayList[V];
		for(int i = 0; i <v ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	public void addEdge(int u, int v) {
		adj[u].add(v);
		E++;
	}
}
public class CourseSchedule {
	static boolean isCycle = false;
	public static List <Integer> findOrder(int n, int[][] prerequisites) {
	      // Write your code here
	      //Create Graph...
		Graph graph = new Graph(n);
		for(int[] edge : prerequisites) {
			int parent = edge[1];
			int child = edge[0];
			graph.addEdge(parent, child);
		}
		
		Stack<Integer> order = new Stack<Integer>();
		boolean[] marked = new boolean[n];
		boolean[] onStack = new boolean[n];
		isCycle = false;
		for(int i = 0; i < n ; i++) {
			if(!marked[i]) {
				dfs(graph,marked,onStack,order,i);
			}
		}
		List<Integer> finalOrder = new ArrayList<>();
		for(int i = 0; i <n; i ++) {
			finalOrder.add(order.pop());
		}
	      return finalOrder;
	 }
	
	public static void dfs(Graph g, boolean[] marked,boolean[] onStack,Stack order, int v) {
		marked[v] = true;
		onStack[v] = true;
		for(int w : g.adj[v]) {
			if(!marked[w]) {
				dfs(g,marked,onStack,order,w);
			}
		}
		onStack[v] = false;
		order.push(v);
	}
	

	  public static void main(String[] args){
	      // Driver code

	      int[]n = {4, 5, 2, 4, 7};
	      int[][][]prerequisites = {
	      {{1, 0}, {2, 0}, {3, 1}, {3, 2}}, 
	      {{1, 0}, {2, 0}, {3, 1}}, 
	      {{1, 0}}, {{1, 0}, {2, 0}, {3, 1}, {3, 2}}, 
	      {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}}};
	      for(int i=0; i<n.length; i++){
	        System.out.print(i+1);
	        System.out.println(".\tPrerequisites: "+Arrays.deepToString(prerequisites[i])+"\n\tTotal number of courses, n = "+n[i]);
	        List<Integer> result = findOrder(n[i], prerequisites[i]);
	        System.out.println("\tValid courses order: " + result);
	      }
	      
	    }
	
}
