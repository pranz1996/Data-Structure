package tree;

public class Node{
	int data;
	public Node left;
	public Node right;
	
	public Node() {
		this.data = 0;
		left = null;
		right = null;
	}
	
	public Node(int data) {
		this.data = data;
	}
}

