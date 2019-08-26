package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteBetweenNodes {

	public static void main(String[] args) {
		
		String str = "adkckkdjfhaisdghilwheuxcnvasjdgkjsndcxliasdjfw";
		
	}

}


class UnweightedGraph {
	
	List<String> elems;
	List<ArrayList<Edge>> ne;
	
	public UnweightedGraph(String[] vertices, int[][] edges) {
		
		//elems = Arrays.asList(vertices);
		elems = new ArrayList<>();
		ne = new ArrayList<>();
		
		for(String s : vertices) {
			elems.add(s);
			ne.add(new ArrayList<Edge>());
		}
		
		for(int[] arr: edges) {
			
			Edge e = new Edge(arr[0], arr[1]);
			
			if(!ne.get(arr[0]).contains(e)) {
				ne.get(arr[0]).add(e);
			}
			
		}
		
		System.out.println(ne);
		
	}
	
	private static class Edge {
		int u;
		int v;
		
		public Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
		
		public boolean equals(Object o) {
			return u == ((Edge) o).u && v == ((Edge)o).v;
		}

		@Override
		public String toString() {
			return "Edge [u=" + u + ", v=" + v + "]";
		}
		
	}
	
}