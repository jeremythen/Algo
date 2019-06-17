package TreesAndGraphs.modelin;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {

	public static void main(String[] args) {
		
		double d = Double.POSITIVE_INFINITY;
		
		System.out.println(d);

		UnweightedGraph<String> uGraph = new UnweightedGraph<>(getVertices(), getEdges());
		
		uGraph.printEdges();
		
		System.out.println();
		System.out.println();
		
		System.out.println(uGraph.depthFirstSearch(3));
		
		System.out.println();
		System.out.println();
		
		System.out.println(uGraph.breathFirstSearch(3));
		
	}

	public static List<String> getVertices() {
		List<String> vertices = new ArrayList<>();
		vertices.add("Seattle");
		vertices.add("San Francisco");
		vertices.add("Los Angeles");
		vertices.add("Denver");
		vertices.add("Kansas City");
		vertices.add("Chicago");
		vertices.add("Boston");
		vertices.add("New York");
		vertices.add("Atlanta");
		vertices.add("Miami");
		vertices.add("Dallas");
		vertices.add("Houston");
		return vertices;
	}
	
	public static int[][] getEdges() {
		int[][] edges = { 
				{ 0, 1 }, { 0, 3 }, { 0, 5 }, 
				{ 1, 0 }, { 1, 2 }, { 1, 3 }, 
				{ 2, 1 }, { 2, 3 }, { 2, 4 }, { 2, 10 }, 
				{ 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 3, 5 }, 
				{ 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 }, { 4, 8 }, { 4, 10 }, 
				{ 5, 0 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 }, 
				{ 6, 5 }, { 6, 7 }, { 7, 4 },
				{ 7, 5 }, { 7, 6 }, { 7, 8 }, 
				{ 8, 4 }, { 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 }, 
				{ 9, 8 }, { 9, 11 },
				{ 10, 2 }, { 10, 4 }, { 10, 8 }, { 10, 11 }, 
				{ 11, 8 }, { 11, 9 }, { 11, 10 } };
		return edges;
	}
	
	public static int[][] getMatrix() {
		int[][] matrix = {
				
				/*0*/	{0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
				/*1*/	{1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				/*2*/	{0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0},
				/*3*/	{1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
				/*4*/	{0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0},
				/*5*/	{1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0},
				/*6*/	{0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
				/*7*/	{0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0},
				/*8*/	{0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1},
				/*9*/	{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
				/*10*/	{0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
				/*11*/	{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
						
				};
		return matrix;
	}

}
