package linkedList;

public class SinglyLinkedList{
	private static Node head = null;
	
	public static void main(String[] args) {
		insert(1,10);
		insert(2,20);
		insert(2,30);
		insert(1,40);
		insert(5,50);
		print();
		delete(1);
		System.out.println();
		print();
		delete(4);
		System.out.println();
		print();
		delete(2);
		System.out.println();
		print();
		deleteTheList();
	}

	private static void delete(int del) {
		if(del > 0 && del <= lengthOfList()) {
			Node temp = head;
			int k = 1;
			if(del == 1) {
				head = temp.next;
				temp = null;
			} else {
				while(temp != null && k < del-1) {
					temp = temp.next;
					k++;
				}
				temp.next = temp.next.next;
			}
		}
	}

	private static void deleteTheList() {
		Node temp = head, dell;
		
		while(temp != null) {
			dell = temp.next;
			temp = null;
			temp = dell;
		}
		head = null;
	}

	private static void insert(int position, int element) {
		if(head == null || position > 0 && position <= lengthOfList()+1) {
			Node node = new Node(element);
			Node temp = head; int k = 1 ;
			if(temp == null) {
				head = node;
			} else if(position == 1){
				node.next = temp;
				head = node;	
			} else {
				while( temp != null && k  < position-1) {
					temp = temp.next;
					k++;
				}
				Node nextOfTemp = temp.next;
				temp.next = node;
				if(nextOfTemp != null) {
					node.next = nextOfTemp;
				}
			}
		} else {
			System.out.println(" Cant insert due to wrong position ... ");
		}
	}

	private static int lengthOfList() {
		int count = 0;
		
		Node initial = head;
		if(initial == null) {
			return 0;
		} else {
			while(initial != null) {
				initial = initial.next;
				count++;
			}
		}
		return count;
	} 
		
	private static void print() {
		Node temp = head;
		if(temp == null) {
			System.out.println("list is empty");
		}
		else {
			while(temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next ;
			}
		}
	}
	
	private static void ReverseIterative() {
		Node a = head, b = head, c = null;
		while( b != null) {
			a = b.next;
			b.next = c;
			c = b;
			b = a;
		}
		// print(c);
	}
	
	private static SinglyNode ReversePrintRecursive(SinglyNode node) {
		SinglyNode newNode;
		
		if(node.next == null) {
			return node;
		}
		
		newNode = ReversePrintRecursive(node.next);
		
		node.next.next = node;
		node.next = null;
		return newNode;
	}
}
