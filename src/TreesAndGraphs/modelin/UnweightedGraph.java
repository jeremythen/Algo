package TreesAndGraphs.modelin;

import java.util.ArrayList;
import java.util.List;

public class UnweightedGraph<V> extends AbstractGraph<V> {
	
	public UnweightedGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	public UnweightedGraph(List<V> vertices, int[][] edges) {
		super(vertices, edges);
	}
}
