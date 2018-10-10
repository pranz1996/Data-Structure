package linkedList;

public class DoublyLinkedList{
	
  // head node
  private static DoublyNode head = null;
	
	public static void main(String[] args) {
		
    // insertion method
    insert(1,10);
		insert(2,20);
		insert(2,30);
		insert(1,40);
		insert(5,50);
    
    // print the list
		print();
    
    // delele the element from list, passing specific position
		delete(1);
		System.out.println();
		print();
		delete(4);
		System.out.println();
		print();
		delete(2);
		System.out.println();
		print();
		
	}

  // insertion method
	private static void insert(int position, int element) {
		int k = 1 ;
    
    // checking the corner cases for position
		if(head == null || position > 0 && position <= lengthOfList()+1) {
			DoublyNode temp = head;
			DoublyNode node = new DoublyNode(element);

      // list is empty
      if(temp == null) {
				head = node;
      // insertion at first place
			} else if( position == 1) {
				temp.left = node;
				node.right = temp;
				head = node;
        
      // insertion at nth place except first place
			} else {
				while( temp != null && k  < position-1) {
					temp = temp.right;
					k++;
				}
				node.right = temp.right;
				node.left = temp;
				
        // if insertion at last place
				if(temp.right != null) {
					temp.right.left = node;
				}
				temp.right = node;
			}
		} else {
			System.out.println(" Cant insert due to wrong position ... ");
		}
	}
 
  // delete method
	private static void delete(int del) {
    
    // check corner cases for position to delete
		if(del > 0 && del <= lengthOfList()) {
			DoublyNode temp = head;
			int k = 1;
      
      // delete first node
			if(del == 1) {
				head = temp.right;
				head.left = null;
				temp = null;
        
      // delete nth node
			} else {
				while(temp != null && k < del-1) {
					temp = temp.right;
					k++;
				}
				DoublyNode toBeDelete = temp.right;
				temp.right = toBeDelete.right;
        
        // if last node to be deleted
				if(toBeDelete.right != null) {
					toBeDelete.left = temp;
				}
			}
		}
	}

  // length of the list
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
		
  // print the list
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
