package com.graphs.dfs;

public class DFS {

	public static void main(String[] args) {
		Graph graph = new Graph(GraphType.UNDIRECTED);
		graph.addVertex('a'); // 0
		graph.addVertex('b'); // 1
		graph.addVertex('c'); // 2
		graph.addVertex('d'); // 3
		graph.addVertex('e'); // 4
		graph.addVertex('f'); // 5
		graph.addVertex('g'); // 6
		graph.addVertex('h'); // 7
		
		graph.addEdge(0,  1); // a->b
		graph.addEdge(1,  2); // b->c
		graph.addEdge(1,  7); // b->h
		graph.addEdge(2,  3); // c->d
		graph.addEdge(2,  4); // c->e
		graph.addEdge(4,  5); // e->f
		graph.addEdge(4,  6); // e->g
		graph.addEdge(4,  7); // e->h
		graph.addEdge(4,  2); // e->c
		graph.addEdge(7,  1); // h->b
		
		System.out.println(" ============= adjacency matrix ===================== ");
		for (int i = 0 ; i < graph.vertexCount ; i++) {
			for (int j = 0 ; j < graph.vertexCount ; j++) {
				System.out.print(graph.adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(" ============== recursive dfs =============== ");
		// dfs algorithm
		graph.recursiveDFS(0);
		
		// reset graph
		graph.resetGraph();
		
		System.out.println(" ============== iterative dfs =============== ");
		// dfs algorithm
		graph.iterativeDFS();
	}
	
	

}
