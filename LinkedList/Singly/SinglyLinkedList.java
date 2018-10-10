package linkedList;

public class SinglyLinkedList{

// head Node
	private static Node head = null;
	
	public static void main(String[] args) {
		
    // insertion call
    insert(1,10);
		insert(2,20);
		insert(2,30);
		insert(1,40);
		insert(5,50);
    
    // print a list
		print();
    
    // delete element, position passed parameter
		delete(1);
		System.out.println();
		print();
		delete(4);
		System.out.println();
		print();
		delete(2);
		System.out.println();
		print();
    
    // delete the list
		deleteTheList();
	}

  // insertion of element in list based at specific position
	private static void insert(int position, int element) {
  
    // checking corner cases for position
		if(head == null || position > 0 && position <= lengthOfList()+1) {
			Node node = new Node(element);
			Node temp = head; int k = 1 ;
      
      // if list is empty
			if(temp == null) {
				head = node;
        
      // insertion at first position
			} else if(position == 1){
				node.next = temp;
				head = node;	
        
      // insertion at nth place(except 1)
			} else {
				while( temp != null && k  < position-1) {
					temp = temp.next;
					k++;
				}
				Node nextOfTemp = temp.next;
				temp.next = node;
				
        // condition to check if  insertion at last
        if(nextOfTemp != null) {
					node.next = nextOfTemp;
				}
			}
		} else {
			System.out.println(" Cant insert due to wrong position ... ");
		}
	}



  // delete any element's method
	private static void delete(int del) {
  
    // cheking corner cases for position to delete
		if(del > 0 && del <= lengthOfList()) {
			Node temp = head;
			int k = 1;
      
      // position to delete is one
			if(del == 1) {
				head = temp.next;
				temp = null;
       // traverse upto node previous than to be deleted node
			} else {
				while(temp != null && k < del-1) {
					temp = temp.next;
					k++;
				}
				temp.next = temp.next.next;
			}
		}
	}


  //   delete the entire list
	private static void deleteTheList() {
		Node temp = head, dell;
		
		while(temp != null) {
			dell = temp.next;
			temp = null;
			temp = dell;
		}
		head = null;
	}

  // find length of the list
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
		
  // print the list  
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
}
