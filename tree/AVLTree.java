package tree;

public class AVLTree {
	static AVLNode root ;
	public static void main(String[] aga) {
		root = null ;
		
		root = insert(root,10);
		root = insert(root,20);
		root = insert(root,30);
		root = insert(root,40);
		root = insert(root,50);
		root = insert(root,25);
		
		inorderPrint(root);
	}
	private static void inorderPrint(AVLNode node) {
		if(node != null) {
			inorderPrint(node.left);
			System.out.print(node.key+ " ");
			inorderPrint(node.right);
		}
	}
	private static AVLNode insert(AVLNode node, int key) {
		
		// 1. perform the normal BST insertion
		if(node == null) {
			return (new AVLNode(key));
		}
		
		if( key < node.key) {
			node.left = insert(node.left,key);
		}
		else if( key > node.key) {
			node.right = insert(node.right,key);
		}
		else { // duplicate keys not allowed
			return node;
		}
		
		// 2. update height 
		node.height = 1 + max(height(node.left),height(node.right));
		
		// 3. Get balance factor
		int balance = getBalance(node);
	
		// Left Left case
		if(balance > 1 && key < node.left.key) {
			return rightRotate(node);
		}
		// Right right case
		if(balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}
		// Left Right case
		if(balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		// right left case
		if(balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}
	private static AVLNode rightRotate(AVLNode y) {
		AVLNode x = y.left; 
		AVLNode T2 = x.right;
		
		// perform rotation
		x.right = y;
		y.left = T2;
		
		// update heights
		x.height = 1 + max(height(x.left),height(x.right));
		y.height = 1 + max(height(y.left),height(y.right));
		
		return x;
	}
	private static AVLNode leftRotate(AVLNode x) {
		AVLNode y = x.right;
		AVLNode T2 = y.left ;
		
		// Perform rotation
		y.left = x ;
		x.right = T2;
		
		// update heights
		x.height = 1 + max(height(x.left),height(x.right));
		y.height = 1 + max(height(y.left),height(y.right));
		
		// return new root
		return y;
	}
	private static int getBalance(AVLNode node) {
		if( node == null)
			return 0;
		return (height(node.left)-height(node.right));
	}
	private static int max(int a, int b) {
		return (a > b) ? a : b ;
	}
	private static int height(AVLNode N) {
		if ( N == null)
			return 0;
		return N.height;
	}
}
