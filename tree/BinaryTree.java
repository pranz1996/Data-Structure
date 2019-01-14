package tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BinaryTree {
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
	//	System.out.print("inorder");
	//	inorder(root);
	/*	System.out.print("inorder iterative ");
		inorderNonReccursive(root);
		System.out.println();
		System.out.print("preorder iterative ");
		preorderNonReccursive(root);
		System.out.println();
	*///	System.out.print("preorder");
	/*	preorder(root);
		System.out.println();
		System.out.print("postorder");
		postorder(root);
		System.out.println();
		System.out.println(" Level order traversal : ");
		levelOrderTraversal(root);
	*/	
		System.out.println(zigzagLevelOrder(root));
		
	/*	System.out.println(" New Method preOrder : ");
		List<Integer> list = preOrderTravesal(root);
		System.out.println(list);
	*/
		
	}

	private static void levelOrderTraversal(Node root) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(root);
		while(!qu.isEmpty()) {
			Node temp = qu.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				qu.add(temp.left);
			}
			if(temp.right != null) {
				qu.add(temp.right);
			}
		}
	}
	
	private static List<List<Integer>> zigzagLevelOrder(Node root){

		List<List<Integer>> traversal = new LinkedList<List<Integer>>();
	    List<Integer> temp = new LinkedList<Integer>();
	     
	    Stack<Node> currentLevel = new Stack<>();
	    Stack<Node> nextLevel = new Stack<>();
	    
	    currentLevel.push(root);
	    boolean leftToRight = true;
	    
	    while(!currentLevel.isEmpty()) {
	    	Node node = currentLevel.pop();
	    	temp.add(node.data);
	    	
	    	if(leftToRight) {
	    		if(node.left != null) {
	    			nextLevel.push(node.left);
	    		}
	    		if(node.right != null) {
	    			nextLevel.push(node.right);
	    		}
	    	} else {
	    		if(node.right != null) {
	    			nextLevel.push(node.right);
	    		}
	    		if(node.left != null) {
	    			nextLevel.push(node.left);
	    		}
	    	}
	    	if(currentLevel.empty()) {
	    		leftToRight = !leftToRight ;
	    		traversal.add(temp);
	    		temp.clear();
	    		currentLevel.addAll(nextLevel);
	    		nextLevel.clear();
	    	}
	    }
		return traversal;
	}
	
	
	
	private static void insert(Node root, Node temp) {
		Scanner s = new Scanner(System.in);
		System.out.print(" Where to insert: l or r of " + root.data + " : ");
		char c = s.nextLine().charAt(0);
		if(c == 'r') {
			if(root.right == null) {
				root.right = temp;
			} else {
				insert(root.right,temp);
			}
		}
		if(c == 'l'){
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
			if(st.empty()) {
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
	
	private static List<Integer> preOrderTravesal(Node root){
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}else {
			while(root != null) {
				list.add(root.data);
				List<Integer> list1 = preOrderTravesal(root.left);
				list.addAll(list1);
				List<Integer> list2 = preOrderTravesal(root.right);
				list.addAll(list2);
			}
		}
		return list;
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
