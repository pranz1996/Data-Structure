package tree;

class theNode{
	char data;
	theNode left;
	theNode right;
	
	theNode(char item){
		data = item;
		left = right = null;
	}
}
public class InOrderPreOredrToTree {
	Node root;
	static int preIndex = 0;
	public static void main(String[] args) {
		InOrderPreOredrToTree tree = new InOrderPreOredrToTree();
		
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        
        int len = in.length;
        theNode root = tree.buildTree(in, pre, 0, len-1);
        
        System.out.println(" Inorder Traversal : ");
        tree.printInorder(root);
	}

	private void printInorder(theNode node) {
		if(node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	private theNode buildTree(char[] in, char[] pre, int inStart, int inEnd) {
		
		if(inStart > inEnd) {
			return null;
		}
	
		theNode tNode = new theNode(pre[preIndex++]);
		
		if(inStart == inEnd) {
			return tNode;
		}
		
		int inIndex = search(in, inStart, inEnd, tNode.data);
		
		tNode.left = buildTree(in, pre, inStart, inIndex-1);
		tNode.right = buildTree(in, pre, inIndex+1, inEnd);
		
		return tNode;
	}

	private int search(char[] in, int start, int end, int data) {
		
		int i;
		
		for(i = start;  i <= end ; i++) {
			if(in[i] == data) {
				return i;
			}
		}
		return i;
	}
}
