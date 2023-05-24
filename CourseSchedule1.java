import java.util.*;

public class CourseSchedule1 {
	static boolean isCyclic;
	static class Graph {
		private int v;
		private int E;
		public List<Integer>[] adj;
		public Graph(int v) {
			this.v = v;
			E = 0;
			adj = new ArrayList[v];
			for(int i = 0; i < v; i++) {
				adj[i] = new ArrayList();
			}
		}
		public void addEdge(int u, int v) {
			adj[u].add(v);
		}
	}
	
	 public static boolean canFinish(int numCourses, int[][] prerequisites) {
	        // Write your code here
		 Stack<Integer> order = new Stack<>();
		 boolean[] marked = new boolean[numCourses];
		 boolean[] onStack = new boolean[numCourses];
		 //Create Graph...
		 Graph graph = new Graph(numCourses);
		 for(int[] edge : prerequisites) {
			 int parent = edge[1];
			 int child = edge[0];
			 graph.adj[parent].add(child);
		 }
		 isCyclic = false;
		 for(int i =0; i < numCourses ; i++) {
			 if(!marked[i]) {
				 dfs(graph, onStack, marked, i);
			 }
		 }
		 return !isCyclic;
	  }
	 
	 private static void dfs(Graph graph,boolean[] onStack,boolean[] marked,int v) {
		 marked[v] = true;
		 onStack[v] = true;
		 for(int w : graph.adj[v]) {
			 if(!marked[w]) {
				 dfs(graph,onStack,marked,w);
			 }
			 else {
				 isCyclic = true;
			 }
		 }
		 onStack[v] = false;
	 }
	 
	   public static void main(String[] args) {

	        int[][][] prereq = {
	                  {{1, 0}, {2, 1}},
	                  {{1, 0}, {0, 1}},
	                  {{1, 0}, {2, 1}, {3, 2}, {4, 3}},
	                  {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {0, 4}},
	                  {{2, 0}, {2, 1}, {3, 2}, {4, 2}, {3, 1}}
	        };
	        int[] courses = {3, 2, 10, 5, 5};

	        for(int i=0;i<courses.length;i++){
	            System.out.println((i + 1)+ ".\tNumber of courses: "+ courses[i]);
	            System.out.println("\tNumber of pre-requisites: "+ Arrays.deepToString(prereq[i]));
	            System.out.println("\tOutput: "+ canFinish(courses[i], prereq[i]));
	        }
	      }

}
