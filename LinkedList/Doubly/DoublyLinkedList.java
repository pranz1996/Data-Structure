package linkedList;

public class DoublyLinkedList{
	private static DoublyNode head = null;
	
	public static void main(String[] args) {
		insert(1,10);
		insert(2,20);
		insert(3,30);
		insert(4,40);
		insert(5,50);
		print();
		delete(4);
		System.out.println();
		print();
	}


	private static void delete(int del) {
		if(del > 0 && del <= lengthOfList()) {
			DoublyNode temp = head;
			int k = 1;
			if(del == 1) {
				head = temp.right;
				head.left = null;
				temp = null;
			} else {
				while(temp != null && k < del-1) {
					temp = temp.right;
					k++;
				}
				DoublyNode toBeDelete = temp.right;
				temp.right = toBeDelete.right;
				if(toBeDelete.right != null) {
					toBeDelete.right.left = temp;
				}
			}
		}
	}


	private static void insert(int position, int element) {
		int k = 1 ;
		if(head == null || position > 0 && position <= lengthOfList()+1) {
			DoublyNode temp = head;
			DoublyNode node = new DoublyNode(element);
			if(temp == null) {
				head = node;
			} else if( position == 1) {
				temp.left = node;
				node.right = temp;
				head = node;
			} else {
				while( temp != null && k  < position-1) {
					temp = temp.right;
					k++;
				}
				node.right = temp.right;
				node.left = temp;
				
				if(temp.right != null) {
					temp.right.left = node;
				}
				temp.right = node;
			}
		} else {
			System.out.println(" Cant insert due to wrong position ... ");
		}
	}

	private static int lengthOfList() {
		int count = 0;
		
		DoublyNode initial = head;
		if(initial == null) {
			return 0;
		} else {
			while(initial != null) {
				initial = initial.right;
				count++;
			}
		}
		return count;
	} 
		
	private static void print() {
		DoublyNode temp = head;
		if(temp == null) {
			System.out.println("list is empty");
		}
		else {
			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.right ;
			}
		}
	}
}
