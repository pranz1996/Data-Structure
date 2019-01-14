package graph;

public class AdjMatrix {
	private int adjmat[][];
	private int V ;
	void adjMatrix(int v){
		this.V = v ;
		adjmat = new int[v][v];
	}
	public static void main(String[] args) {
		AdjMatrix am = new AdjMatrix();
		am.adjMatrix(4);
		for(int i = 0 ; i < 4 ; i++) {
			for( int j = 0 ; j < 4 ; j++) {
				am.adjmat[i][j] = 0 ;
			}
		}
		
		am.addEdge(0, 1);
		am.addEdge(0, 2);
		am.addEdge(1, 2);
		am.addEdge(2, 0);
		am.addEdge(2, 3);
		am.addEdge(3, 3);
		
		for( int i =0 ; i < 4 ; i++) {
			for( int j = 0 ; j < 4 ; j++) {
				System.out.print(am.adjmat[i][j] + " ");
			}
			System.out.println();
		}
	}
	private void addEdge(int i, int j) {
		adjmat[i][j] = adjmat[j][i] = 1 ; 
	}
}
