package graph;

import java.util.*;

public class DFSList {

	private int V ;
	private LinkedList<Integer> adj[];
	
	DFSList(int v){
		V = v ;
		adj = new LinkedList[v];
		for( int i = 0 ; i < v ; i++) {
		adj[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int v , int w) {
		adj[v].add(w);
	}
		
	public static void main(String[] args) {
		DFSList g = new DFSList(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.DFS();
	}

	private void DFS() {
		boolean visited[] = new boolean[V];
		for(int i = 0 ; i < V ; i++)
			visited[i] = false;
		
		for(int i = 0 ; i < V ; i++) {
			if(visited[i] == false)
				DFSUtil(i,visited);
		}
 	}

	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v+ " ");
		
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n,visited);
			}
		}
	} 

}
