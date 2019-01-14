package graph;

import java.util.*;

public class AdjLiist{
	
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	AdjLiist(int v){
		V = v ;
		adj  = new LinkedList[V];
		for(int i = 0 ; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public static void main(String[] args) {
		AdjLiist g = new AdjLiist(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		
	
		for(int i = 0 ; i < g.adj.length ; i++) {
			System.out.print( i + " -> ");
			if(g.adj[i] != null) {
				Iterator<Integer> it = g.adj[i].iterator();
				while(it.hasNext()) {
					System.out.print(it.next() + " ");
				}
			}
			System.out.println();
		}
	}
	
	private void addEdge(int i,int j) {
		adj[i].add(j);
	}
	
}