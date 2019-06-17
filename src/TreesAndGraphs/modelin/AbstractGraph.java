package TreesAndGraphs.modelin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class AbstractGraph<V> implements Graph<V> {
	
	protected int size;
	protected List<V> vertices;
	protected List<List<Integer>> neighbors;
	
	public AbstractGraph(V[] vertices, int[][] edges) {
		
		this.vertices = new ArrayList<>();
		
		for(V v : vertices) {
			this.vertices.add(v);
		}
		
		neighbors = new ArrayList<>();
		
		for(int i = 0; i < vertices.length; i++) {
			neighbors.add(new ArrayList<>());
		}
		
		for(int i = 0; i < edges.length; i++) {
			neighbors.get(edges[i][0]).add(edges[i][1]);
		}
	}

	public AbstractGraph(List<V> vertices, int[][] edges) {
		this.vertices = vertices;
		
		neighbors = new ArrayList<>();
		
		for(int i = 0; i < vertices.size(); i++) {
			neighbors.add(new ArrayList<>());
		}
		
		for(int i = 0; i < edges.length; i++) {
			neighbors.get(edges[i][0]).add(edges[i][1]);
		}
		
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public List<V> getVertices() {
		return vertices;
	}
	
	@Override
	public V getVertex(int index) {
		return vertices.get(index);
	}
	
	@Override
	public int getIndex(V v) {
		return vertices.indexOf(v);
	}
	
	@Override
	public List<Integer> getNeighbors(int index) {
		return neighbors.get(index);
	}
	
	@Override
	public int getDegree(int index) {
		return neighbors.get(index).size();
	}
	
	@Override
	public void printEdges() {
		
		for(int i = 0; i < neighbors.size(); i++) {
			
			List<V> vers = new ArrayList<>();
			
			for(int e : neighbors.get(i)) {
				//System.out.format("[%d -> %d] ", i, e);
				vers.add(vertices.get(e));
			}
			
			System.out.format("[%s -> %s] ", vertices.get(i), vers);
			
			System.out.println();
		}
	}
	
	@Override
	public void clear() {
		vertices.clear();
		neighbors.clear();
	}
	
	@Override
	public boolean addVertex(V v) {
		return vertices.add(v);
	}
	
	@Override
	public boolean addEdge(int u, int v) {
		return neighbors.get(u).add(v);
	}
	
	public List<V> depthFirstSearch(int v) {
		boolean[] visited = new boolean[vertices.size()];
		visited[v] = true;
		List<Integer> nei = neighbors.get(v);
		List<V> items = new LinkedList<>();
		items.add(vertices.get(v));
		return depthFistSearch(nei, visited, items);
	}
	
	private List<V> depthFistSearch(List<Integer> nei, boolean[] visited, List<V> items) {
		for(int i: nei) {
			if(!visited[i]) {
				visited[i] = true;
				items.add(vertices.get(i));
				List<Integer> nei2 = neighbors.get(i);
				return depthFistSearch(nei2, visited, items);
			}
		}
		return items;
	}
	
	public List<V> breathFirstSearch(int v) {
		boolean[] visited = new boolean[vertices.size()];
		List<V> items = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		while(!queue.isEmpty()) {
			int currentV = queue.poll();
			items.add(vertices.get(currentV));
			for(int i: neighbors.get(currentV)) {
				if(!visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return items;
	}
	
	
	
	@Override
	public AbstractGraph<V>.Tree dfs(int v) {

		return null;
	}
	
	
	
	@Override
	public AbstractGraph<V>.Tree bfs(int v) {
		
		return null;
	}
	
	public class Tree {
		
	}
	

}
