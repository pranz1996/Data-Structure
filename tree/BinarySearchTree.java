package tree;

import java.util.*;

public class BinarySearchTree {
	static Scanner scan = new Scanner(System.in);
	static Scanner scan1 = new Scanner(System.in);
	
	public static void main(String[] args) {

		Node root = new Node();
		root = null;
		char f ;
		do {
			System.out.println("Enter element to insert");
			Node temp  = new Node();
			temp.data = scan.nextInt();
			if(root == null) {
				root = temp ;
			}
			else {
				insert(root,temp);
			}
		System.out.print(" Enter y to continue .. ");
		String p = scan1.nextLine();
		f = p.charAt(0);
		}while(f == 'y');
		System.out.println();
		System.out.print("inorder");
		inorder(root);
		System.out.println();
		System.out.print("preorder");
		preorder(root);
		System.out.println();
		System.out.print("postorder");
		postorder(root);
		System.out.println();
		
			
	}
	
	private static void insert(Node root, Node temp) {
		if(temp.data > root.data) {
			if(root.right == null) {
				root.right = temp;
			} else {
				insert(root.right,temp);
			}
		}else {
			if(root.left == null) {
				root.left = temp;
			} else {
				insert(root.left,temp);
			}
		}
	}
	
	private static void preorderNonReccursive(Node root) {
		Stack<Node> st = new Stack<>();
		while(true) {
			while(root != null) {
				System.out.print(root + " ");
				st.push(root);
				root = root.left;
			}
			if(st.isEmpty()) {
				break;
			}
			root = st.pop();
			root = root.right;
		}
	}
	
	private static void inorderNonReccursive(Node root) {
		System.out.println();
		System.out.println(root.data);
		Stack<Node> st = new Stack<>();
		while(true) {
			while(root != null) {
				st.push(root);
				root = root.left;
			}
			if(st.isEmpty()) {
				break;
			}
			root = st.pop();
			System.out.print(root);
			root = root.right;
		}	
	}

	private static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	
	
	private static void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	private static void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	
}
